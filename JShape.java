import java.awt.Color;

public class JShape extends Shape {

	/**
	 * Create an J-Shape piece. See class description for actual location of r
	 * and c
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
	public JShape(int r, int c, Grid g) {
		super(r, c, g);
		// Create the squares
		square[0] = new Square(g, r - 1, c, Color.BLUE, true);
		square[1] = new Square(g, r, c, Color.BLUE, true);
		square[2] = new Square(g, r + 1, c, Color.BLUE, true);
		square[3] = new Square(g, r + 1, c - 1, Color.BLUE, true);
	}
	/*
	 * @param rotation counter
	 * 
	 * @return if square is occupied will return false
	 */

	private boolean canSquareMove1(int rotation) {

		if (rotation == 0 && square[1].canMove(Game.RIGHT) && square[1].canMove(Game.LEFT)
				&& square[0].canMove(Game.RIGHT) && square[0].canMove(Game.LEFT) && square[2].canMove(Game.RIGHT)) {
			return true;
		}
		if (rotation == 1 && square[0].canMove(Game.DOWN) && square[0].canMove(Game.UP) && square[1].canMove(Game.UP)
				&& square[1].canMove(Game.DOWN) && square[2].canMove(Game.DOWN)) {

			return true;
		}
		if (rotation == 2 && square[0].canMove(Game.LEFT) && square[0].canMove(Game.RIGHT)
				&& square[1].canMove(Game.RIGHT) && square[1].canMove(Game.LEFT) && square[2].canMove(Game.LEFT)) {

			return true;
		}
		if (rotation == 3 && square[0].canMove(Game.UP) && square[0].canMove(Game.DOWN) && square[1].canMove(Game.UP)
				&& square[1].canMove(Game.DOWN) && square[2].canMove(Game.UP)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	/*
	 * @see Shape#rotate() override rotate method to support JShape rotation
	 */
	public void rotate() {
		/*
		 * @param rotation count each case will check if canSquareMove is true
		 * if false JShape will not rotate
		 */
		switch (rotation) {
		case 0:
			if (canSquareMove1(rotation) == true) {

				square[0].move(Game.RIGHT);
				square[0].move(Game.DOWN);
				square[3].move(Game.UP);
				square[3].move(Game.UP);
				square[2].move(Game.LEFT);
				square[2].move(Game.UP);

				rotation++;
			} else {
				/*
				 * square[0] = (square[0]); square[1] = (square[1]); square[2] =
				 * (square[2]); square[3] = (square[3]);
				 */
				rotation = 0;
			}
			break;

		case 1:
			if (canSquareMove1(rotation) == true) {
				square[0].move(Game.DOWN);
				square[0].move(Game.LEFT);
				square[3].move(Game.RIGHT);
				square[3].move(Game.RIGHT);
				square[2].move(Game.UP);
				square[2].move(Game.RIGHT);

				rotation++;
			} else if (canSquareMove1(rotation) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 1;
			}
			break;
		case 2:
			if (canSquareMove1(rotation) == true) {
				square[3].move(Game.DOWN);
				square[3].move(Game.DOWN);
				square[2].move(Game.RIGHT);
				square[2].move(Game.DOWN);
				square[0].move(Game.LEFT);
				square[0].move(Game.UP);
				rotation++;
			}

			else if (canSquareMove1(rotation) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 2;
			}
			break;
		case 3:
			if (canSquareMove1(rotation) == true) {
				square[0].move(Game.UP);
				square[0].move(Game.RIGHT);
				square[3].move(Game.LEFT);
				square[3].move(Game.LEFT);
				square[2].move(Game.DOWN);
				square[2].move(Game.LEFT);
				rotation = 0;
			} else if (canSquareMove1(rotation) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 3;
			}

			break;
		}
	}
}
