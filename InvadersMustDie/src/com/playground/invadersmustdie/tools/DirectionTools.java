package com.playground.invadersmustdie.tools;

public class DirectionTools {

	public double getXFactorForDirection(double direction) {
		return (-1) * Math.sin(direction);
	}
	
	public double getYFactorForDirection(double direction) {
		return Math.cos(direction);
	}
	
}
