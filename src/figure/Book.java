package figure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

public class Book {
	private Dimension dimension;
	private Color color;
	private Point point;

	public Book(int x) {
		Random random = new Random();;
		this.dimension = new Dimension(60, 30);
		this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		this.point = new Point(x, 0);
	}
	
	public Dimension getDimension() {
		return this.dimension;
	}
	
	public Color getColor() {
		return this.color;
	}

	public Point getPoint() {
		return point;
	}
	
}
