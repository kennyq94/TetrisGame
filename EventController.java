
/**
 * Handles events for the Tetris Game.  User events (key strokes) as well as periodic timer
 * events.
 * 
 * @author CSC 143
 */
import java.awt.event.*;
import javax.swing.*;

public class EventController extends KeyAdapter implements ActionListener {
	private Game theGame;
	private Timer timer;
	private static final double PIECE_MOVE_TIME = 0.8; // controls time between
	// piece moving down
	// increase to slow it down
	private boolean gameOver;

	/**
	 * Constructor for objects of class EventController
	 * 
	 * @param g
	 *            the game this is controlling
	 */
	public EventController(Game g) {
		theGame = g;
		gameOver = false;
		double delay = 1000 * PIECE_MOVE_TIME; // in milliseconds
		timer = new Timer((int) delay, this);
		timer.setCoalesce(true); // if multiple events pending, bunch them to 1
									// event
		timer.start();
	}

	/*
	 * Respond to special keys being pressed Currently just responds to the
	 * space key
	 */
	public void keyPressed(KeyEvent e) {
		if (!gameOver) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				handleMove(Game.DOWN);
				break;
			// NEW CASE WITH KEYPRESS DOWN TO MOVE PIECE DOWNWARD
			case KeyEvent.VK_DOWN:
				handleMove(Game.DOWN);
				break;
			// NEW CASE WITH KEYPRESS RIGHT TO MOVE PIECE RIGHT
			case KeyEvent.VK_RIGHT:
				handleMove(Game.RIGHT);
				break;
			// NEW CASE WITH KEYPRESS LEFT TO MOVE PIECE LEFT
			case KeyEvent.VK_LEFT:
				handleMove(Game.LEFT);
				break;

			}
		}
	}

	/** Update the game periodically based on a timer event */
	public void actionPerformed(ActionEvent e) {
		handleMove(Game.DOWN);

	}

	/**
	 * Update the game by moving in the given direction
	 */
	private void handleMove(int direction) {
		theGame.movePiece(direction);
		gameOver = theGame.isGameOver();
		if (gameOver)
			timer.stop();
	}
}
