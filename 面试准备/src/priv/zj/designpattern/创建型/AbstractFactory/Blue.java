package priv.zj.designpattern.创建型.AbstractFactory;

public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
