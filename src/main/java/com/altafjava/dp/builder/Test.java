package com.altafjava.dp.builder;

import com.altafjava.dp.builder.setter.Director;
import com.altafjava.dp.builder.setter.House;

public class Test {

	public static void main(String[] args) {
		Director director = new Director();
		House house = director.buildHouse();
		System.out.println(house);
		System.out.println("AFTER BUILDING HOUSE");
		house.setWalls(10);
		System.out.println(house);
	}

}
