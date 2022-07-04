package com.fan;

public class ReverseControllerCord implements ICord {

	private FanState state;

	public ReverseControllerCord(FanState state) {
		this.state = state;
	}

	@Override
	public void pull() {
		state.setDirection(
				state.getCurrentDirection() == Direction.ANTI_CLOCK_WISE ? Direction.CLOCK_WISE : Direction.ANTI_CLOCK_WISE);
	}

}
