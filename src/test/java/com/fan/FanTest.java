package com.fan;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FanTest {

	@Test
	@DisplayName("FanState is invalid, throws exception")
	void testWhenCurrentSpeedIsGreaterThanMaxSpeedThrowsException() {
		assertThrows(RuntimeException.class, () -> new FanState(3, 2, Direction.CLOCK_WISE));
	}

	@DisplayName("Initially fan if off")
	@Test
	void testWhenFanIsInitiated() {
		assertFalse(new Fan(3).isOn());
	}

	@DisplayName("When cord is one time pullUp, current speed will be 1.and bydefault it will be clockwise")
	@Test
	void testWhenCordIsFirstTimePullUp() {
		Fan fan = new Fan(3);
		fan.pullSpeedControllerCord();
		assertEquals(1, fan.getCurrentSpeed());
		assertEquals(Direction.CLOCK_WISE, fan.getCurrentDirection());
	}

	@DisplayName("When cord is third time pullUp, current speed wil be 3.")
	@Test
	void testWhenCordIsThirdTimePullUp() {
		Fan fan = new Fan(3);
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertEquals(3, fan.getCurrentSpeed());
	}

	@DisplayName("When cord is fourth time pullUp, then fan will be off as max speed default is 3")
	@Test
	void testWhenCordIsFourthTimePullUpFanOff() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertFalse(fan.isOn());
	}

	@DisplayName("When cord is first time pullUp and twice second cord pull down, then fan speed will be 1 and direction will be Clock_wise")
	@Test
	void testWhenCordIsFirstTimePullUpAndTwiceDownThenItWillBeOnClockWiseDirection() {
		Fan fan = new Fan();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullReverseControllerCord();
		assertEquals(0, fan.getCurrentSpeed());
		assertEquals(Direction.ANTI_CLOCK_WISE, fan.getCurrentDirection());
		fan.pullReverseControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertEquals(Direction.CLOCK_WISE, fan.getCurrentDirection());
		assertEquals(2, fan.getCurrentSpeed());
		fan.pullReverseControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		assertEquals(0, fan.getCurrentSpeed());
		assertEquals(Direction.ANTI_CLOCK_WISE, fan.getCurrentDirection());
	}

	@DisplayName("When cord is third time pullUp, and then one time pull down then current speed wil be 3 but direction will be reverse.")
	@Test
	void testWhenCordIsThirdTimePullUpAndOneTimePullDown() {
		Fan fan = new Fan(3);
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullSpeedControllerCord();
		fan.pullReverseControllerCord();
		assertEquals(3, fan.getCurrentSpeed());
		assertEquals(Direction.ANTI_CLOCK_WISE, fan.getCurrentDirection());
	}

	@DisplayName("When cord is first time pull down when fan off, then fan direction will be reversed but fan will be off")
	@Test
	void testWhenCordIsFirstTimePullDownFanInMaxSpeed() {
		Fan fan = new Fan(3);
		fan.pullReverseControllerCord();
		assertFalse(fan.isOn());
		assertEquals(Direction.ANTI_CLOCK_WISE, fan.getCurrentDirection());
	}

}
