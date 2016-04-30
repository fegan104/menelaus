package menelaus.view.game;

import menelaus.controllers.ButtonMainMenuController;
import menelaus.model.Level;
import menelaus.model.LevelStars;
import menelaus.model.LevelsPackage;
import menelaus.model.SavedGames;
import menelaus.util.SavedGamesUtil;
import menelaus.view.KabasujiPanel;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;

public class LevelSelectorScreen extends KabasujiPanel {
	/**
	 * Create the panel.
	 */
	public LevelSelectorScreen(LevelsPackage levelsPackage, SavedGames savedGames) {
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		GameWindowFrame.getInstance().setRecentlyPLayedLevelsPackage(levelsPackage);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(444, 699, 112, 29);
		btnMainMenu.addActionListener(new ButtonMainMenuController());
		
		boolean playable = true;
		
		// For each level
		for (Level l : levelsPackage.getLevels()) {
			LevelStars stars = savedGames.getStarsForLevel(l);
			
			LevelSelectComponent btnLevelX = new LevelSelectComponent(l, stars, playable);
			btnLevelX.setBackground(Color.white);
			btnLevelX.setBorder(raisedbevel);

			this.add(btnLevelX);
			
			if (stars == null) {
				playable = false;
			}
		}
//		setLayout(null);
		
		this.add(btnMainMenu);
	}
}
