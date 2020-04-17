package views;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelSnake extends JPanel {

	private ArrayList<Point> parts;

	public PanelSnake() {
		parts = new ArrayList<>();
		parts.add(new Point(100, 100));

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (parts) {
						parts.add(new Point(parts.get(parts.size() - 1).x + 12, parts.get(parts.size() - 1).y));
					}
				}
			}
		}).start();
	}

	public void move(int type) {
			if (type == 1) {
				parts.get(0).x--;
			}else if (type == 2) {
				parts.get(0).x++;
			}else if (type == 3) {
				parts.get(0).y--;
			}else if (type == 4) {
				parts.get(0).y++;
			}
			
	}

	public void move() {
		for (Point point : parts) {
			point.x++;
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Point point : parts) {
			g.fillRect(point.x, point.y, 10, 10);
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}

}
