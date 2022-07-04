package com.fan;

public class SpeedControllerCord implements ICord {

	private FanState state;

	public SpeedControllerCord(FanState state) {
		this.state = state;
	}

	@Override
	public void pull() {

		if (state.getCurrentDirection().equals(Direction.CLOCK_WISE)) {
			state.setCurrentSpeed((state.getCurrentSpeed() + 1) % (state.getMaxSpeed() + 1));
		} else if (state.getCurrentDirection().equals(Direction.ANTI_CLOCK_WISE)) {

			if (state.getCurrentSpeed() == 0) {
				state.setCurrentSpeed((state.getMaxSpeed()));
			} else {
				state.setCurrentSpeed((state.getCurrentSpeed() - 1));
			}

		}

	}

}
