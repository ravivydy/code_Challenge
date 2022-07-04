package com.fan;

import java.util.logging.Logger;

public class Fan {

	private static final int DEFAULT_MAX_SPPED = 3;

	private Logger log = Logger.getLogger(Fan.class.getName());

	private ICord speedCord;
	private ICord directionCord;
	private FanState state;

	public Fan(FanState state) {
		this.state = state;
		this.speedCord = new SpeedControllerCord(state);
		this.directionCord = new ReverseControllerCord(state);
	}

	public Fan() {
		this(DEFAULT_MAX_SPPED);// default Max speed is 3;
	}

	public Fan(int maxSpeed) {
		this(new FanState(0, maxSpeed, Direction.CLOCK_WISE));
	}

	public void pullSpeedControllerCord() {
		speedCord.pull();
		log.info(String.format("Pull Up Cord.Current Speed is %s", state.getCurrentSpeed()));
	}

	public void pullReverseControllerCord() {
		directionCord.pull();
		log.info(String.format("Pull reverse controller Cord.Current direction is %s", state.getCurrentDirection()));
	}

	public boolean isOn() {
		return state.getCurrentSpeed() != 0;
	}

	public Direction getCurrentDirection() {
		return this.state.getCurrentDirection();
	}

	public int getCurrentSpeed() {
		return this.state.getCurrentSpeed();
	}

}
