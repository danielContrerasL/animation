package views;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

	private Snake snake;

	public Controller() {
		snake = new Snake(this);
		snake.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	int type = 0;
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			type = 1;
			break;
		case KeyEvent.VK_RIGHT:
			type = 2;
			break;
		case KeyEvent.VK_UP:
			type = 3;
			break;
		case KeyEvent.VK_DOWN:
			type = 4;
			break;

		default:
			break;
		}
		snake.move(type);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public static void main(String[] args) {
		new Controller();
	}

}
