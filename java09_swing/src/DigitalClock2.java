import java.util.Calendar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable{
   Font fnt = new Font("����", Font.BOLD, 100);
   Calendar now;
   JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);//��� ���� ���ϸ� ���ʿ� ����
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

}