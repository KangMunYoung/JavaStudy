import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Packman extends JFrame implements KeyListener{
	JPanel pane = new JPanel();
	
	Image img;
	MyCanvas mc = new MyCanvas();
	int x = 200;
	int y = 200;
	int imgX1 = 0;
	int imgX2 = 1+imgX1;
	
	public Packman() {
		setBackground(Color.WHITE);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addKeyListener(this);
		update(getGraphics());
		add("Center",mc);
		while(true) {
			mc.repaint();
			
		}
	}
	
		
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		public void paint(Graphics g) {
			g.drawImage(img, x, y, x+50, y+50, imgX1*50, 0, imgX1*50+50, 50, this);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		do {
			
			if(key == KeyEvent.VK_LEFT) {
				System.out.println(key);
				x -= 5;
				System.out.println(x);
				if(imgX1 == 0) {
					imgX1 = 1;
				}else if(imgX1 == 1) {
					imgX1 = 0;
				}else {
					imgX1=0;
				}
				break;
			}else if(key == KeyEvent.VK_RIGHT) {
				System.out.println(key);
				x += 5;
				if(imgX1 == 2) {
					imgX1 = 3;
				}else if(imgX1 == 3) {
					imgX1 = 2;
				}else {
					imgX1 = 2;
				}
				break;
				
			}else if(key == KeyEvent.VK_UP) {
				System.out.println(key);
				y -= 5;
				if(imgX1 == 4) {
					imgX1 = 5;
				}else if(imgX1 == 5) {
					imgX1 = 4;
				}else {
					imgX1 = 4;
				}
				break;
				
			}else if(key == KeyEvent.VK_DOWN) {
				System.out.println(key);
				y += 5;
				if(imgX1 == 6) {
					imgX1 = 7;
				}else if(imgX1 == 7) {
					imgX1 = 6;
				}else {
					imgX1 = 6;
				}
				break;
			}
			
		}while(true);
	}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	public static void main(String[] args) {
		new Packman();
	}

}
