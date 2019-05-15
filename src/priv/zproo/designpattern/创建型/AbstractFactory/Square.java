package priv.zproo.designpattern.创建型.AbstractFactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
