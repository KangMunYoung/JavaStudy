import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSplitPaneTestEx extends JFrame{
	JSplitPane sp1, sp2, sp3, sp4;
	
	DigitalClock2 dc = new DigitalClock2();
	CalculatorEX2 cal = new CalculatorEX2();
	SwingCalendar2 calendar = new SwingCalendar2();
	ImageIcon ii = new ImageIcon("img/test_img.jpg");
	Packman2 pm = new Packman2();
	
	public JSplitPaneTestEx() {
		
		sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, calendar);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp4, cal);
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ii, pm);
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp3);
		
		add(sp1);
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	}

	public static void main(String[] args) {
		new JSplitPaneTestEx();
	}

}
