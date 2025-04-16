package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		//FIXME
		this.x = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
		this.y = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void respawn() {
		this.x = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
		this.y = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * Math.random();
	}
}