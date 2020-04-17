package gui.mainWindow;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import figure.Book;
import structure.Stack;

@SuppressWarnings("serial")
public class AnimationStack extends JDialog {
	private int y;
	private int base;
	private int speed;
	private Book[] book;
	private Book actaulBook;
	private Stack<Book> stack;

	public AnimationStack() {
		this.stack = new Stack<Book>();
		this.setSize(500, 500);
		this.speed = 1;
		this.base = 40;
		this.y = 0;
		this.setMinimumSize(this.getSize());
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.initButton();
		this.initFigure();
	}

	private void initFigure() {
		this.book = new Book[15];
		for (int i = 0; i < this.book.length; i++) {
			this.book[i] = new Book(((this.getWidth() / 2) - 30));
		}
	}

	public void simulate() throws InterruptedException {
		for (int i = 0; i < book.length; i++) {
			if (Math.random() > 0.5 || this.base == 40) {
				this.push(this.book[i]);
			} else {
				this.pop();

			}
		}
		this.clear();
	}

	private void push(Book book) throws InterruptedException {
		this.actaulBook = book;
		this.stack.push(book);
		while (this.y < (this.getHeight() - this.base)) {
			this.repaint();
			this.y++;
			Thread.sleep(this.speed);
		}
		book.getPoint().y = this.y;
		this.y = 0;
		this.base += 40;
	}

	private void pop() throws InterruptedException {
		Book remove = this.stack.pop();
		while (remove.getPoint().x < (this.getWidth() - 80)) {// +
																// this.actaulBook.getDimension().width)){
			this.repaint();
			remove.getPoint().x++;
			Thread.sleep(this.speed);
		}
		this.base -= 40;
	}

	public void clear() throws InterruptedException {
		this.base = 40;
		this.initFigure();
		this.simulate();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.actaulBook.getColor());
		g.fillRect(this.actaulBook.getPoint().x, this.y, this.actaulBook.getDimension().width,
				this.actaulBook.getDimension().height);
		for (int i = 0; i < this.book.length; i++) {
			g.setColor(this.book[i].getColor());
			g.fillRect(this.book[i].getPoint().x, this.book[i].getPoint().y, this.actaulBook.getDimension().width,
					this.actaulBook.getDimension().height);

		}
	}
	
	private void initButton() {
		JButton button = new JButton("Salir");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.add(button, BorderLayout.LINE_START);
		
	}

	public static void main(String[] args) {
		AnimationStack animationStack = new AnimationStack();
		animationStack.setVisible(true);
		try {
			animationStack.simulate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
