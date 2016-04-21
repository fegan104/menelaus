package menelaus.view;

import menelaus.model.Level;
import menelaus.model.board.Piece;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author frankegan on 4/15/16.
 * <p>
 * Define a base class for all our panels to extend. Includes constants for defining panel sizes,
 * and methods for dragging views. Will be used for handling all mous events inside of panel and delegating them to
 * their respective controllers.
 * </p>
 */
public class KabasujiPanel extends JPanel {
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_X = 100;
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_Y = 100;
    /**
     * Define the width for all panels that extend our class
     */
    public static final int WIDTH = 1000;
    /**
     * Define the height for all panels that extend our class
     */
    public static final int HEIGHT = 750;
    /**
     * Double Buffering technique requires an offscreen image.
     */
    Image offscreenImage;
    Graphics offscreenGraphics;
    /**
     * Level that is being played
     */
    Level level;
    /**
     * Current mouse listeners
     */
    MouseListener activeListener;
    /**
     * Current mouse listeners
     */
    MouseMotionListener activeMotionListener;

    Graphics canvasGraphics;

    /**
     * Define a base class for all our panels to extend. Includes constants for defining panel sizes,
     * and methods for dragging views. Will be used for handling all mous events inside of panel and delegating them to
     * their respective controllers.
     */
    public KabasujiPanel() {
        setBounds(START_X, START_Y, WIDTH, HEIGHT);
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    public void redraw() {
        // nothing to draw into? Must stop here.
        if (offscreenImage == null) return;
        if (offscreenGraphics == null) return;    // detected during testing

        // clear the image.
        offscreenGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());

        /** Draw all shapes. Note selected shape is not part of the model. */
        for (Piece s : level.getBoard().getPieces()) {
            paintPiece(offscreenGraphics, s);
        }
    }

    /**
     * Paint the piece into the given graphics context using its drawer.
     */
    public void paintPiece(Graphics g, Piece piece) {
        if (g == null) {
            return;
        }

        PieceDrawer.drawPiece(g, piece, 0);
    }

    /**
     * Repaint to the screen just the given part of the image.
     */
    public void paintBackground(Piece p) {
        // Only updates to the screen the given region
        if (canvasGraphics != null) {
            canvasGraphics.drawImage(offscreenImage,
                    p.getPosition().getX(),
                    p.getPosition().getY(),
                    p.getWidth(),
                    p.getHeight(),
                    this);

            repaint(p.getPosition().getX(),
                    p.getPosition().getY(),
                    p.getWidth(),
                    p.getHeight());
        }
    }

    /**
     * Properly register new listener (and unregister old one if present).
     */
    public void setActiveListener(MouseListener ml) {
        this.removeMouseListener(activeListener);
        activeListener = ml;
        if (ml != null) {
            this.addMouseListener(ml);
        }
    }

    /**
     * Properly register new motion listener (and unregister old one if present).
     */
    public void setActiveMotionListener(MouseMotionListener mml) {
        this.removeMouseMotionListener(activeMotionListener);
        activeMotionListener = mml;
        if (mml != null) {
            this.addMouseMotionListener(mml);
        }
    }
}
