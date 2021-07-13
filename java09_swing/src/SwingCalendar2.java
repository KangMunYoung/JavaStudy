import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar2 extends JPanel implements ItemListener, ActionListener{
	Font fnt = new Font("����", Font.BOLD, 25);
	JPanel basePane = new JPanel(new BorderLayout());
	JPanel btnPane = new JPanel(new FlowLayout());
	JPanel weekStrPane = new JPanel(new GridLayout(1,7));
	JPanel dayPane = new JPanel(new GridLayout(0,7));
		
	JComboBox<Integer> yearCb = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
	JComboBox<Integer> monthCb = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	JButton lBtn = new JButton("<<");
	JButton rBtn = new JButton(">>");
	JLabel yearLbl = new JLabel("��");
	JLabel monthLbl = new JLabel("��");
	
	int year;
	int month;
	
	Calendar cal = Calendar.getInstance();

	
	public SwingCalendar2() {
		setLayout(new BorderLayout());
		//��� ��ư & �޺��ڽ� ����
		btnPane.setBackground(Color.GRAY);
		btnPane.add(lBtn);
		btnPane.add(yearCb);
		btnPane.add(yearLbl);
		yearLbl.setFont(fnt);
		btnPane.add(monthCb);
		btnPane.add(monthLbl);
		monthLbl.setFont(fnt);
		btnPane.add(rBtn);
		comboSet();
		
		add(BorderLayout.NORTH, btnPane);
		add(BorderLayout.CENTER,basePane);
		
		//���� ����
		String weekStr[]= {"��","��","ȭ","��","��","��","��"};
		
		for(int i=0; i<weekStr.length; i++) {
			JLabel weekLbl = new JLabel(weekStr[i], JLabel.CENTER );
			weekLbl.setFont(fnt);
			if(i==0){
				weekLbl.setForeground(Color.RED);
			}else if(i==6) {
				weekLbl.setForeground(Color.BLUE);
				}
			weekStrPane.add(weekLbl);
		}
		
		//���� ����
		basePane.add(BorderLayout.NORTH,weekStrPane);
		calendarSet();
		basePane.add(BorderLayout.CENTER,dayPane);
			
		//�޺��̺�Ʈ �޺����� ��ȭ�� ���� ���ȣ��
		yearCb.addItemListener(this);
		monthCb.addItemListener(this);
		//��ư�̺�Ʈ
		lBtn.addActionListener(this);
		rBtn.addActionListener(this);
	}

	public void calendarSet() {
		//�޷¼���
		cal.set(year, month-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		for(int s=1; s<week; s++) {
			JLabel sLbl = new JLabel("	");
			dayPane.add(sLbl);
		}
		
		for(int d=1; d<=lastDay; d++) {
			JLabel dLbl = new JLabel(String.valueOf(d), JLabel.CENTER);
			dLbl.setFont(fnt);
			cal.set(Calendar.DATE, d);
			int w = cal.get(Calendar.DAY_OF_WEEK);
			if(w==1) {
				dLbl.setForeground(Color.RED);
			}else if(w==7) {
				dLbl.setForeground(Color.BLUE);
			}
			dayPane.add(dLbl);
		}
	}
	public void comboSet() {
		//�޺��ڽ�����
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
			
		for(int i=year-50;i<year+20;i++) {
			 yearModel.addElement(i);
		}
		yearCb.setModel(yearModel);
		yearCb.setFont(fnt);
		yearCb.setSelectedItem(year);
		
		for(int i=1; i<=12; i++) {
			monthModel.addElement(i);
		}
		monthCb.setModel(monthModel);
		monthCb.setFont(fnt);
		monthCb.setSelectedItem(month);
	}
	
	public void itemStateChanged(ItemEvent e) {
		//�޺��̺�Ʈ
		year = (int)yearCb.getSelectedItem();
		month = (int)monthCb.getSelectedItem();
		
		dayPane.setVisible(false); //�г��� �ݴ´�.
		dayPane.removeAll(); //�����ִ� ��¥ �����
		calendarSet(); //��¥ ó�� �Լ� ȣ��
		dayPane.setVisible(true); //�г��� �����ְ� ó���Ѵ�.
	}
	
	public void actionPerformed(ActionEvent ae) {
		//��ư������ ��� �̺�Ʈ
		Object obj = ae.getSource();
		if(obj==lBtn) {
			if(month==1) {
				year--;
				month=12;
			}else {
				month--;
			}
			resetDate();
		}
		
		if(obj==rBtn) {
			if(month==12) {
				year++;
				month=1;
			}else {
				month++;
			}
			resetDate();
		}
	}
	
	public void resetDate() {
		//�̺�Ʈ ��� ����
		yearCb.removeItemListener(this);
		monthCb.removeItemListener(this);
		yearCb.setSelectedItem(year);
		monthCb.setSelectedItem(month);
		dayPane.setVisible(false);
		dayPane.removeAll();
		calendarSet();
		dayPane.setVisible(true);
		yearCb.addItemListener(this);
		monthCb.addItemListener(this);
	}
}
