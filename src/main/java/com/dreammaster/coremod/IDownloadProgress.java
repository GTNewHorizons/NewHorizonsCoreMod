package com.dreammaster.coremod;

public interface IDownloadProgress {

    void setJobCount(int max);

    void progress();

    void setMainThread(Thread mainThread);

    void dispose();
}
