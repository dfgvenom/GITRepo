package com.playground.invadersmustdie.tools;

import javax.swing.SwingUtilities;

public class SwingUtil {
	
	public static void invokeInEventDispatchThread(Runnable run) {
		if (SwingUtilities.isEventDispatchThread()) {
			run.run();
		} else {
			SwingUtilities.invokeLater(run);
		}
	}
	
}
