import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JSliderTest extends JFrame {
	JSlider s1 = new JSlider(JSlider.HORIZONTAL, 0, 100, 40);
	JSlider s2 = new JSlider(JSlider.VERTICAL, 0, 100, 50);
	
	public JSliderTest() {
		//s1에 옵션설정
		s1.setMajorTickSpacing(10);//주눈금표시
		s1.setMinorTickSpacing(2);//보조눈금
		s1.setPaintTicks(true);//눈금보여주기
		s1.setPaintLabels(true);//라벨표시(눈금숫자)

		//s2
		//라벨만들기
		Hashtable<Integer, JLabel> ht = new Hashtable<Integer, JLabel>();
		ht.put(0, new JLabel("하"));
		ht.put(50, new JLabel("중"));
		ht.put(100,new JLabel("상"));
		
		s2.setMajorTickSpacing(50); //눈금간격
		s2.setLabelTable(ht);//사용자정의 라벨설정
		s2.setPaintTicks(true);//눈금보이기
		s2.setPaintLabels(true);//라벨보이기
		
		add(BorderLayout.NORTH, s1);
		add(BorderLayout.WEST, s2);
		
		
		setSize(500, 500);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new JSliderTest();
	}

}
