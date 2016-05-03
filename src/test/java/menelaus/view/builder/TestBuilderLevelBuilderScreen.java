package menelaus.view.builder;

import static org.junit.Assert.*;

import menelaus.controllers.BoardBuilderMakeLevelController;
import menelaus.controllers.ButtonBuilderStartController;
import menelaus.controllers.ReleasePaneBuilderMakeLevelController;
import menelaus.model.BuilderManager;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.view.builder.BuilderLevelBuilderScreen;

import org.junit.Before;
import org.junit.Test;

public class TestBuilderLevelBuilderScreen {

	 BuilderManager bManager;
	 BuilderLevelBuilderScreen screen;
	
	@Before
	public void setUp() throws Exception {
		bManager = new BuilderManager();
		ButtonBuilderStartController c = new ButtonBuilderStartController(bManager);
		c.actionPerformed(null);
		screen = (BuilderLevelBuilderScreen) BuilderWindowFrame.getInstance().getContentPane().getComponent(0);
	}

	@Test
	public void testMouseClickPuzzle() {
		BoardBuilderMakeLevelController ctr = new BoardBuilderMakeLevelController(bManager, screen.panelBoardView, null);
		
		ctr._handleMouseClickBoardMode(screen.panelBoardView.pointUnder(new Point(20, 20)));
		ctr._handleMouseClickBoardMode(screen.panelBoardView.pointUnder(new Point(20, 20)));
	}
	
	@Test
	public void testMouseClickRelease() {
		bManager.setLevelType(LevelType.RELEASE);
		ButtonBuilderStartController c = new ButtonBuilderStartController(bManager);
		c.actionPerformed(null);
		screen = (BuilderLevelBuilderScreen) BuilderWindowFrame.getInstance().getContentPane().getComponent(0);
		
		
		BoardBuilderMakeLevelController ctr = new BoardBuilderMakeLevelController(bManager, screen.panelBoardView, 
				new ReleasePaneBuilderMakeLevelController(bManager, screen.releasePaneData, screen.releasePanel));
		
		ctr._handleMouseClickReleaseMode(screen.panelBoardView.pointUnder(new Point(20, 20)));
		ctr._handleMouseClickBoardMode(screen.panelBoardView.pointUnder(new Point(20, 20)));
		ctr._handleRightClickReleaseMode(screen.panelBoardView.pointUnder(new Point(20, 20)));

		
	}

}
