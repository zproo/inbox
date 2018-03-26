package priv.zproo.designpattern.行为型.observer;

public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("binary String:"
                + Integer.toBinaryString(subject.getState()));
    }
}
