package com.playground.invadersmustdie.ui.panels;

import java.util.List;

import javax.swing.JPanel;

import com.playground.invadersmustdie.InvadersConst;
import com.playground.invadersmustdie.tools.SwingUtil;
import com.playground.invadersmustdie.ui.listener.ship.ShipListener;
import com.playground.invadersmustdie.ui.sprites.ship.Ship;
import com.playground.invadersmustdie.ui.sprites.ship.ShipMissile;

public class GameBoard extends JPanel implements InvadersConst {

	private static final long serialVersionUID = -8136118799536712947L;

	private Ship ship;
	
//	private boolean alive = true;

	public GameBoard() {
		initUI();
	}


	private void initUI() {
		setSize(PLAYGROUND_DIMENSION);
		setBackground(BACKGROUND_COLOR);
		setFocusable(true);
		
		ship = createShip();
		addShipToBoard();
	}
	
	private void addShipToBoard() {
		add(ship);
		addKeyListener(new ShipListener(ship));
	}

	protected Ship createShip() {
		return new Ship(SHIP_STARTPOS_X, SHIP_STARTPOS_Y);
	}

	public void cycle() {
		checkGameStatus();
		
		SwingUtil.invokeInEventDispatchThread(new Runnable() {
			
			@Override
			public void run() {
				repaint();
			}
		});
	}

	public void repaint() {
		super.repaint(); 
		
		updateShip();
		updateInvaders();
	}


	private void checkGameStatus() {
		
	}


	private void updateShip() {
		if (ship != null) {
			ship.repaint();
			
			updateMissiles();
		}
	}


	private void updateMissiles() {
		List<ShipMissile> missileList = ship.getMissileList();
		
		if (DEBUG) {
			System.out.println("---------------------------------------------");
			System.out.println("GameBoard.updateMissiles() count: " + missileList.size());
			System.out.println("---------------------------------------------");
		} 

		for (ShipMissile shipMissile : missileList) {
			if (shipMissile.getParent() == null) {
				add(shipMissile);
			}
			
			shipMissile.adjustX(10);
			shipMissile.adjustY(10);
			shipMissile.repaint();
		}
	}


	private void updateInvaders() {
		// TODO Auto-generated method stub
		
	}

}
