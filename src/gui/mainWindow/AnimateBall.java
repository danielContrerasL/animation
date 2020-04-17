package gui.mainWindow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class AnimateBall extends JDialog {
	private PanelBall ball;
	public AnimateBall() {
		this.setSize(500, 500);
		this.setMinimumSize(this.getSize());
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.init();
	}
	
	private void init() {
		this.ball = new PanelBall();
		this.add(ball, BorderLayout.CENTER);
		
		JButton button = new JButton("add");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.addBall();
			}
		});
		
		this.add(button, BorderLayout.LINE_START);
		
		JButton button2 = new JButton("delete");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ball.delete();
			}
		});
		
		this.add(button2, BorderLayout.LINE_END);
	}
	
	



	public static void main(String[] args) {
		AnimateBall animateBall = new AnimateBall();
		animateBall.setVisible(true);
	}
}
