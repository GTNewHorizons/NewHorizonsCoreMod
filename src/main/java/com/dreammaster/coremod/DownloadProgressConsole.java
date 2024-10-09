package com.dreammaster.coremod;

public class DownloadProgressConsole implements IDownloadProgress {

    private int progress = 0;
    private int total = 0;

    @Override
    public void setJobCount(int max) {
        total = max;
    }

    @Override
    public void progress() {
        progress++;
        DepLoader.LOGGER.info("Dependency downloaded: {} of {}", progress, total);
    }

    @Override
    public void setMainThread(Thread mainThread) {
        // noop
    }

    @Override
    public void dispose() {

    }
}
