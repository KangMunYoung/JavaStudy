import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImageDrawTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
		JButton btn1 = new JButton("원본이미지");
		JButton btn2 = new JButton("축소이미지");
		JButton btn3 = new JButton("확대이미지");
		JButton btn4 = new JButton("좌우뒤집기");
		JButton btn5 = new JButton("상하뒤집기");
		JButton btn6 = new JButton("일부그리기");
		
	Image img;
	MyCanvas mc = new MyCanvas();
	String selectBtn = "원본이미지";//선택한 버튼의 정보를 저장할 변수
	
	
	public ImageDrawTest() {
		add(BorderLayout.NORTH, pane);
		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		
		////
		
		
		add(mc);
		
		setSize(1500,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae) {
		selectBtn = ae.getActionCommand();
		mc.repaint();//paint()메소드 호출
		
		
		
	}

	public class MyCanvas extends Canvas {
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/test_Img5.png");
		}
		
		public void paint(Graphics g) {
			//이미지 크기구하기 - 반드시 paint()메소드 안에서 구해야한다.
			int imgW = img.getWidth(this);
			int imgH = img.getHeight(this);
			
			if(selectBtn.equals("원본이미지")){//이미지 그림을 그린다.
				g.drawImage(img, 1, 1, this);
			}else if(selectBtn.equals("축소이미지")) {
				g.drawImage(img, 1, 1, imgW/2, imgH/2, this);
			}else if(selectBtn.equals("확대이미지")) {
				g.drawImage(img, 1, 1, imgW*2, imgH*2, this);
			}else if(selectBtn.equals("좌우뒤집기")) {
				//				캔버스 크기			이미지
				g.drawImage(img, 1, 1, imgW, imgH, imgW, 1, 1, imgH, this);
			}else if(selectBtn.equals("상하뒤집기")) {
				g.drawImage(img, 1, 1, imgW, imgH, 1, imgH, imgW, 1, this);
			}else if(selectBtn.equals("일부그리기")) {
				g.drawImage(img, 1, 1, imgW/2, imgH/2, imgW/4, imgH/4, imgH/3, imgW/3, this);
			}
		}
		// repaint() -> update() -> paint() 업데이트 있을떄
		// repaint() -> paint()
		public void update(Graphics g) {
			paint(g);
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {

		new ImageDrawTest();
	}

}
