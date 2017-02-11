package com.playground.invadersmustdie.tools;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DirectionToolsTest {

	@Test
	public void getXFactorForDirection() throws Exception {
		DirectionTools tools = new DirectionTools();
		
		double radiansFor0Degrees = Math.toRadians(0.0);
		assertThat(getRoundedValue(tools.getXFactorForDirection(radiansFor0Degrees)), is(0.0));
		double radiansFor90Degrees = Math.toRadians(90.0);
		assertThat(getRoundedValue(tools.getXFactorForDirection(radiansFor90Degrees)), is(-1.0));
		double radiansFor180Degrees = Math.toRadians(180.0);
		assertThat(getRoundedValue(tools.getXFactorForDirection(radiansFor180Degrees)), is(0.0));
		double radiansFor270Degrees = Math.toRadians(270.0);
		assertThat(getRoundedValue(tools.getXFactorForDirection(radiansFor270Degrees)), is(1.0));
	}

	@Test
	public void getYFactorForDirection() throws Exception {
		DirectionTools tools = new DirectionTools();
		
		double radiansFor0Degrees = Math.toRadians(0.0);
		assertThat(getRoundedValue(tools.getYFactorForDirection(radiansFor0Degrees)), is(1.0));
		double radiansFor90Degrees = Math.toRadians(90.0);
		assertThat(getRoundedValue(tools.getYFactorForDirection(radiansFor90Degrees)), is(0.0));
		double radiansFor180Degrees = Math.toRadians(180.0);
		assertThat(getRoundedValue(tools.getYFactorForDirection(radiansFor180Degrees)), is(-1.0));
		double radiansFor270Degrees = Math.toRadians(270.0);
		assertThat(getRoundedValue(tools.getYFactorForDirection(radiansFor270Degrees)), is(0.0));
	}

	private double getRoundedValue(double value) {
		return Math.round(1000 * value) / 1000.0;
	}
	
}
