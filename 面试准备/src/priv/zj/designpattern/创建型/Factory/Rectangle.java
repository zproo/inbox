package priv.zj.designpattern.创建型.Factory;

/**
 * Created by zproo on 2017/11/25.
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}