import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame {
	JTabbedPane tp;
	JLabel lbl;
	ImageIcon ii = new ImageIcon("img/test_img.jpg");
	
	JButton btn;
	ImageIcon iii = new ImageIcon("img/test_img2.png");
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	CalculatorEX2 cal = new CalculatorEX2();
	SwingCalendar2 sc = new SwingCalendar2();

	Packman2 pm = new Packman2();
	
	public JTabbedPaneTest() {
		super("�Ǹ޴�");
		
		tp = new JTabbedPane(JTabbedPane.LEFT);
		
		lbl = new JLabel(ii);
		tp.addTab("���̺�", lbl);
		btn = new JButton(iii);
		tp.addTab("��ư", btn);
		
		tp.addTab("�ð�", dc);
		
		tp.addTab("����", cal);
		
		tp.addTab("�޷�", iii, sc, "�޷�");
		
		tp.insertTab("Button", null, new JButton("�߰��� ��ư"), "�߰��� �Ǹ޴� �߰�", 3);
		
		tp.addTab("�Ѹ�", pm);		
		
		
		//���� Ȱ��ȭ ��Ȱ��ȭ
		//				�� index , true/false
//		tp.setEnabledAt(2, false);
		
		//ù��° ���� ������ ������ ��� ���� ��Ȱ��ȭ �Ѵ�.
//		tp.setEnabled(false);
		add(tp);
		setSize(500,500);
		
		
	    //paint �޼ҵ带 �ݺ�ȣ��
	    Thread t = new Thread(pm);
	    pm.setCanvasSize();//�Ѹ� ĵ���� ũ�⸦ �����Ѵ�.
	    t.start();

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//ũ�⼳��
		
		//���� ����
//		try {Thread.sleep(3000);}catch(Exception e) {}
//		tp.removeTabAt(3);
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
