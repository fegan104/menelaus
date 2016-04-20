package menelaus.view.game;

import menelaus.controllers.ButtonLevelsController;
import menelaus.model.GameManager;
import menelaus.model.Level;
import menelaus.model.basic.LevelType;
import menelaus.model.basic.Point;
import menelaus.model.board.InvalidPiecePlacementException;
import menelaus.model.board.Piece;
import menelaus.model.board.Tile;
import menelaus.view.BoardView;
import menelaus.view.BullpenView;
import menelaus.view.KabasujiPanel;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;

/**
 * Created by @author frankegan on 4/10/16.
 */
public class LevelPlayScreen extends KabasujiPanel {
	
	GameManager gameManager;
	
    /**
     * Create the panel.
     */
    public LevelPlayScreen() {
    	
    	//TODO: load proper level
    	Level level = new Level(LevelType.PUZZLE, 7, 7);

        //Draw the pieces to the bullpen and board
        setUpBullPen(level);
        setUpBoard(level);

    	gameManager = new GameManager(level);
    	
    	setBounds(100, 100, GameViewConfigurations.panelWidth, GameViewConfigurations.panelHeight);

        JScrollPane scrollPane = new JScrollPane();

        JLabel lblNewLabel = new JLabel("PUZZLE LEVEL 2");
        JLabel lblMovesLeft = new JLabel("MOVES LEFT 3");

        /* BUTTONS */
        JButton btnRestart = new JButton("RESTART");
        JButton btnExitButton = new JButton("EXIT");
        
        /* CONNECT BUTTONS TO CONTROLLERS */
        btnExitButton.addActionListener(new ButtonLevelsController());
        
        /** Create Board View */
        JPanel BoardView = new BoardView(gameManager.getLevel().getBoard());
        BoardView.setBorder(BorderFactory.createLineBorder(Color.black));
        
        /** Create BullpenView */
        JPanel BullpenView = new BullpenView(gameManager.getLevel().getBullpen());
        
        GroupLayout gl_contentPane = new GroupLayout(this);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(btnExitButton)
        					.addGap(18)
        					.addComponent(btnRestart))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addComponent(lblNewLabel)
        					.addGap(29)
        					.addComponent(lblMovesLeft)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(BoardView, GroupLayout.PREFERRED_SIZE, 710, Short.MAX_VALUE)
        			.addGap(12))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(34, Short.MAX_VALUE)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblMovesLeft)
        						.addComponent(lblNewLabel))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnRestart)
        						.addComponent(btnExitButton))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE))
        				.addComponent(BoardView, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        
        scrollPane.setViewportView(BullpenView);
        this.setLayout(gl_contentPane);
    }

    public void setUpBullPen(Level level){
        Piece p1 = new Piece(new Point(100, 100));
        p1.addTile(new Tile(0, 1));
        p1.addTile(new Tile(1, 1));
        p1.addTile(new Tile(1, 2));
        p1.addTile(new Tile(2, 1));
        p1.addTile(new Tile(2, 2));

        level.getBullpen().addPiece(p1);
    }

    public void setUpBoard(Level level){
        Piece p1 = new Piece(new Point(500, 300));
        p1.addTile(new Tile(0, 0));
        p1.addTile(new Tile(0, 1));
        p1.addTile(new Tile(1, 2));
        p1.addTile(new Tile(2, 1));
        p1.addTile(new Tile(2, 2));

        try {
            level.getBoard().placePiece(p1);
        } catch (InvalidPiecePlacementException e) {
            e.printStackTrace();
        }
    }
}