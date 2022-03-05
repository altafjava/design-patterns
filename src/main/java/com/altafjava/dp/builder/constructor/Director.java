package com.altafjava.dp.builder.constructor;

public class Director {

	public House buildHouse() {
		House house = new House();
		house.setWalls(4);
		house.setDoors(1);
		house.setWindows(2);
		house.setFloor(true);
		house.setFloor(true);
		return house;
	}
}
