import java.awt.Color;

public class JShape extends Shape {
	public JShape(int r, int c, Grid g) {
		super(r, c, g);
		// Create the squares
		square[0] = new Square(g, r - 1, c, Color.BLUE, true);
		square[1] = new Square(g, r, c, Color.BLUE, true);
		square[2] = new Square(g, r + 1, c, Color.BLUE, true);
		square[3] = new Square(g, r + 1, c - 1, Color.BLUE, true);
	}

	@Override
	public void rotate() {

		}
	}

