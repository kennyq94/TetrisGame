import java.awt.*;

/**
 * This is the Tetris board represented by a (HEIGHT - by - WIDTH) matrix of
 * Squares The upper left Square is at (0,0) The lower right Square is at
 * (HEIGHT -1, WIDTH -1) Given a Square at (x,y) the square to the left is at
 * (x-1, y) the square below is at (x, y+1)
 * 
 * Each Square has a color. A white Square is EMPTY; any other color means that
 * spot is occupied (i.e. a piece cannot move over/to an occupied square). A
 * grid will also remove completely full rows.
 * 
 * * @author Khang Quach Tetris implementations 04/11/16
 */
public class Grid {
	private Square[][] board;
	// Width and Height of Grid in number of squares
	public static final int HEIGHT = 20;
	public static final int WIDTH = 10;
	private static final int BORDER = 5;

	public static final int LEFT = 100; // pixel position of left of grid
	public static final int TOP = 75; // pixel position of top of grid

	private static final Color EMPTY = Color.white;

	/**
	 * Create the Grid
	 */
	public Grid() {
		board = new Square[HEIGHT][WIDTH];

		// put squares in the board
		for (int row = 0; row < HEIGHT; row++)
			for (int col = 0; col < WIDTH; col++)
				board[row][col] = new Square(this, row, col, EMPTY, false);

	}

	/**
	 * Returns true if the location (row, col) on the grid is occupied
	 * 
	 * @param row
	 *            the row in the grid
	 * @param col
	 *            the column in the grid
	 */
	public boolean isSet(int row, int col) {
		boolean isEmpty = board[row][col].getColor().equals(EMPTY);
		return !isEmpty;
	}

	/**
	 * Change the color of the Square at the given location
	 * 
	 * @param row
	 *            the row of the Square in the Grid
	 * @param col
	 *            the column of the Square in the Grid
	 * @param c
	 *            the color to set the Square
	 * @throws IndexOutOfBoundsException
	 *             if row < 0 || row>= WIDTH || col < 0 || col >= HEIGHT
	 */
	public void set(int row, int col, Color c) {
		board[row][col].setColor(c);
	}

	/**
	 * Check for and remove all solid rows of squares If a solid row is found
	 * and removed, all rows above it are moved down and the top row set to
	 * empty
	 */
	public void checkRows() {
		// checks the whole grid for filled row then clears it with clearRow
		for (int i = 0; i < HEIGHT; i++) {
			clearRow(i);

		}
	}
 
	/*
	 * private class to clear the row if filled
	 * 
	 * @param row to be cleared
	 */
	private void clearRow(int row) {
		// if isFilled == true clear the row
		// then the whole grid will get color from one row above
		if (isFilled(row) == true) {
			for (int i = row; i > 0; i--) {
				for (int x = 0; x < WIDTH; x++) {
					set(i, x, board[i - 1][x].getColor());
				}
			}
		}
	}
	/*
	 * @param the row that the boolean will test
	 * 
	 * @return true if row is filled else return false
	 */

	private boolean isFilled(int row) {
		for (int i = 0; i < WIDTH; i++) {
			if (isSet(row, i) == false) {
				return false;
			}

		}
		return true;
	}

	/**
	 * Draw the grid on the given Graphics context
	 */
	public void draw(Graphics g) {

		// draw the edges as rectangles: left, right in blue then bottom in red
		g.setColor(Color.blue);
		g.fillRect(LEFT - BORDER, TOP, BORDER, HEIGHT * Square.HEIGHT);
		g.fillRect(LEFT + WIDTH * Square.WIDTH, TOP, BORDER, HEIGHT * Square.HEIGHT);
		g.setColor(Color.red);
		g.fillRect(LEFT - BORDER, TOP + HEIGHT * Square.HEIGHT, WIDTH * Square.WIDTH + 2 * BORDER, BORDER);

		// draw all the squares in the grid
		for (int r = 0; r < HEIGHT; r++)
			for (int c = 0; c < WIDTH; c++)
				board[r][c].draw(g);
	}
}
