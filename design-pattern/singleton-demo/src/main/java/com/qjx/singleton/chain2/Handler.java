package com.qjx.singleton.chain2;

public abstract class Handler {
    protected Handler handler = null;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract String handleFeeRequest(String user,double fee);
}
