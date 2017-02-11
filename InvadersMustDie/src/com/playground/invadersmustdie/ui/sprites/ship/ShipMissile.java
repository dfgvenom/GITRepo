package com.playground.invadersmustdie.ui.sprites.ship;

import com.playground.invadersmustdie.tools.DirectionTools;
import com.playground.invadersmustdie.ui.sprites.Sprite;

public class ShipMissile extends Sprite {

	private static final long serialVersionUID = 1251234057656954473L;

	
	public ShipMissile(int x, int y, int direction) {
		super(x, y, SPEED_MISSILES);
		setDirection(direction);
		
		loadImage(MISSILE_IMAGE_FILE_NAME);
	}

	@Override
	public void cycle() {
		DirectionTools directionTools = new DirectionTools();
		double xFactorForDirection = directionTools.getXFactorForDirection(getRotation());
		adjustX((int) (xFactorForDirection * getSpeed()))	;
		double yFactorForDirection = directionTools.getYFactorForDirection(getRotation());
		adjustY((int) (yFactorForDirection * getSpeed()));
	}
	
}
