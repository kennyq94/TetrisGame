import java.awt.Color;

public class SquareShape extends Shape {

	/**
	 * Create an Square-Shape piece. See class description for actual location
	 * of r and c
	 * 
	 * @param r
	 *            row location for this piece
	 * @param c
	 *            column location for this piece
	 * @param g
	 *            the grid for this game piece
	 * 
	 * @author CSC143 Khang Quach Tetris Final version 04/17/16
	 */
	public SquareShape(int r, int c, Grid g) {
		super(r, c, g);
		// Create the squares
		square[0] = new Square(g, r - 1, c, Color.BLACK, true);
		square[1] = new Square(g, r - 1, c + 1, Color.BLACK, true);
		square[2] = new Square(g, r, c, Color.BLACK, true);
		square[3] = new Square(g, r, c + 1, Color.BLACK, true);
		rotation = 0;
	}

	@Override
	/*
	 * @see Shape#rotate() override rotate method to support SquareShape
	 * rotation
	 */
	public void rotate() {
		/*
		 * @param rotation will stay at zero because square doesn't need to
		 * rotate
		 */

		switch (rotation) {
		case 0:
			if (rotation == 0) {

				square[0] = square[0];
				square[1] = square[1];
				square[2] = square[2];
				square[3] = square[3];

				rotation = 0;
			}
		}
	}
}