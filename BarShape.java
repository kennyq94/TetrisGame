import java.awt.Color;

public class BarShape extends Shape {
	 public BarShape(int r, int c, Grid g)
	    {
	        super(r, c, g);
	        // Create the squares
	        square[0] = new Square(g, r, c, Color.cyan, true);
	        square[1] = new Square(g, r, c+1 , Color.cyan, true);
	        square[2] = new Square(g, r, c+2, Color.cyan, true);
	        square[3] = new Square(g, r,c-1, Color.cyan, true);
	    }
}
