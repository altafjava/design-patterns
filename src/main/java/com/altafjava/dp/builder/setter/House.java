package com.altafjava.dp.builder.setter;

public class House {
	private int walls;
	private int doors;
	private int windows;
	private boolean isRoof;
	private boolean isFloor;

	public int getWalls() {
		return walls;
	}

	public void setWalls(int walls) {
		this.walls = walls;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getWindows() {
		return windows;
	}

	public void setWindows(int windows) {
		this.windows = windows;
	}

	public boolean isRoof() {
		return isRoof;
	}

	public void setRoof(boolean isRoof) {
		this.isRoof = isRoof;
	}

	public boolean isFloor() {
		return isFloor;
	}

	public void setFloor(boolean isFloor) {
		this.isFloor = isFloor;
	}

	@Override
	public String toString() {
		return "House [walls=" + walls + ", doors=" + doors + ", windows=" + windows + ", isRoof=" + isRoof
				+ ", isFloor=" + isFloor + "]";
	}

}
