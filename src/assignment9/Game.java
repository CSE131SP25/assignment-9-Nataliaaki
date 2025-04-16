package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;

	public Game() {
		StdDraw.enableDoubleBuffering();
		
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		showIntroScreen();  
		
		while (snake.isInBounds()) { 
			int dir = getKeypress();
			
			if (dir != -1) {
				snake.changeDirection(dir);  
			}
			snake.move();  

			if (snake.eat(food)) {
			    food.respawn(); 
			}

			updateDrawing();  
		}
		
		showGameOverScreen();  
	}
	
	private void showIntroScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.text(0.5, 0.7, "Let's Play Snake!");
		StdDraw.text(0.5, 0.5, "Press any key to start...");
		StdDraw.show();

		while (!StdDraw.hasNextKeyTyped()) {
		}
		StdDraw.nextKeyTyped();  
	}
	
	private void showGameOverScreen() {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.text(0.5, 0.4, "See you next time!");
		StdDraw.show();

		while (!StdDraw.hasNextKeyTyped()) {
		}
		StdDraw.nextKeyTyped();  
	}
	
	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);  
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}