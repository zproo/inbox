package priv.zproo.designpattern.创建型.AbstractFactory;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
