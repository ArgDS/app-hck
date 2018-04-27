package com.group.first.app.worker;

/**
 * Created by DMikhailov on 31.01.2018.
 */
public abstract class AbstractWorker implements Worker{

    protected Thread mainThread;

    @Override
    public void start() {
        mainThread = new Thread(this::run);
        mainThread.start();
    }
}
