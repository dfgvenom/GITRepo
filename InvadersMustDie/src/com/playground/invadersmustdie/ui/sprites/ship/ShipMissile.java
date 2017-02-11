package com.playground.invadersmustdie.ui.sprites.ship;

import com.playground.invadersmustdie.ui.sprites.Sprite;

public class ShipMissile extends Sprite {

	private static final long serialVersionUID = 1251234057656954473L;

	
	public ShipMissile(int x, int y) {
		super(x, y, SPEED_MISSILES);
		
		loadImage(MISSILE_IMAGE_FILE_NAME);
	}

	
}
