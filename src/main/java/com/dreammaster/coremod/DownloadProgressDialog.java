package com.dreammaster.coremod;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.dreammaster.lib.Refstrings;

class DownloadProgressDialog extends JDialog implements IDownloadProgress {

    /**
     *
     */
    private static final long serialVersionUID = 6041491111144915139L;

    public static final String WINDOW_TITLE = Refstrings.NAME;
    private Thread netThread;
    private JProgressBar progressBar;

    @Override
    public void setJobCount(int max) {
        progressBar.setMaximum(max);
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    @Override
    public void progress() {
        progressBar.setValue(progressBar.getValue() + 1);
    }

    @Override
    public void setMainThread(Thread mainThread) {
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                mainThread.interrupt();
            }
        });
    }

    /**
     * Create the dialog.
     */
    public DownloadProgressDialog() {
        setTitle(WINDOW_TITLE);
        setBounds(100, 100, 450, 172);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JLabel lblNewLabel = new JLabel("Downloading additional files");
            lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(24.0f));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(lblNewLabel, BorderLayout.NORTH);
        }
        {
            JPanel buttonPane = new JPanel();
            contentPanel.add(buttonPane, BorderLayout.SOUTH);
            buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(
                        e -> DownloadProgressDialog.this.dispatchEvent(
                                new WindowEvent(DownloadProgressDialog.this, WindowEvent.WINDOW_CLOSING)));
                buttonPane.add(cancelButton);
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            {
                progressBar = new JProgressBar();
                progressBar.setStringPainted(true);
                panel.add(progressBar);
            }
        }
    }
}
