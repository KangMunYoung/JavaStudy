import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Memo extends JFrame implements ActionListener{
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
			JMenuItem newMenuItem = new JMenuItem("����");
			JMenuItem openMenuItem = new JMenuItem("����");
			JMenuItem saveMenuItem = new JMenuItem("����");
			JMenuItem endMenuItem = new JMenuItem("����");
		JMenu editMenu = new JMenu("����");
			JMenuItem cutMenuItem = new JMenuItem("�����α�");
			JMenuItem copyMenuItem = new JMenuItem("�����ϱ�");
			JMenuItem pasteMenuItem = new JMenuItem("�ٿ��ֱ�");
		JMenu runMenu = new JMenu("����");
			JMenuItem chromeMenuItem = new JMenuItem("ũ��");
			JMenuItem editplusMenuItem = new JMenuItem("����Ʈ�÷���");
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	public static String buffer;//�����α�, �����Ұ�� �����͸� ������ ����
	
	public Memo() {
		setJMenuBar(mb);
		mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu);
		
		fileMenu.add(newMenuItem); fileMenu.add(openMenuItem);fileMenu.add(saveMenuItem); 
		fileMenu.addSeparator();
		fileMenu.add(endMenuItem);
		
		editMenu.add(cutMenuItem);editMenu.add(copyMenuItem);editMenu.add(pasteMenuItem);
		
		runMenu.add(chromeMenuItem);runMenu.add(editplusMenuItem);
		
		
		File ff = new File("C://mypro/testFile/momoObject.txt");
		if(ff.exists()) {//������ true ������ false
			try {
			FileInputStream fis = new FileInputStream(ff);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sp = (JScrollPane)ois.readObject();
			add(sp);
			}catch(Exception e) {
				
			}
		}else {
			add(sp);
		}
		
		//����Ű ����
		setShortCut();
		
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		chromeMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == endMenuItem) {
			fileWrite();
			System.exit(0);
			
		}else if(event == newMenuItem) {
			ta.setText("");
		}else if(event==openMenuItem) {
			fileOpen();
		}else if(event==saveMenuItem) {
			fileSave();
		}else if(event==cutMenuItem) {
			stringCut();
		}else if(event==pasteMenuItem) {
			stringPaste();
		}else if(event==copyMenuItem) {
			stringCopy();
		}else if(event== chromeMenuItem) {
			processStart("C://Program Files/Google/Chrome/Application/chrome.exe https://www.naver.com");
		}else if(event == editplusMenuItem) {
			processStart("C://Users/KANG/AppData/Local/Programs/Microsoft VS Code/Code.exe");
		}
	}
	
	
	
	public void fileWrite() {
		try {
			File f = new File("C:\\mypro/testFile/memoObject.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sp);
			oos.close();
			fos.close();
		}catch(Exception e) {
		}
		
	}
	
	//�ܺ����� �����ϱ�
	public void processStart(String url) {
		Runtime runtime = Runtime.getRuntime();
		//C://Program Files/Google/Chrome/Application/chrome.exe
		try {
			runtime.exec(url);
		}catch(Exception e) {
			
		}
	}
	
	//�����ϱ�
	public void stringCopy() {
		buffer = ta.getSelectedText();
	}
	
	//�ٿ��ֱ�
	public void stringPaste() {
		ta.replaceSelection(buffer);
	}
	//�����α�
	public void stringCut() {
		//���ÿ����� ���ڸ� buffer������ �����ϰ�
		buffer = ta.getSelectedText();
		
		//���ÿ����� ���ڸ� �������Ѵ�.
		ta.replaceSelection("");
		
	}
	//���������ϱ�
	public void fileSave() {
		JFileChooser fc = new JFileChooser(new File("D:\\testFile"));
		int state = fc.showSaveDialog(this);
		//0:����, 1���
		if(state==0) {
			try {
				File ff = fc.getSelectedFile();
				FileWriter fw = new FileWriter(ff);
				fw.write(ta.getText());
				fw.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	
	
	//���Ͽ���
	public void fileOpen() {
		JFileChooser fc = new JFileChooser(new File("C:\\mypro/wkspaceJava_utf8/java01_basic/src"));
		
		//������ ������ �ѹ����ð����ϵ��� �����ϱ�
		fc.setMultiSelectionEnabled(true);
		
		//���͸�(���ϸ�)
		FileFilter filter = new FileNameExtensionFilter("�ڹ�(*.java)", "java","Java","JAVA","JaVa");
		fc.setFileFilter(filter);
		
		FileFilter filter2 = new FileNameExtensionFilter("Ŭ����", "class");
		fc.setFileFilter(filter2);
		
		//����			 �θ������̳�
		// ����:0 ���1
		int choose = fc.showOpenDialog(this);
		if(choose==0) {
			try {
				ta.setText("");//������ ǥ�õ� ������ ���� ��� �����
				
				//������ ���ϸ��� ���ϰ�� ������
				File f = fc.getSelectedFile();
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				while(true) {
					String inData = br.readLine();
					if(inData == null) break;
					ta.append(inData+"\n");
				}
				
				/*
				//������ ������ ����������
				File[] f = fc.getSelectedFiles();
				for(File ff : f) {
					FileReader fr = new FileReader(ff);
					BufferedReader br = new BufferedReader(fr);
					while(true) {
						String txt = br.readLine();
						if(txt==null)break;
						ta.append(txt+"\n");
					}
					ta.append("--------------------------------------------------------------------------------------\n");
				}*/
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//����Ű �����ϱ�
	public void setShortCut() {
		//���� : ����Ű�� ����� Ű�� E
		//1.�޴��� ����Ű�� ����� Ű�� ����
		endMenuItem.setMnemonic(KeyEvent.VK_E);
		//2. maskŰ ����										����Ű		, mask
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		//����޴�
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		
		
	}
	
	

	public static void main(String[] args) {
		new Memo();
	}

}