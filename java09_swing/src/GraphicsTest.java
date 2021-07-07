import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame {
MyCanvas canvas = new MyCanvas();
	public GraphicsTest() {
		add(canvas);
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			System.out.println("���� ������");
		}
		public void paint(Graphics g) {
			//�׸��� �׸���.
			//�����׸���
			g.drawLine(100, 100, 500, 500);
			//�׸��� �׸������� �÷� �����ϱ�
			g.setColor(Color.RED);
			g.drawLine(100, 500, 500, 100);
			
			g.drawOval(200, 200, 300, 300);
			
			g.drawRect(200, 200, 300, 300);
			
			g.setColor(Color.green);
			
			g.fillOval(300, 300, 300, 300);
			g.fillRect(100, 100, 300, 300);
			
			g.setColor(Color.blue);
			int[] x = {100,170,250,50};
			int[] y = {50,50,230,200};
			g.drawPolygon(x,y,x.length);
		}
	}
	public static void main(String[] args) {
		new GraphicsTest();
	}

}
