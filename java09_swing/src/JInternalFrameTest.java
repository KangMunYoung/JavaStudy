import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class JInternalFrameTest extends JFrame implements ActionListener{
	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2, if3;
	
	ImageIcon openIcon = new ImageIcon("img/open.png");
	ImageIcon saveIcon = new ImageIcon("img/save.png");
	JToolBar tb = new JToolBar();
		JButton openBtn = new JButton(openIcon);
		JButton saveBtn = new JButton(saveIcon);
		JButton foreColor = new JButton("���ڻ�");
		
	//�۲�
	JToggleButton boldBtn = new JToggleButton("A");//���ϰ�
	JToggleButton italicBtn = new JToggleButton("A");//�����
	JComboBox<String> fontCombo = new JComboBox<String>();
	JComboBox<Integer> sizeComg = new JComboBox<Integer>();
	DefaultComboBoxModel<String> fontModel = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
	
	int bold = 0;
	int italic = 0;
	
	
	public JInternalFrameTest() {
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(foreColor);
		add(BorderLayout.NORTH, tb);
		
		//////////////
		add(dp);
		if1 = new JInternalFrame();//âũ������,�ּ�ȭ,�ִ�ȭ,������ȭ ��κҰ�
		if1.setSize(300,200);
		if1.setVisible(true);
		dp.add(if1);
		
		if2 = new JInternalFrame("�޸���",true);//âũ�� ���� ����
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(100,200,500,400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("����", true, true, true, true);
		if3.add(new CalculatorEX2());
		if3.setSize(400,350);
		if3.setVisible(true);
		dp.add(if3);
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			if3.setSelected(true);//���������� Ȱ��ȭ
		}catch(Exception e) {}
		
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		foreColor.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event instanceof JButton) {
			if(event == openBtn) {
				fileOpen();
			}else if(event == saveBtn) {
				fileSave();
			}else if(event == foreColor) {
				setFontFore();
			}
		}
	}
	//���ڻ�
	public void setFontFore() {
		JColorChooser cc = new JColorChooser(Color.GREEN);
		Color selectColor = cc.showDialog(this, "���ڻ�", Color.PINK);
		
		JInternalFrame selectIf = dp.getSelectedFrame();
		JTextArea ta = (JTextArea)selectIf.getFocusOwner();
		ta.setForeground(selectColor);
	}
	
	//���Ͽ���
	public void fileOpen() {
		JFileChooser fc = new JFileChooser();
		// ���� 0 , ��� 1
		if(fc.showOpenDialog(this) == 0) {
			//������ ���� ��ü ������
			File f = fc.getSelectedFile();
			JTextArea ta = new JTextArea();
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				while(true) {
					String readData = br.readLine();
					if(readData == null) break;
					ta.append(readData+"\n");
				}
				JScrollPane sp2 = new JScrollPane(ta);
				JInternalFrame if5 = new JInternalFrame(f.getPath(), true, true, true, true);
				if5.add(sp2);
				dp.add(if5);
				if5.setSize(500,500);
				if5.setSelected(true);
				if5.setVisible(true);
				
			}catch(Exception e) {}
		}
	}
	
	//��������
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(this)==0) {
			try {
				File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f);
				//���� ���õ� Frame ������
				JInternalFrame selectIf = dp.getSelectedFrame();
				JTextArea eventTa = (JTextArea)selectIf.getFocusOwner();
				
				fw.write(eventTa.getText());
				fw.close();
			}catch(Exception e) {}
		}
	}
	
	public static void main(String[] args) {
		new JInternalFrameTest();
	}


}
