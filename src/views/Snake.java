package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Snake extends JFrame {

	private PanelSnake ps;

	public Snake(Controller controller) {
		addKeyListener(controller);
		ps = new PanelSnake();
		setSize(500,500);
		setMinimumSize(getSize());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(ps, BorderLayout.CENTER);
	}
	
	
	public void move(int type) {
		ps.move(type);
	}


	
}
