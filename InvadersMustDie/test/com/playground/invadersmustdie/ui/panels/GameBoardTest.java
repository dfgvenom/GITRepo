package com.playground.invadersmustdie.ui.panels;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
	public void repaint_addsNewMissilesToGameBoard() throws Exception {
		GameBoard gameBoard = new GameBoard() {
			@Override
			protected Ship createShip() {
				return mock;
			}
		};
		
		assertThat(gameBoard.getComponentCount(), is(1));
		gameBoard.repaint();
		assertThat(gameBoard.getComponentCount(), is(1));
		
		List<ShipMissile> missileList = new ArrayList<>();
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.repaint();
		assertThat(gameBoard.getComponentCount(), is(1));
		
		missileList.add(new ShipMissile(0, 0));
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.repaint();
		assertThat(gameBoard.getComponentCount(), is(2));
		
		gameBoard.repaint();
		assertThat(gameBoard.getComponentCount(), is(2));
		
		missileList.add(new ShipMissile(0, 0));
		missileList.add(new ShipMissile(0, 0));
		missileList.add(new ShipMissile(0, 0));
		doReturn(missileList).when(mock).getMissileList();
		gameBoard.repaint();
		assertThat(gameBoard.getComponentCount(), is(5));
	}

}
