

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
//								default: BorderLayout
public class JFrameTest extends JFrame{
	ImageIcon icon1 = new ImageIcon("img/test_img2.png");
	ImageIcon icon2 = new ImageIcon("img/test_img3.png");
	ImageIcon icon3 = new ImageIcon("img/test_img4.png");
	
	ImageIcon[] icon;
	public JFrameTest() {
		//BorderLayout을 GridLayout으로 변경하기
		GridLayout layout = new GridLayout(3,2, 10, 10);
//		setLayout(new GridLayout(3,2)); //일반적으로 이렇게 사용함
		setLayout(layout);
		
		JButton btn1 = new JButton("버튼1");
		add(btn1);
		
		JButton btn2 = new JButton(icon1);
		add(btn2);
		//마우스로 버튼 누를때 icon 변환하기
		btn2.setPressedIcon(icon2);
		btn2.setRolloverIcon(icon3);
		
		JButton btn3 = new JButton("무당벌래", icon1);
		add(btn3);
		//버튼을 활성화(true) 비활성화(false)
		btn3.setEnabled(false);
		
		JButton btn4 = new JButton("네번째버튼");
		add(btn4);
		
		
		//라디오 버튼
		JPanel pane = new JPanel(new GridLayout(3,1)); // 테두리가 없는 컨테이너
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");
		
		//RadioVutton 그룹 만들기
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1); bg.add(rBtn2); bg.add(rBtn3);
		
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3);
		
		add(pane);
		
		//토글버튼
		JToggleButton toggleBtn = new JToggleButton("토글",icon3);
		toggleBtn.setRolloverIcon(icon1);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);
		
		//라벨만들기
		JLabel lbl = new JLabel("라벨표시", JLabel.CENTER);
		add(lbl);
		
		
		//배경색 컬러설정하기
		btn1.setBackground(Color.ORANGE);
		//				R:0~255, G:0~255, B:0~255
		Color clr = new Color(100, 100, 200);
		toggleBtn.setBackground(clr);
		
		btn1.setForeground(Color.WHITE);
		//라벨색 넣어보기
		//투명처리해제
		lbl.setOpaque(true);
		lbl.setBackground(new Color(200,100,100));
		
		//Font : 글꼴(굴림체,돋움체,....) 글자유형(기울임, 진하게, 보통) 글자크기설정(px)
		Font fnt = new Font("굴림체", Font.ITALIC+Font.BOLD, 40);
		lbl.setFont(fnt);
		
		
		
		
		setSize(1200,700);
		setVisible(true);
		//프로그램이 종료되면 자원해제 하거나, 프로그램을 종료할수 없도록 설정....
		// DISPOSE_NO_CLOSE : 프로그램종료시 자원을 해제하라.
		// DO_NOTHING_ON_CLOSE : 닫기가 수행되지 않는다.
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	// 숫자로 넣어도 기능동작ok 코드분석을 위해 텍스트로 넣어줌
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//밀리초 만큼 일시정지 // Thread.sleep은 예외처리 필요
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		
		
		//버튼의 라벨, Label의 라벨을 변경하기
		btn1.setText("변경된 버튼 라벨");
		lbl.setText("변경된 라벨");
		
		
		
	}

	public static void main(String[] args) {
		new JFrameTest();
		
	}

}
