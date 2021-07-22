import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InetEx extends JFrame implements ActionListener, KeyListener{

	String urlText = "";
	//url�Է� �ؽ�Ʈ �ʵ�
	JTextField tf = new JTextField(30);
	//�ܼ� ��....
	JLabel lbl = new JLabel("url");
	//�ҽ����� ��ư
	JButton btn = new JButton("�ҽ�����");
	JTextArea ta = new JTextArea();

	public InetEx() {
		super("�ҽ�����");
		setLayout(new BorderLayout());
		JPanel tfpanel = new JPanel();
		
		add(BorderLayout.NORTH, tfpanel);
		tfpanel.add(BorderLayout.NORTH, lbl);
		tfpanel.add(tf);
		tfpanel.add(BorderLayout.NORTH, btn);
		
		add(BorderLayout.CENTER,ta);
		
		
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btn.addActionListener(this);
		tf.addKeyListener(this);
	}
	
	public void sourceSet() {
		try {
			URL url = new URL(urlText);
			URLConnection connection = url.openConnection();
			connection.connect();//���ä���� Ȯ���Ͽ��� ��������� ���ü� �ִ�.
			
			String type = connection.getContentType();//������� ���ϱ�
			System.out.println("content-type-->"+type);
			
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			
			System.out.println("encode-> "+encode);
			InputStream is =url.openStream();
			
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			
			while(true){
				String readData=br.readLine();
				if(readData == null)break;
				System.out.println(readData);
			}
			
		}catch(Exception e) {
			
		}
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			urlText = tf.getText();
			sourceSet();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "�ҽ�����") {
			sourceSet();
		}
	}

	public static void main(String[] args) {
		new InetEx();
	}
}
