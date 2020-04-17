package views;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class MyWindow extends JFrame{

	private ArrayList<Point> list;

	private static final long serialVersionUID = 1L;

	public MyWindow() {
		setExtendedState(MAXIMIZED_BOTH);

		list = new ArrayList<>();
		list.add(new Point(50, 50));
		list.add(new Point(100, 50));
		list.add(new Point(520, 50));

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {

				new Thread(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < 500; i++) {
							for (Point point : list) {
								point.y = point.y + 2;
							}
							repaint();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}).start();;
			}
		});

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Point point : list) {
			g.fillOval(point.x, point.y, 50, 50);
		}
	}

	public static void main(String[] args) {
		new MyWindow();
	}
}