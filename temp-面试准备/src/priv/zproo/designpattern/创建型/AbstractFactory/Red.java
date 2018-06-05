package priv.zproo.designpattern.创建型.AbstractFactory;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
