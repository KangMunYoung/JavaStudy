import java.util.Calendar;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock2 extends JFrame{
	Font fnt = new Font("굴림", Font.BOLD, 100);
	Calendar now;
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);

	public DigitalClock2() {
		super("시계"); //setTitle("�떆怨�");
		add(lbl);
		lbl.setFont(fnt);
		
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		startClock();
		
	}
	
	//�떆媛꾨�寃�
	public void startClock() {
		do {
			//�떆媛꾨�寃�
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}while(true);
	}
	//�쁽�옱�떆媛�(�떆遺꾩큹) 00:00:00
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}
	
	public static void main(String[] args) {
		new DigitalClock2();
	}

}
