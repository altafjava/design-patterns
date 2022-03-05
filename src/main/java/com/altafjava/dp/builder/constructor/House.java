package com.altafjava.dp.builder.constructor;

public class House {
	private int walls;
	private int doors;
	private int windows;
	private boolean isRoof;
	private boolean isFloor;
	private boolean isGarden;
	private boolean isSwimmingPool;

	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isGarden,
			boolean isSwimmingPool) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isGarden = isGarden;
		this.isSwimmingPool = isSwimmingPool;
	}

	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isSwimmingPool) {
		super();
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isSwimmingPool = isSwimmingPool;
	}

	public House(int walls, int doors, int windows, boolean isRoof, boolean isFloor, boolean isGarden) {
		this.walls = walls;
		this.doors = doors;
		this.windows = windows;
		this.isRoof = isRoof;
		this.isFloor = isFloor;
		this.isGarden = isGarden;
	}
}
