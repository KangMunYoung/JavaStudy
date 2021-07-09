import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MouseAdapterTest extends JFrame{
	int x,y;
	Mycanvas mc = new Mycanvas();
	
	public MouseAdapterTest() {
		add(mc);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//일명의 내부클래스
		mc.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				//getButton() = 왼쪽버튼 : 1, 가운데 2 오른쪽 3
				//마우스가 클릭된곳의 좌표를 
				if(me.getButton()==1) {
					x = me.getX();
					y= me.getY();
					mc.repaint();
				}
			}
		});
	}
	
	public class Mycanvas extends Canvas {
		public void paint(Graphics g) {
			Random ran = new Random();
			g.setColor(new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)));
			g.fillOval(x-25, y-25, 50, 50);
			
		}
		
		public void update(Graphics g) {
			paint(g);
		}
		
		
	}
	
	public static void main(String[] args) {
		new MouseAdapterTest();
	}

}
