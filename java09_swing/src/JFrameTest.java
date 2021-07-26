

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
		//BorderLayout�� GridLayout���� �����ϱ�
		GridLayout layout = new GridLayout(3,2, 10, 10);
//		setLayout(new GridLayout(3,2)); //�Ϲ������� �̷��� �����
		setLayout(layout);
		
		JButton btn1 = new JButton("��ư1");
		add(btn1);
		
		JButton btn2 = new JButton(icon1);
		add(btn2);
		//���콺�� ��ư ������ icon ��ȯ�ϱ�
		btn2.setPressedIcon(icon2);
		btn2.setRolloverIcon(icon3);
		
		JButton btn3 = new JButton("�������", icon1);
		add(btn3);
		//��ư�� Ȱ��ȭ(true) ��Ȱ��ȭ(false)
		btn3.setEnabled(false);
		
		JButton btn4 = new JButton("�׹�°��ư");
		add(btn4);
		
		
		//���� ��ư
		JPanel pane = new JPanel(new GridLayout(3,1)); // �׵θ��� ���� �����̳�
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");
		
		//RadioVutton �׷� �����
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1); bg.add(rBtn2); bg.add(rBtn3);
		
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3);
		
		add(pane);
		
		//��۹�ư
		JToggleButton toggleBtn = new JToggleButton("���",icon3);
		toggleBtn.setRolloverIcon(icon1);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);
		
		//�󺧸����
		JLabel lbl = new JLabel("��ǥ��", JLabel.CENTER);
		add(lbl);
		
		
		//���� �÷������ϱ�
		btn1.setBackground(Color.ORANGE);
		//				R:0~255, G:0~255, B:0~255
		Color clr = new Color(100, 100, 200);
		toggleBtn.setBackground(clr);
		
		btn1.setForeground(Color.WHITE);
		//�󺧻� �־��
		//����ó������
		lbl.setOpaque(true);
		lbl.setBackground(new Color(200,100,100));
		
		//Font : �۲�(����ü,����ü,....) ��������(�����, ���ϰ�, ����) ����ũ�⼳��(px)
		Font fnt = new Font("����ü", Font.ITALIC+Font.BOLD, 40);
		lbl.setFont(fnt);
		
		
		
		
		setSize(1200,700);
		setVisible(true);
		//���α׷��� ����Ǹ� �ڿ����� �ϰų�, ���α׷��� �����Ҽ� ������ ����....
		// DISPOSE_NO_CLOSE : ���α׷������ �ڿ��� �����϶�.
		// DO_NOTHING_ON_CLOSE : �ݱⰡ ������� �ʴ´�.
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	// ���ڷ� �־ ��ɵ���ok �ڵ�м��� ���� �ؽ�Ʈ�� �־���
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//�и��� ��ŭ �Ͻ����� // Thread.sleep�� ����ó�� �ʿ�
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		
		
		//��ư�� ��, Label�� ���� �����ϱ�
		btn1.setText("����� ��ư ��");
		lbl.setText("����� ��");
		
		
		
	}

	public static void main(String[] args) {
		new JFrameTest();
		
	}

}
