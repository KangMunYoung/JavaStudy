import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest extends JFrame{
	JSplitPane sp1, sp2;
	CalculatorEX2 cal = new CalculatorEX2();
	SwingCalendar2 calendar = new SwingCalendar2();
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	public JSplitPaneTest() {
		
		//수직나누기
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cal, calendar);
		
		//수평나누기
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp);
		
		add(sp1);
		
		//경계선의 위치를 설정할수있다.
		sp2.setDividerLocation(350);//위쪽이 350px
		sp1.setDividerLocation(800);//왼쪽이 800px
		
		//경계선의 두께 설정
		sp2.setDividerSize(0);
		sp1.setDividerSize(20);
		
		//원터치
		sp1.setOneTouchExpandable(true);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitPaneTest();
	}

}
