package com.playground.invadersmustdie.ui.panels;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.playground.invadersmustdie.ui.sprites.ship.Ship;
import com.playground.invadersmustdie.ui.sprites.ship.ShipMissile;

public class GameBoardTest {

	@Mock
	private Ship mock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void cycle_addsNewMissilesToGameBoard() throws Exception {
		GameBoard gameBoard = new GameBoard() {
			@Override
			protected Ship createShip() {
				return mock;
			}
		};
		
		assertThat(gameBoard.getComponentCount(), is(1));
		gameBoard.cycle();
		assertThat(gameBoard.getComponentCount(), is(1));
		
		List<ShipMissile> missileList = new ArrayList<>();
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.cycle();
		assertThat(gameBoard.getComponentCount(), is(1));
		
		missileList.add(new ShipMissile(0, 0, 0));
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.cycle();
		assertThat(gameBoard.getComponentCount(), is(2));
		
		gameBoard.cycle();
		assertThat(gameBoard.getComponentCount(), is(2));
		
		missileList.add(new ShipMissile(0, 0, 0));
		missileList.add(new ShipMissile(0, 0, 0));
		missileList.add(new ShipMissile(0, 0, 0));
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.cycle();
		assertThat(gameBoard.getComponentCount(), is(5));
	}
	
	@Test
	public void cycle_moveMissiles() throws Exception {
		GameBoard gameBoard = new GameBoard() {
			@Override
			protected Ship createShip() {
				return mock;
			}
		};
		
		List<ShipMissile> missileList = new ArrayList<>();
		int xPos1 = 0;
		int yPos1 = 0;
		ShipMissile missile1 = new ShipMissile(xPos1 , yPos1, 0);
		missileList.add(missile1);
		doReturn(missileList).when(mock).getMissileList();
		
		assertThat(missile1.getX(), is(xPos1));
		assertThat(missile1.getY(), is(yPos1));
		
		gameBoard.cycle();
		xPos1 += 10 * missile1.getSpeed();
		yPos1 += 10 * missile1.getSpeed();
		assertThat(missile1.getX(), is(xPos1));
		assertThat(missile1.getY(), is(yPos1));
		
		int xPos2 = 0;
		int yPos2 = 0;
		ShipMissile missile2 = new ShipMissile(xPos2, yPos2, 0);
		missileList.add(missile2);
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.cycle();
		xPos1 += 10 * missile1.getSpeed();
		yPos1 += 10 * missile1.getSpeed();
		xPos2 += 10 * missile2.getSpeed();
		yPos2 += 10 * missile2.getSpeed();
		assertThat(missile1.getX(), is(xPos1));
		assertThat(missile1.getY(), is(yPos1));
		assertThat(missile2.getX(), is(xPos2));
		assertThat(missile2.getY(), is(yPos2));
	}

}
