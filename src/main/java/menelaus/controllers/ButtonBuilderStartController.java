package menelaus.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menelaus.view.builder.BuilderLevelBuilderScreen;
import menelaus.view.builder.BuilderWindowFrame;

public class ButtonBuilderStartController implements ActionListener {

	public ButtonBuilderStartController() {
	}

	public void actionPerformed(ActionEvent e) {
		BuilderWindowFrame.getInstance().swapPanel(new BuilderLevelBuilderScreen());
	}
}