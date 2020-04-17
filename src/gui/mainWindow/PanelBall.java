package gui.mainWindow;

import java.awt.Graphics;

import javax.swing.JPanel;

import ballStructure.MyLinkedList;
import ballStructure.NodeBall;
import figure.Ball;

@SuppressWarnings("serial")
public class PanelBall extends JPanel {
	private MyLinkedList<Ball> ballList;

	public PanelBall() {
		this.ballList = new MyLinkedList<Ball>();
	}

	public void addBall() {
		this.ballList.add(new Ball());
	}
	
	public void delete() {
		this.ballList.delete(this.ballList.getHead());
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawOval((int)(this.getWidth() * 0.3), (int)(this.getHeight() * 0.3), (int)(this.getWidth() * 0.4), (int)(this.getHeight() * 0.4));
		int x = 0;
		int y = 0;
		int w = getWidth() / 2;
		int h = getHeight() / 2;
		double r = this.getHeight() * 0.2;
		NodeBall<Ball> aux = this.ballList.getHead();
		while (aux != null) {
			x = (int) (((Math.cos(aux.getInfo().getDegree())) * r) + w);
			y = (int) (((Math.sin(aux.getInfo().getDegree())) * r) + h);
			g.setColor(aux.getInfo().getColor());
			g.fillOval(x, y, 15, 15);
			aux.getInfo().plussDegres();
			aux = aux.getNext();
		}
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
	}

}
