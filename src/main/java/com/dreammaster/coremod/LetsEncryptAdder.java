package com.dreammaster.coremod;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Adds the Let's encrypt X3 root SSL certificate to fix HTTPS connection problems. <br>
 *
 * Taken from: <a href=
 * "https://github.com/Cloudhunter/LetsEncryptCraft/blob/master/src/main/java/uk/co/cloudhunter/letsencryptcraft/LetsEncryptAdder.java">LetsEncryptCraft</a>
 * <br>
 * Original code license:
 * 
 * <pre>
 * MIT License
 *
 * Copyright (c) 2018 Cloudhunter
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * </pre>
 */
public class LetsEncryptAdder {

    private static boolean alreadyAdded = false;
    private static final Logger LOGGER = LogManager.getLogger(LetsEncryptAdder.class);

    private static void trustLetsEncryptRoots() throws Exception {
        final InputStream cert1 = Objects.requireNonNull(
                LetsEncryptAdder.class.getResourceAsStream("/assets/letsencryptroot/isrg-root-x1.der"),
                "Embedded let's encrypt certificate X1 not found");
        final InputStream cert2 = Objects.requireNonNull(
                LetsEncryptAdder.class.getResourceAsStream("/assets/letsencryptroot/isrg-root-x2.der"),
                "Embedded let's encrypt certificate X2 not found");

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        Path ksPath = Paths.get(System.getProperty("java.home"), "lib", "security", "cacerts");
        keyStore.load(Files.newInputStream(ksPath), "changeit".toCharArray());

        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        keyStore.setCertificateEntry("isrg-root-x1", cf.generateCertificate(new BufferedInputStream(cert1)));
        keyStore.setCertificateEntry("isrg-root-x2", cf.generateCertificate(new BufferedInputStream(cert2)));

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        SSLContext.setDefault(sslContext);
    }

    public static void addLetsEncryptCertificates() {
        if (alreadyAdded) {
            return;
        }

        String version = System.getProperty("java.version");
        Pattern p = Pattern.compile("^(\\d+\\.\\d+).*?_(\\d+).*");
        Matcher matcher = p.matcher(version);
        String majorVersion;
        int minorVersion;
        if (matcher.matches()) {
            majorVersion = matcher.group(1);
            minorVersion = Integer.parseInt(matcher.group(2));
        } else {
            majorVersion = "1.7";
            minorVersion = 110;
            LOGGER.info("Regex to parse Java version failed - applying anyway.");
        }

        switch (majorVersion) {
            case "1.7":
                if (minorVersion >= 111) {
                    LOGGER.info("Not running as Java version is at least Java 7u111.");
                    alreadyAdded = true;
                    return;
                }
                break;
            case "1.8":
                if (minorVersion >= 101) {
                    LOGGER.info("Not running as Java version is at least Java 8u101.");
                    alreadyAdded = true;
                    return;
                }
                break;
        }

        String body = "";
        try {
            LOGGER.info("Adding Let's Encrypt certificate...");
            LetsEncryptAdder.trustLetsEncryptRoots();
            LOGGER.info("Done, attempting to connect to https://helloworld.letsencrypt.org...");
            URL url = new URL("https://helloworld.letsencrypt.org");
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            InputStream inputStream = conn.getInputStream();
            body = IOUtils.toString(inputStream);
        } catch (Exception e) {
            LOGGER.error(
                    "An error occurred whilst adding the Let's Encrypt root certificate. I'm afraid you wont be able to access resources with a Let's Encrypt certificate D:",
                    e);
        }

        if (body.isEmpty()) {
            LOGGER.error(
                    "An unknown error occurred whilst adding the Let's Encrypt root certificate. I'm afraid you may not be able to access resources with a Let's Encrypt certificate D:");
        } else {
            LOGGER.info("Done - you are now able to access resources with a Let's Encrypt certificate :D");
        }
        alreadyAdded = true;
    }
}
