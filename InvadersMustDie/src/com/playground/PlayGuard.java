package com.playground;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.playground.invadersmustdie.InvadersMustDie;
import com.playground.ui.MainFrame;

public class PlayGuard implements ActionListener, PlayGroundConst {

	private InvadersMustDie invaders;
	private Timer timer;
	private MainFrame frame;

	public PlayGuard() {
		createFrame();
		createGame();
		
		addGameBoard();
		prepareDisplay();
	}

	private void prepareDisplay() {
		frame.setVisible(true);
	}

	private void createGame() {
		invaders = new InvadersMustDie();
	}

	private void addGameBoard() {
		frame.setContentPane(invaders.getGameBoard());
	}

	public void startGame() {
		timer = new Timer(0, this);
		timer.setRepeats(false);
		timer.start();
	}

	private void createFrame() {
		frame = new MainFrame();
	}

	private void cycle() {
		invaders.cycle();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.stop();
		
		long timeBeforeCycle = System.currentTimeMillis();
		
		cycle();
		
		long timeAfterCycle = System.currentTimeMillis();
		
		int delay = CYCLE_IN_MILLIS - (int) (timeAfterCycle - timeBeforeCycle);
		
		timer.setDelay(delay);
		timer.setInitialDelay(delay);
		timer.start();
	}


}
