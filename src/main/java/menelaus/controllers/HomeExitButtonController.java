package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;

public class HomeExitButtonController implements ActionListener {
	
	// The home screen JFrame that contains the levels button:
	HomeScreen home;
	
	public HomeExitButtonController(HomeScreen home) {
		this.home = home;
	}
	
	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().close();
	}

}
