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
		add(mc);
		while(true) {
//			mc.repaint();
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
				if(imgX1 == 0) {
					imgX1 = 1;
				}else if(imgX1 == 1) {
					imgX1 = 0;
				}else {
					imgX1=0;
				}
				break;
			}else if(key == KeyEvent.VK_RIGHT) {
				if(imgX1 == 2) {
					imgX1 = 3;
				}else if(imgX1 == 3) {
					imgX1 = 2;
				}else {
					imgX1 = 2;
				}
				break;
				
			}else if(key == KeyEvent.VK_UP) {
				if(imgX1 == 4) {
					imgX1 = 5;
				}else if(imgX1 == 5) {
					imgX1 = 4;
				}else {
					imgX1 = 4;
				}
				break;
				
			}else if(key == KeyEvent.VK_DOWN) {
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
