import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Packman2 extends JFrame implements KeyListener{
   MyCanvas mc = new MyCanvas();
   Image img;
   Dimension dim;
   
   //캔버스의 x, y
   int x, y;
   //이미지 포인트로 사용할 변수
   int p = 0;
   
   public Packman2() {
      add(mc);
      
      
      setSize(500,500);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      //캔버스 기를 구한다.
      dim = mc.getSize();
      x = (int)(dim.getWidth()/2 - 25);
      y =(int)(dim.getHeight()/2 -25);
      //커서를캔버스설정
      mc.setFocusable(true);
      //이벤트 등록
      mc.addKeyListener(this);
      
      //paint 메소드를 반복호출
      while(true) {
         mc.repaint();
         
         //이미지 변환 	0,1		2,3		4,5		6,7
         if(p%2==0) p++;
         else p--;
         
         
         //좌표이동
         if(p==0 || p==1) {
        	 x-=5;
         	if(x<=-50) x = (int)dim.getWidth();
         }else if(p==2 || p==3) {
        	 x+=5;
        	 if(x>=(int)dim.getWidth()) x=-50;
         }else if(p==4 || p==5) {
        	 y-=5;
        	 if(y<= -50) y=(int)dim.getHeight();
         }else if(p==6 || p==7) {
        	 y+=5;
        	 if(y>= (int)dim.getHeight()) y= -50;
         }
         //시간지연
         try {
            Thread.sleep(200);
         }catch(Exception e) {
            
         }
      }
      
      
   }
   
   public class MyCanvas extends Canvas{
      Image packMan;
      MyCanvas(){
         packMan = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
      
      }
      public void paint(Graphics g) {
         //                  canvas                 image         
         //                           p=0    0,   0, 50       50
         //                                       
         g.drawImage(packMan, x, y,x+50,y+50,     p*50,  0, p*50+50, 50, this);
      }
   }
   public void keyTyped(KeyEvent e) {
   }
   public void keyPressed(KeyEvent e) {
   }
   public void keyReleased(KeyEvent ke) {
	   int code = ke.getKeyCode();
	   if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
		   p=0;
	   }else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
		   p=2;
	   }else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
		   p=4;
	   }else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
		   p=6;
	   }
   }

   public static void main(String[] args) {
      new Packman2();
   }



}