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
	Font fnt = new Font("굴림", Font.BOLD, 25);
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
	JLabel yearLbl = new JLabel("년");
	JLabel monthLbl = new JLabel("월");
	
	int year;
	int month;
	
	Calendar cal = Calendar.getInstance();

	
	public SwingCalendar2() {
		setLayout(new BorderLayout());
		//상부 버튼 & 콤보박스 삽입
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
		
		//요일 삽입
		String weekStr[]= {"일","월","화","수","목","금","토"};
		
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
		
		//날일 삽입
		basePane.add(BorderLayout.NORTH,weekStrPane);
		calendarSet();
		basePane.add(BorderLayout.CENTER,dayPane);
			
		//콤보이벤트 콤보값에 변화가 있을 경우호출
		yearCb.addItemListener(this);
		monthCb.addItemListener(this);
		//버튼이벤트
		lBtn.addActionListener(this);
		rBtn.addActionListener(this);
	}

	public void calendarSet() {
		//달력세팅
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
		//콤보박스세팅
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
		//콤보이벤트
		year = (int)yearCb.getSelectedItem();
		month = (int)monthCb.getSelectedItem();
		
		dayPane.setVisible(false); //패널을 닫는다.
		dayPane.removeAll(); //원래있는 날짜 지우기
		calendarSet(); //날짜 처리 함수 호출
		dayPane.setVisible(true); //패널을 볼수있게 처리한다.
	}
	
	public void actionPerformed(ActionEvent ae) {
		//버튼눌렀을 경우 이벤트
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
		//이벤트 등록 해제
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
