package priv.zj.designpattern.行为型.observer;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
