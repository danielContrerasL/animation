package figure;

import java.awt.Color;
import java.util.Random;

public class Ball {
	private Color color;
	private double degree;

	public Ball() {
		Random random = new Random();
		this.color = new Color(random.nextInt(257), random.nextInt(257), random.nextInt(257));
	}

	public Color getColor() {
		return color;
	}

	public double getDegree() {
		return degree;
	}

	public void plussDegres() {
		this.degree += 0.1;
		if (this.degree > 360) {
			this.degree = 0;
		}
	}

}
