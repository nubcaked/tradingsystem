package com.liangwei.tradingsystem;

public class DataProviderFlag {

    private boolean runFlag;

    public DataProviderFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }

    public boolean isRunFlag() {
        return runFlag;
    }

    public void setRunFlag(boolean runFlag) {
        this.runFlag = runFlag;
    }
}
