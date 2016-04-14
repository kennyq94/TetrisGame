import java.awt.*;
import java.util.Random;

/**
 * Manages the game Tetris. Keeps track of the current piece and the grid.
 * Updates the display whenever the state of the game has changed.
 * 
 * @author Khang Quach Tetris implementations 04/11/16
 */
public class Game {

	private Grid theGrid; // the grid that makes up the Tetris board
	private Tetris theDisplay; // the visual for the Tetris game
	private Shape piece; // the current piece that is dropping
	private boolean isOver; // has the game finished?
	private Random rand = new Random();
	// possible move directions
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int DOWN = 2;

	/**
	 * Create a Tetris game
	 * 
	 * @param Tetris
	 *            the display
	 */
	public Game(Tetris display) {
		theGrid = new Grid();
		theDisplay = display;
		//piece = new ZShape(1, Grid.WIDTH / 2 - 1, theGrid);
		piece = randomPiece(); // calls randomPiece method instead of LShape
		isOver = false;
	}

	/**
	 * Draw the current state of the game
	 * 
	 * @param g
	 *            the Graphics context on which to draw
	 */
	public void draw(Graphics g) {
		theGrid.draw(g);
		if (piece != null)
			piece.draw(g);

	}

	/**
	 * Move the piece in the given direction
	 * 
	 * @param the
	 *            direction to move
	 * @throws IllegalArgumentException
	 *             if direction is not legal
	 */
	public void movePiece(int direction) {
		if (piece != null)
			piece.move(direction);
		updatePiece();
		theDisplay.update();
		theGrid.checkRows();
	}

	/**
	 * Returns true if the game is over
	 */
	public boolean isGameOver() {
		// game is over if the piece occupies the same space as some non-empty
		// part of the grid. Usually happens when a new piece is made
		if (piece == null)
			return false;

		// check if game is already over
		if (isOver)
			return true;

		// check every part of the piece
		Point[] p = piece.getLocations();
		for (int i = 0; i < p.length; i++)
			if (theGrid.isSet((int) p[i].getX(), (int) p[i].getY())) {
				isOver = true;
				return true;
			}
		return false;
	}

	// Update the piece
	private void updatePiece() {

		if (piece == null) {

			
			piece = randomPiece();

			// CREATED NEW randomPiece ONCE CURRENT PIECE REACHES BOTTOM
			// AND BECOMES NULL
		}

		// set Grid positions corresponding to frozen piece
		// and then release the piece
		else if (!piece.canMove(Game.DOWN)) {
			Point[] p = piece.getLocations();
			Color c = piece.getColor();
			for (int i = 0; i < p.length; i++) {
				theGrid.set((int) p[i].getX(), (int) p[i].getY(), c);
			}
			piece = null;
		}

	}
	/*
	 * method to generate random number
	 * switch statement cases for each number for each shape
	 */
public Shape randomPiece(){
	Shape s;
	int num = rand.nextInt(7);
	
	switch(num){
	case 0: 
		s = new LShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 1: 
		s = new LeftLShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 2: 
		s = new SquareShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 3: 
		s = new SShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 4: 
		s = new TShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 5: 
		s = new ZShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	case 6: 
		s = new BarShape(1, Grid.WIDTH / 2 - 1, theGrid);
		break;
	default: s = null;
	}
	return s;
}
}
