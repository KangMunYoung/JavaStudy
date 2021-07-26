import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ChatClient extends JFrame implements ActionListener, Runnable{
	//Frame Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel connectionPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField("192.168.0.17");
			JButton connBtn = new JButton("접속");
		
		JTextArea msgTa = new JTextArea();
		JScrollPane sp = new JScrollPane(msgTa);
		
		JPanel msgPane = new JPanel(new BorderLayout());
			JTextField msgTf = new JTextField();
			JButton sendBtn = new JButton("보내기");
			
	//Frame East
	JPanel eastPane = new JPanel(new BorderLayout());
		JLabel title = new JLabel("        접속자 리스트         ");
		DefaultListModel<String> connModel = new DefaultListModel<String>();
		JList<String> connList = new JList<String>(connModel);
		JScrollPane connSp = new JScrollPane(connList);
		JLabel count = new JLabel("현재 : 0명");
	///////////////////////////
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		
	public ChatClient() {
		add(centerPane);
		
		//connect
		centerPane.add("North",connectionPane);
		connectionPane.add(connTf);
		connectionPane.add("East",connBtn);
		
		//message
		centerPane.add(sp);
		msgTa.setBackground(new Color(176,209,209));
		
		//message send
		centerPane.add("South", msgPane);
		msgPane.add(msgTf);
		msgPane.add("East", sendBtn);
		
		//chat information
		add("East", eastPane);
		eastPane.add("North",title);
		connModel.addElement("");
		eastPane.add(connSp);
		eastPane.add("South", count);
		
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//이벤트등록
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		msgTf.addActionListener(this);
		sendBtn.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object eventObj = ae.getSource();
		if(eventObj == connTf || eventObj == connBtn) {
			setServerConnection();
		}else if(eventObj == msgTf || eventObj == sendBtn) {
			sendMessage();
		}
	}
	
	//서버로 클라이언트가 문자 보내기
	public void sendMessage() {
		String sendMsg = msgTf.getText();
		
		if(!sendMsg.equals("")) {//텍스트 필드에 쓴내용 없으면 실행 안함
			System.out.println(sendMsg);
			pw.println(sendMsg);
			pw.flush();
		}
		msgTf.setText("");
	}
	
	
	public void setServerConnection() {
		try {
			//서버에접속
			InetAddress ia = InetAddress.getByName("192.168.0.17");
			s = new Socket(ia ,13000);
			//IO생성
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			
			connTf.setEnabled(false);
			connBtn.setEnabled(false);
			
			Thread t = new Thread(this);
			t.start();
			
		}catch(Exception e) {
			System.out.println("서버접속에러 발생"+e.getMessage());
		}
	}
	
	//서버에서 온 문자를 받는 스레드
	
	@Override
	public synchronized void run() {
		while(true) {
			try {
				
				String receiveData= br.readLine();
				if(receiveData != null && !receiveData.equals("")) {
					//message
					if(receiveData.substring(0, 4).equals("*MG$")) {
						msgTa.append(receiveData.substring(4)+"\n");
					}else if(receiveData.substring(0,4).equals("$CN#")) {
						count.setText("현재 :"+ receiveData.substring(4)+"명");
					}else if(receiveData.substring(0,4).equals("@LI*")) {//접속자 목록 
						StringTokenizer st = new StringTokenizer(receiveData.substring(4),"/");

						connModel.removeAllElements();//모델에있는 모든 목록 삭제
						
						while(st.hasMoreTokens()) {
							connModel.addElement(st.nextToken());
						}
					}
				}
			}catch(Exception e) {
				
			}
		}
	}
	public static void main(String[] args) {
		new ChatClient();
	}

}
