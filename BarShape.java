import java.awt.Color;

public class BarShape extends Shape {

	/**
	 * @author CSC143 Khang Quach Tetris Final version 04/17/16 Create a
	 *         Bar-Shape piece. See class description for actual location of r
	 *         and c
	 * 
	 * @param r
	 *            row location for this piece
	 * @param c
	 *            column location for this piece
	 * @param g
	 *            the grid for this game piece
	 * 
	 */
	public BarShape(int r, int c, Grid g) {
		super(r, c, g);
		// Create the squares
		square[0] = new Square(g, r, c, Color.cyan, true);
		square[1] = new Square(g, r, c + 1, Color.cyan, true);
		square[2] = new Square(g, r, c + 2, Color.cyan, true);
		square[3] = new Square(g, r, c - 1, Color.cyan, true);
	}

	/*
	 * @param rotation counter
	 * 
	 * @return if square is occupied will return false
	 */
	private boolean canSquareMove(int rotation) {

		if (rotation == 0 && square[0].canMove(Game.UP) && square[3].canMove(Game.UP) && square[1].canMove(Game.DOWN)
				&& square[2].canMove(Game.DOWN)) {
			return true;
		} else if (rotation == 1 && square[0].canMove(Game.RIGHT) && square[3].canMove(Game.RIGHT)
				&& square[1].canMove(Game.LEFT) && square[2].canMove(Game.LEFT)) {

			return true;
		} else if (rotation == 2 && square[2].canMove(Game.UP) && square[1].canMove(Game.UP)
				&& square[0].canMove(Game.DOWN) && square[3].canMove(Game.DOWN)) {

			return true;
		} else if (rotation == 3 && square[2].canMove(Game.RIGHT) && square[1].canMove(Game.RIGHT)
				&& square[0].canMove(Game.LEFT) && square[3].canMove(Game.LEFT)) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	/*
	 * @see Shape#rotate() override rotate method to support BarShape rotation
	 */
	public void rotate() {
		/*
		 * @param rotation count each case will check if canSquareMove is true
		 * if false BarShape will not rotate
		 */
		switch (rotation) {
		case 0:
			if (square[3].canMove(Game.UP) && square[0].canMove(Game.UP)) {
				square[3].move(Game.UP);
				square[0].move(Game.UP);
				square[1].move(Game.LEFT);
				square[2].move(Game.LEFT);

				if (canSquareMove(rotation) == true) {

					square[3].move(Game.UP);
					square[3].move(Game.RIGHT);
					square[2].move(Game.DOWN);
					square[2].move(Game.LEFT);

					rotation++;

				} else {
					square[2].move(Game.RIGHT);
					square[1].move(Game.RIGHT);
					square[3].move(Game.DOWN);
					square[0].move(Game.DOWN);
					rotation = 0;
				}
			} else {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 0;
			}
			break;

		case 1:
			if (square[1].canMove(Game.RIGHT)) {
				square[1].move(Game.RIGHT);
				if (square[1].canMove(Game.RIGHT) == true) {
					square[1].move(Game.LEFT);
					if (canSquareMove(rotation) == true) {
						square[3].move(Game.RIGHT);
						square[3].move(Game.DOWN);
						square[3].move(Game.DOWN);
						square[3].move(Game.RIGHT);
						square[0].move(Game.RIGHT);
						square[0].move(Game.DOWN);
						square[2].move(Game.LEFT);
						square[2].move(Game.UP);
						rotation++;
					}
				} else {
					square[1].move(Game.LEFT);
					rotation = 1;
				}

			} else {

				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 1;
			}
			break;
		case 2:
			if (square[2].canMove(Game.UP) && square[1].canMove(Game.UP)) {
				square[2].move(Game.UP);
				square[1].move(Game.UP);
				square[0].move(Game.LEFT);
				square[3].move(Game.LEFT);
				if (canSquareMove(rotation) == true) {
					square[2].move(Game.UP);
					square[2].move(Game.RIGHT);
					square[3].move(Game.DOWN);
					square[3].move(Game.LEFT);

					rotation++;
				} else {
					square[3].move(Game.RIGHT);
					square[0].move(Game.RIGHT);
					square[1].move(Game.DOWN);
					square[2].move(Game.DOWN);
					rotation = 2;
				}
			} else {
				square[0] = (square[0]);
				square[1] = (square[1]);
				square[2] = (square[2]);
				square[3] = (square[3]);
				rotation = 2;
			}
			break;
		case 3:
			if (square[0].canMove(Game.RIGHT)) {
				square[0].move(Game.RIGHT);
				if (square[0].canMove(Game.RIGHT)) {
					square[0].move(Game.LEFT);
					if (canSquareMove(rotation) == true) {
						square[2].move(Game.RIGHT);
						square[2].move(Game.DOWN);
						square[2].move(Game.DOWN);
						square[2].move(Game.RIGHT);
						square[1].move(Game.RIGHT);
						square[1].move(Game.DOWN);
						square[3].move(Game.LEFT);
						square[3].move(Game.UP);
						rotation = 0;
					}
				} else {
					square[0].move(Game.LEFT);
					rotation = 3;
				}
			} else {
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
