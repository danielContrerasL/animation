package gui.mainWindow;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JDialog;
import figure.Book;
import figure.Constant;
import structure.Node;
import structure.Queue;

@SuppressWarnings("serial")
public class AnimationQueue extends JDialog{
	private Queue<Book> queue;
	private Book actaulBook;
	private Book[] book;
	private int base;
	private int y;
	
	public AnimationQueue() {
		this.y = 0;
		this.base = 40;
		this.setSize(500, 500);
		this.queue = new Queue<Book>();
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setMinimumSize(this.getSize());
		this.initFigure();
	}
	
	private void initFigure() {
		this.book = new Book[100];
		for (int i = 0; i < this.book.length; i++) {
			this.book[i] = new Book( (this.getWidth()/2) - Constant.CENTER_BOOK);
		}
	}
	
	public void simulate() throws InterruptedException {
		for (int i = 0; i < this.book.length; i++) {
			if (Math.random() < 0.5 || this.base == Constant.BASE) {//push
				this.push(this.book[i]);
				System.out.println((this.base == Constant.BASE)?"Entro por base " + i:"entro " + i);
			}else {//pop
				this.pop();
			}
		}
	}
	
	private void push(Book book) throws InterruptedException {
		this.queue.push(book);
		this.actaulBook = book;
		while (book.getPoint().y < (this.getHeight() - this.base)) {
			this.actaulBook.getPoint().y++;
			this.repaint();
			Thread.sleep(Constant.SPEED);
		}
		this.base += Constant.BASE;
	}
	
	private void pop() throws InterruptedException {
		Book aux = this.queue.pop();
		while (aux.getPoint().x < (this.getWidth() + 60)) {
			aux.getPoint().x++;
			Thread.sleep(Constant.SPEED);
			repaint();
		}
		this.base -= Constant.BASE;
		this.update();
	}
	
	private void update() throws InterruptedException {
		Node<Book> aux = queue.getHead();
		while (aux != null) {
			for (int i = 0; i < Constant.BASE; i++) {
				aux.getInfo().getPoint().y ++;
				repaint();
				Thread.sleep(Constant.SPEED);
			}
			aux = aux.getNext();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(this.actaulBook.getColor());
		g.fillRect(this.actaulBook.getPoint().x, this.y, this.actaulBook.getDimension().width,
				this.actaulBook.getDimension().height);
		Node<Book> aux = queue.getHead();
		while (aux != null) {
			g.setColor(aux.getInfo().getColor());
			g.fillRect(aux.getInfo().getPoint().x, aux.getInfo().getPoint().y, this.actaulBook.getDimension().width,
					this.actaulBook.getDimension().height);
			aux = aux.getNext();

		}
	}
	/**
	 * este  metodo funciona
	 * 
	 * @param args
	 */
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.setColor(this.actaulBook.getColor());
//		g.fillRect(this.actaulBook.getPoint().x, this.y, this.actaulBook.getDimension().width,
//				this.actaulBook.getDimension().height);
//		for (int i = 0; i < this.book.length; i++) {
//			g.setColor(this.book[i].getColor());
//			g.fillRect(this.book[i].getPoint().x, this.book[i].getPoint().y, this.actaulBook.getDimension().width,
//					this.actaulBook.getDimension().height);
//
//		}
//	}
	
	
	public static void main(String[] args) {
		AnimationQueue animationQueue = new AnimationQueue();
		animationQueue.setVisible(true);
		try {
			animationQueue.simulate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
