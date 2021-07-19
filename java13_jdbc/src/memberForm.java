import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class memberForm extends JFrame{
	JSplitPane baseSp;
	JSplitPane menuSp;
	JPanel inputPanel = new JPanel();
	JPanel tablePanel = new JPanel();

	JLabel numLbl = new JLabel("번호");
	JLabel nameLbl = new JLabel("이름");
	JLabel telLbl = new JLabel("전화번호");
	JLabel emLbl = new JLabel("이메일");
	JLabel adrrLbl = new JLabel("주소");
	JLabel hirdLbl = new JLabel("등록일");
	
	JPanel pl1 = new JPanel();
	JPanel pl2 = new JPanel();
	JPanel pl3 = new JPanel();
	JPanel pl4 = new JPanel();
	JPanel pl5 = new JPanel();
	JPanel pl6 = new JPanel();
	
	FlowLayout flL = new FlowLayout();
	BoxLayout bl;
	
	String title[] = {"번호","이름","전화번호","이메일","주소","등록일"};
	int x, y;
	public memberForm() {
		super("회원정보관리");
		inputPanel.setLayout(null);
		
		for(int i=0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i]);
			int textF = 40;
			JTextField ta1, ta2, ta3, ta4, ta5;
			x=0;
			lbl.setFont(new Font("굴림",Font.BOLD, 15));
			inputPanel.add(lbl);
			lbl.setBounds(x, y, 100, 20);
			x=100;
			
			
			if(i==0) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF,30);
			}else if(i==1) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF*3,30);
			}else if(i==2) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF*6,30);
			}else if(i==3) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF*6,30);
			}else if(i==4) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF*12,30);
			}else if(i==5) {
				ta1 = new JTextField();
				inputPanel.add(ta1);
				ta1.setBounds(x,y,textF*12,30);
			}
			
			
			
			y+=33;
		}
		
		
		
		baseSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, tablePanel);
		baseSp.setDividerSize(5);
		baseSp.setDividerLocation(200);
		
		
		add(baseSp);
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void inputText() {
		
		
		
//		pl.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
	}
	

	public static void main(String[] args) {
		new memberForm();
	}

}
