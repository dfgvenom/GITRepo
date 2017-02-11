package com.playground.invadersmustdie.ui.sprites.ship;

import java.util.ArrayList;
import java.util.List;

import com.playground.invadersmustdie.ui.sprites.Sprite;

public class Ship extends Sprite {

	private static final long serialVersionUID = -1418120729777937804L;
	
	private List<ShipMissile> missileList;

	public Ship(int x, int y) {
		super(x, y, SHIP_SPEED);
		
		loadImage(SHIP_IMAGE_FILE_NAME);
	}

	public List<ShipMissile> getMissileList() {
		if (missileList == null) {
			missileList = new ArrayList<>();
		}
		return missileList;
	}

	public void fireMissile() {
		int missileX = getX() + getWidth();
		int missileY = getY() + getHeight();
		ShipMissile missile = new ShipMissile(missileX, missileY);
		missile.setVisible(true);
		if (DEBUG) {
			System.out.println("Ship.fireMissile(): " + missile + " at x: " + missileX + ", y: " + missileY);
		}
		getMissileList().add(missile);
	}

}
