package com.fan;

public class FanState {

	private int currentSpeed;
	private int maxSpeed;
	private Direction direction;

	public FanState(int currentSpeed, int maxSpeed, Direction direction) {
		this.checkValidState(currentSpeed, maxSpeed);
		this.currentSpeed = currentSpeed;
		this.maxSpeed = maxSpeed;
		this.direction = direction;
	}

	private void checkValidState(int currentSpeed, int maxSpeed) {
		if (currentSpeed > maxSpeed)
			throw new RuntimeException("Current Speed Can't greater than max speed.Invalid state");
	}

	public Direction getCurrentDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.checkValidState(currentSpeed, this.maxSpeed);
		this.currentSpeed = currentSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

}
