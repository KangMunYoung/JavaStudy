import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable{
   Font fnt = new Font("굴림", Font.BOLD, 100);
   Calendar now;
   JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);//가운데 정렬 안하면 왼쪽에 찍힘
   ImageIcon icon = new ImageIcon("img/th.jpg");
   int x, y;
   
   public DigitalClock2() {
	   setLayout(new BorderLayout());
	   add(lbl);
	   lbl.setFont(fnt);
   }
   
   public DigitalClock2(int x, int y) {
	   this();
	   this.x = x;
	   this.y= y;
	  //setBounds(x, y, 500,200);
	//setVisible(true);
	   
	   Thread t = new Thread(this);
	   t.start();
   }
   //시간을 변경
   public void run() {
      do {
         //시간을 변경
         lbl.setText(getTimer());
         try {
        	 Thread.sleep(1000);
         }catch(InterruptedException e) {}
      }while(true);
   }
   //현재시간(시분초)을 00:00:00
   public String getTimer() {
      now = Calendar.getInstance();
      SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");//대문자  H 13시 이런식으로 찍힘
      return fmt.format(now.getTime());
      
   }

}