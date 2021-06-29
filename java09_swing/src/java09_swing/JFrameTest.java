package java09_swing;

import javax.swing.JFrame;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		setSize(500,500);
		setVisible(true);
		//프로그램이 종료되면 자원해제 하거나, 프로그램을 종료할수 없도록 설정....
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	// 숫자로 넣어도 기능동작ok 코드분석을 위해 텍스트로 넣어줌
	}

	public static void main(String[] args) {
		new JFrameTest();
		
	}

}
