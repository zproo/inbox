package com.sxt.dp.factory;

public class CarFactory extends VehicleFactory{
	public Moveable create() {
		return new Car();
	}
}
