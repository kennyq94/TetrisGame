import java.awt.Color;

public class SShape extends Shape {
	/**
	 * Create an S-Shape piece. See class description for actual location of r
	 * and c
	 * 
	 * @param r
	 *            row location for this piece
	 * @param c
	 *            column location for this piece
	 * @param g
	 *            the grid for this game piece
	 * 
	 *  @author CSC143 Khang Quach Tetris Final version 04/17/16
	 */
	public SShape(int r, int c, Grid g) {
		super(r, c, g);
		// Create the squares
		square[0] = new Square(g, r, c, Color.GREEN, true);
		square[1] = new Square(g, r, c + 1, Color.GREEN, true);
		square[2] = new Square(g, r + 1, c, Color.GREEN, true);
		square[3] = new Square(g, r + 1, c - 1, Color.GREEN, true);
	}
	/*@param rotation counter
	 *@return if square is occupied
	 * will return false
	 */
	private boolean canSquareMove(int rotation) {

		if (rotation == 0 && square[3].canMove(Game.UP) && square[1].canMove(Game.DOWN)) {
			return true;
		} else if (rotation == 1 && square[3].canMove(Game.RIGHT) && square[0].canMove(Game.RIGHT)
				&& square[1].canMove(Game.LEFT)) {

			return true;
		} else if (rotation == 2 && square[1].canMove(Game.UP) && square[3].canMove(Game.DOWN)) {

			return true;
		} else if (rotation == 3 && square[1].canMove(Game.RIGHT) && square[2].canMove(Game.RIGHT)
				&& square[3].canMove(Game.LEFT)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	/*
	 * @see Shape#rotate()
	 * override rotate method 
	 * to support SShape rotation
	 */
	public void rotate() {
		/*
		 * @param rotation count
		 * each case will check if
		 * canSquareMove is true
		 * if false SShape will not rotate
		 */

		switch (rotation) {
		case 0:
			if (square[3].canMove(Game.UP) == true) {
				square[3].move(Game.UP);
				if (canSquareMove(rotation) == true) {
					square[3].move(Game.UP);
					square[2].move(Game.LEFT);
					square[2].move(Game.UP);
					square[1].move(Game.DOWN);
					square[1].move(Game.LEFT);
					rotation++;
				} else {
					square[3].move(Game.DOWN);
					rotation = rotation;
				}

			} else if (square[3].canMove(Game.UP) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = rotation;
			}
			break;

		case 1:
			if (square[3].canMove(Game.RIGHT) == true) {
				square[3].move(Game.RIGHT);
				if (canSquareMove(rotation) == true) {

					square[3].move(Game.RIGHT);
					square[3].move(Game.DOWN);
					square[1].move(Game.LEFT);
					square[0].move(Game.DOWN);
					square[2].move(Game.RIGHT);

					rotation++;
				} else {
					square[3].move(Game.LEFT);
				}
			} else if (square[3].canMove(Game.RIGHT) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = rotation;
			}
			break;
		case 2:
			if (square[1].canMove(Game.UP) == true) {
				square[1].move(Game.UP);
				if (canSquareMove(rotation) == true) {
					square[1].move(Game.UP);
					square[0].move(Game.LEFT);
					square[0].move(Game.UP);
					square[3].move(Game.DOWN);
					square[3].move(Game.LEFT);
					rotation++;
				} else {
					square[1].move(Game.DOWN);
				}
			}

			else if (square[1].canMove(Game.UP) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = rotation;
			}
			break;
		case 3:
			if (square[1].canMove(Game.RIGHT) == true) {
				square[1].move(Game.RIGHT);
				if (canSquareMove(rotation) == true) {
					square[1].move(Game.RIGHT);
					square[1].move(Game.DOWN);
					square[3].move(Game.LEFT);
					square[2].move(Game.DOWN);
					square[0].move(Game.RIGHT);
					rotation = 0;
				} else {
					square[1].move(Game.LEFT);
				}
			} else if (square[1].canMove(Game.RIGHT) == false) {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = rotation;
			}

			break;
		}
	}

}
