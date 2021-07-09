import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Packman extends JFrame implements KeyListener{
	Dimension dim;
	Image img;
	MyCanvas mc = new MyCanvas();
	int x; 
	int y ;
		
	int imgX1 = 0;

	public Packman() {
		setBackground(Color.WHITE);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addKeyListener(this);
		update(getGraphics());
		add(mc);
		dim = mc.getSize();
		x = (int)(dim.getWidth()/2-25);
		y = (int)(dim.getHeight()/2-25);
		System.out.println((int)(dim.getWidth()));
		while(true) {
			try {
				if(imgX1==1 || imgX1 ==0) {
					do {
						mc.repaint();
						x-=5;
						if(imgX1==1) {
							imgX1 =0;
						}else if(imgX1==0) {
							imgX1 =1;
						}
						
						if(x == -50) {
							x = (int)(dim.getWidth());
						}
						Thread.sleep(100);
					}while(imgX1==1 || imgX1 ==0);
					
				}else if(imgX1==2 || imgX1==3) {
					do {
						mc.repaint();
						x+=5;
						if(imgX1==2) {
							imgX1 =3;
						}else if(imgX1==3) {
							imgX1 =2;
						}
						if(x == (int)(dim.getWidth())) {
							x = -50;
						}
						Thread.sleep(100);
					}while(imgX1==2 || imgX1==3);
					
				}else if(imgX1==4 || imgX1==5) {
					do {
						mc.repaint();
						y-=5;
						if(imgX1==4) {
							imgX1 =5;
						}else if(imgX1==5) {
							imgX1 =4;
						}
						Thread.sleep(100);
					}while(imgX1==4 || imgX1==5);
					
				}else if(imgX1==6 || imgX1==7) {
					do {
						mc.repaint();
						y+=5;
						if(imgX1==6) {
							imgX1 =7;
						}else if(imgX1==7) {
							imgX1 =6;
						}
						Thread.sleep(100);
					}while(imgX1==6 || imgX1==7);
					
				}
				Thread.sleep(100);
			}catch(Exception e) {}
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
				imgX1 = 0;
			}else if(key == KeyEvent.VK_RIGHT) {
				imgX1 = 2;				
			}else if(key == KeyEvent.VK_UP) {
				imgX1 = 4;				
			}else if(key == KeyEvent.VK_DOWN) {
				imgX1 = 6;
			}
			
		}while(true);
	}
	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
	
	public static void main(String[] args) {
		new Packman();
	}

}
