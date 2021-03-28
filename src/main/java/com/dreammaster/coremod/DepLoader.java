package com.dreammaster.coremod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import cpw.mods.fml.relauncher.IFMLCallHook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DepLoader implements IFMLCallHook {
    private File mcLocation;
    private static final Logger LOGGER = LogManager.getLogger(DepLoader.class);
    private DownloadProgressDialog dialog = null;

    public static class Dependency {
        private String url;
        private String path;
        private boolean disabled;
        private transient boolean found;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isFound() {
            return found;
        }

        public void setFound(boolean found) {
            this.found = found;
        }
    }

    private class Downloader implements Runnable {
        List<Dependency> deps;
        Exception e = null;

        Downloader(List<Dependency> deps) {
            this.deps = deps;
        }

        @Override
        public void run() {
            try {
                if (deps.size() > 0) {
                    for (Dependency dep : deps) {
                        if (!dep.isDisabled() && !dep.isFound()) {
                            download(dep);
                        }
                        if (DreamCoreMod.downloadOnlyOnce)
                            dep.setDisabled(true);
                    }
                }
            } catch (Exception ex) {
                e = ex;
            }
        }
    }

    @Override
    public void injectData(Map<String, Object> data) {
        mcLocation = (File) data.get("mcLocation");
    }

    @Override
    public Void call() throws Exception {
        // get dep info
        Gson g = new GsonBuilder().disableHtmlEscaping().create();
        List<Dependency> deps;
        final File config = new File(mcLocation, "config" + File.separator + "dependencies.json");
        if (!config.exists()) {
            LOGGER.info("No dependencies found.");
            return null;
        }
        try (FileReader fr = new FileReader(config)) {
            deps = g.fromJson(fr, new TypeToken<List<Dependency>>() {}.getType());
        }
        if (deps.size() == 0) {
            LOGGER.info("No dependencies found.");
            return null;
        }
        LOGGER.info("Found {} dependencies.", deps.size());

        // check deps
        boolean downloaded = false;
        Thread netThread = null;
        try {
            dialog = new DownloadProgressDialog();
            Thread mainThread = Thread.currentThread();
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    mainThread.interrupt();
                }
            });
            precheck(deps);
            if (deps.size() > 0) {
                LOGGER.info("{} dependencies to download.", deps.size());
                downloaded = true;
                dialog.setJobCount(deps.size());
                SwingUtilities.invokeLater(() ->dialog.setVisible(true));

                final Downloader downloader = new Downloader(deps);

                netThread = new Thread(downloader);
                netThread.setDaemon(true);
                netThread.start();
                netThread.join();

                if (downloader.e != null) {
                    throw new Exception("Download error", downloader.e);
                }
            }
        } catch (InterruptedException e) {
            try {
                Files.delete(new File(mcLocation, ".__gtnh_download_temp__").toPath());
            } catch (IOException e2) {
                // ignore
            }
            if (dialog != null) {
                dialog.dispose();
            }
            netThread.interrupt();
            // wait for up to 0.5 seconds
            netThread.join(500);
            throw new RuntimeException("Launch cancelled by user");
        } catch (Exception e) {
            if (dialog != null) {
                dialog.dispose();
            }
            JOptionPane.showMessageDialog(null, "Download of additional files failed. Please refer to log for more info.", DownloadProgressDialog.WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Download of additional files failed. Please refer to log for more info.", e);
        } finally {
            if (DreamCoreMod.downloadOnlyOnce) {
                // has a need to modify config
                try (FileWriter fw = new FileWriter(config)) {
                    g.toJson(deps, fw);
                }
            }
        }
        dialog.dispose();
        if (downloaded) {
            // prompt for reload
            JOptionPane.showMessageDialog(null, "Download complete! Please close this dialog now and launch the game from your launcher again to enjoy the pack.", DownloadProgressDialog.WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
            throw new RuntimeException("Restart the game please.");
        }
        return null;
    }

    private void precheck(List<Dependency> deps) {
        for (Dependency dep : deps) {
            if (dep.isDisabled()) {
                continue;
            }
            File location = new File(mcLocation, dep.getPath());
            if (location.exists()) {
                if (location.isDirectory()) {
                    // stupid user
                    LOGGER.warn("Directory {} will be removed as it should be a mod jar!", dep.getPath());
                    try {
                        Files.delete(location.toPath());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, String.format("Path %s is expected to be a mod jar, but it is a directory! Please check what's inside manually and move it. This pack cannot continue without that directory removed!", location.toString()));
                        throw new RuntimeException(e);
                    }
                } else {
                    // TODO implement checksum if a big crowd starts to complain about partially downloaded mod jars
                    LOGGER.debug("Dependency {} found locally", dep.getPath());
                    dep.setFound(true);
                }
            }
        }
    }

    private void download(Dependency dep) throws IOException {
        final Path downloadTemp = new File(mcLocation, ".__gtnh_download_temp__").toPath();
        LOGGER.info("Downloading {} to {}", dep.getUrl(), dep.getPath());
        try (FileChannel fc = FileChannel.open(downloadTemp, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
             ReadableByteChannel net = Channels.newChannel(new URL(dep.getUrl()).openStream())) {
            fc.transferFrom(net, 0, Long.MAX_VALUE);
        }
        final Path target = new File(mcLocation, dep.getPath()).toPath();
        final Path dir = target.getParent();
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }
        Files.move(downloadTemp, target);
        dialog.progress();
    }
}
