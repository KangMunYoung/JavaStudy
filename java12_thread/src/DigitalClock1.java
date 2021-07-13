import java.util.Calendar;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock1 extends JFrame implements Runnable{
   Font fnt = new Font("����", Font.BOLD, 100);
   Calendar now;
   JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);//��� ���� ���ϸ� ���ʿ� ����
   ImageIcon icon = new ImageIcon("img/th.jpg");
   int x, y;
   
   public DigitalClock1() {   
      super("CLOCK");
      add(lbl);
      lbl.setFont(fnt);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }
   
   public DigitalClock1(int x, int y) {
	   this();
	   this.x = x;
	   this.y= y;
	   setBounds(x, y, 500,200);
	   setVisible(true);
	   
	   Thread t = new Thread(this);
	   t.start();
   }
   //�ð��� ����
   public void run() {
      do {
         //�ð��� ����
         lbl.setText(getTimer());
         try {
        	 Thread.sleep(1000);
         }catch(InterruptedException e) {}
      }while(true);
   }
   //����ð�(�ú���)�� 00:00:00
   public String getTimer() {
      now = Calendar.getInstance();
      SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");//�빮��  H 13�� �̷������� ����
      return fmt.format(now.getTime());
      
   }
   
   public static void main(String[] args) {
//      DigitalClock2 dc1 = new DigitalClock2(0,0);
//      Thread t1 = new Thread(dc1);
//      t1.start();
//      DigitalClock2 dc2 = new DigitalClock2(500,0);
//      Thread t2 = new Thread(dc2);
//      t2.start();
//      DigitalClock2 dc3 = new DigitalClock2(1000,0);
//      Thread t3 = new Thread(dc3);
//      t3.start();
	   new DigitalClock1(0,0);
	   new DigitalClock1(500,0);
	   new DigitalClock1(1000,0);
   }

}