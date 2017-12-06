package com.zj.行为型.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
