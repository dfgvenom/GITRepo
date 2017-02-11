package com.playground.invadersmustdie.ui.listener.ship;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.playground.invadersmustdie.InvadersConst;
import com.playground.invadersmustdie.ui.sprites.ship.Ship;

public class ShipListener extends KeyAdapter implements InvadersConst {

	private Ship ship;
	
	public ShipListener(Ship ship) {
		this.ship = ship;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		handleKeyEvent(e);
	}

	private void handleKeyEvent(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		boolean isShiftPressed = e.isShiftDown();
		boolean isCtrlPressed = e.isControlDown();
		
		if (DEBUG) {
			System.out.println("========================");
			System.out.println("ShipListener.handleKeyEvent()");
			System.out.println("ShiftPressed: " + isShiftPressed);
			System.out.println("CtrlPressed: " + isCtrlPressed);
			System.out.println("========================");
		}
		
		int movementAdjust = 5;
		
		if (KeyEvent.VK_SPACE == keyCode) {
			if (isCtrlPressed) {
				
			} else {
				if (DEBUG) {
					System.out.println("ShipListener.handleKeyEvent() - SPACE");
				}
				ship.fireMissile();
			}
		} else if (KeyEvent.VK_UP == keyCode && !isShiftPressed) {
			ship.adjustY(-1 * movementAdjust);
		} else if (KeyEvent.VK_DOWN == keyCode && !isShiftPressed) {
			ship.adjustY(movementAdjust);
		} else if (KeyEvent.VK_RIGHT == keyCode && !isShiftPressed) {
			ship.adjustX(movementAdjust);
		} else if (KeyEvent.VK_LEFT == keyCode && !isShiftPressed) {
			ship.adjustX(-1 * movementAdjust);
		} else if (KeyEvent.VK_UP == keyCode && isShiftPressed) {
			ship.setDirection(DIRECTION_NORTH);
		} else if (KeyEvent.VK_DOWN == keyCode && isShiftPressed) {
			ship.setDirection(DIRECTION_SOUTH);
		} else if (KeyEvent.VK_RIGHT == keyCode && isShiftPressed) {
			ship.setDirection(DIRECTION_EAST);
		} else if (KeyEvent.VK_LEFT == keyCode && isShiftPressed) {
			ship.setDirection(DIRECTION_WEST);
		}
	}


}

