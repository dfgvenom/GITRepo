package com.playground;


public class PlayGround {

	private static PlayGuard guard;

	public static void main(String[] args) {
		guard = new PlayGuard();
		
		guard.startGame();
	}
	
}
