import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;



public class JlistTest extends JFrame implements ActionListener
{
	JPanel pane = new JPanel(new GridLayout(2,1));
	JButton leftbtn = new JButton("<--");
	JButton rightbtn = new JButton("-->");
	
	DefaultListModel<String> leftModel = new DefaultListModel<String>();
	JList<String> leftlist = new JList<String>(leftModel);
	JScrollPane sp1 = new JScrollPane(leftlist);
	
	DefaultListModel<String> rightModel = new DefaultListModel<String>();
	JList<String> rightList = new JList<String>(rightModel);
	JScrollPane sp2 = new JScrollPane(rightList);
	
	String data[] = { "���","����","����","���ξ���","�ٳ���","ü��","Ű��","������","�丶��","����"};
	String data2 = "���/����/ƫ��/�ڽ���/�ǵ���";
	
	public JlistTest() {
		for(int i=0; i<data.length; i++) {
			leftModel.addElement(data[i]);
		}
		
		StringTokenizer st = new StringTokenizer(data2, "/");
		
		while(st.hasMoreTokens()) {
			rightModel.addElement(st.nextToken());
		}
		
		pane.add(leftbtn); pane.add(rightbtn);
		add(pane);
		
		add(BorderLayout.WEST, sp1);
		add(BorderLayout.EAST, sp2);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		leftbtn.addActionListener(this);
		rightbtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == leftbtn) {
			listDataChanged(rightList, leftlist);	// RightList --> LeftList 
		}else if(event == rightbtn) {
			listDataChanged(leftlist, rightList);	// LeftList --> RightList
		}
	}

	//							��������			�ű��
	public void listDataChanged(JList orgList, JList tarList) {
		DefaultListModel<String> orgModel = (DefaultListModel)orgList.getModel();
		DefaultListModel<String> tarModel = (DefaultListModel)tarList.getModel();
		
		List<String> list = orgList.getSelectedValuesList();
		for(int i=0; i<list.size(); i++) {
			tarModel.addElement(list.get(i)); // �߰�
			orgModel.removeElement(list.get(i)); // ����
		}
	}
	public static void main(String[] args) {
		new JlistTest();
	}
}
