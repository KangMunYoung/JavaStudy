import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneTestEx extends JFrame{
	JSplitPane sp1, sp2, sp3, sp4;
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	CalculatorEX2 cal = new CalculatorEX2();
	SwingCalendar2 calendar = new SwingCalendar2();
	ImageIcon ii = new ImageIcon("img/test_img2.png");
	Packman2 pm = new Packman2();
	JLabel lbl = new JLabel(ii);
	
	public JSplitPaneTestEx() {
		
		sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, calendar); // �ð� Ķ����
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lbl,pm); // �̹���, �Ѹ�
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp4, cal); //(�ð�,Ķ����), ����
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp3);
		
		add(sp1);
		
		sp1.setDividerSize(3);
		sp2.setDividerSize(3);
		sp3.setDividerSize(3);
		sp4.setDividerSize(3);
		
		setSize(1200,1000);
		setVisible(true);
		pm.packmanStart(pm);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false); // true âũ�� ���� ����, false âũ�� ���� �Ұ���
		
		//�ѸǼ���
	
	}

	public static void main(String[] args) {
		new JSplitPaneTestEx();
	}

}
