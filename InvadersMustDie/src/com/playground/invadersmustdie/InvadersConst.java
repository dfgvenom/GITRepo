package com.playground.invadersmustdie;

import com.playground.PlayGroundConst;

public interface InvadersConst extends PlayGroundConst {
	public static final int SHIP_SPEED = 1;
	public static final int SPEED_MISSILES = 2;
	public static final int SPEED_ALIENS = 1;
	
	public static final int SHIP_STARTPOS_X = 150;
	public static final int SHIP_STARTPOS_Y = 150;
	
	public static final int DIRECTION_NORTH = 0;
	public static final int DIRECTION_EAST = -3;
	public static final int DIRECTION_SOUTH = 2;
	public static final int DIRECTION_WEST = 3;
	
	public static final String SHIP_IMAGE_FILE_NAME = ICON_PATH + "alienblaster.png";
	public static final String MISSILE_IMAGE_FILE_NAME = ICON_PATH + "missile.png";
	public static final String IMAGE_NOT_FOUND_FILE_NAME = "com.playgroung.invadersmustdie.resources.icons.fileNotFound.gif";
	
}
