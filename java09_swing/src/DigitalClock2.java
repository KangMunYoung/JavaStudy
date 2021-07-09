import java.util.Calendar;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame {
   Font fnt = new Font("굴림", Font.BOLD, 100);
   Calendar now;
   JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);//가운데 정렬 안하면 왼쪽에 찍힘
   ImageIcon icon = new ImageIcon("img/th.jpg");

   public DigitalClock() {   
      super("CLOCK");
      add(lbl);
      lbl.setFont(fnt);
      
      setSize(500,200);
      setVisible(true);
      
      startClock();
   }
   //시간을 변경
   public void startClock() {
      do {
         //시간을 변경
         lbl.setText(getTimer());
         try {
            Thread.sleep(1000);
         }catch(InterruptedException e) {
            
         }
      }while(true);
   }
   //현재시간(시분초)을 00:00:00
   public String getTimer() {
      now = Calendar.getInstance();
      
      SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");//대문자  H 13시 이런식으로 찍힘
      return fmt.format(now.getTime());
   
   }
   public static void main(String[] args) {
      new DigitalClock();

   }

}