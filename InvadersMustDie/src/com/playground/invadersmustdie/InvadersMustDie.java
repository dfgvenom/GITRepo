package com.playground.invadersmustdie;

import com.playground.invadersmustdie.ui.panels.GameBoard;

public class InvadersMustDie {
	
	private GameBoard gameBoard;

	public InvadersMustDie() {
		gameBoard = new GameBoard();
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public void cycle() {
		gameBoard.cycle();
	}

}
