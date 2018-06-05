package com.sxt.dp.factory;

public class PlaneFactory extends VehicleFactory{
	public Moveable create() {
		return new Plane();
	}
}
