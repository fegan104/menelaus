package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.game.ExtraScreen;
import menelaus.view.game.GameWindowFrame;
import menelaus.view.game.HomeScreen;

public class ButtonHomeExtraController implements ActionListener {

	// The home screen JFrame that contains the levels button:


	public ButtonHomeExtraController() {
	}

	public void actionPerformed(ActionEvent e) {
		GameWindowFrame.getInstance().swapPanel(new ExtraScreen());
	}
}