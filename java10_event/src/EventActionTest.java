import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventActionTest extends JFrame{
	JButton btn = new JButton("클릭하세요");
	public EventActionTest() {
		add(BorderLayout.NORTH, btn);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//이벤트처리
		// 1. 인터페이스 상속받는다
		// 2. 이벤트가 발생하는 컴퍼넌트를 등록한다
		// 3. 추상메소드를 오버라이딩한다.
	}

	public static void main(String[] args) {
		new EventActionTest();
	}

}
