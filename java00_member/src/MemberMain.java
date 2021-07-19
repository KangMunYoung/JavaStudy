import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame north
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6, 1,5,5));
			String formLbl[] = {"  번 호 ","  이 름 "," 연락처 "," 이메일 ","  주 소 "," 등록일 "};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			JTextField[] formTf = {new JTextField(5), new JTextField(15), new JTextField(20), 
									new JTextField(30), new JTextField(40), new JTextField(20)}; 
	
	//JFrame -center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			JButton[] btn = {new JButton("전체목록"),new JButton("사원추가"),new JButton("사원수정"),
							new JButton("사원삭제"),new JButton("폼지우기"),new JButton("종료"),
							new JButton("엑셀쓰기"),new JButton("엑셀읽기")};
		DefaultTableModel model;
		String title = "번호/이름/연락처/이메일/주소/등록일";
		JTable memberList;
		JScrollPane sp;
		
		//JFrame-south
		JPanel southPane = new JPanel();
			JLabel searchLbl = new JLabel(" 이름 ");
			JTextField searchWord = new JTextField(15);
			JButton searchBtn = new JButton("search");
		
	public MemberMain() {
		super("회원관리시스템");

		//frame - north
		setForm();
		//frame - Center
		setButtonTable();
		//frame south
		setSearchForm();
		
		setSize(800, 650);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		memberAllList();
	}
	
	//데이터 베이스에서 회원전체 목록 가져오기(이름순) - JTable 목록을 보여준다.
	public void memberAllList() {
		//기존 JTable의 목록을 지우고 새로 리스트를 출력한다
		model.setRowCount(0);
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.allRecord();
		
		//컬렉션의 vo를 get 하여  jtable에 목록으로 추가한다.
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			Object[] obj = {vo.getMem_no(), vo.getUsername(), vo.getTel(),
							vo.getEmail(), vo.getAddr(), vo.getWrite_date()};
			model.addRow(obj);
		}
			
	}
		
	
	
	//frame - north
	public void setForm() {
		add(BorderLayout.NORTH, formPane);
			formPane.add(BorderLayout.WEST, formWestPane);
				for(int i=0; i<formLbl.length; i++) {
					JLabel lbl = new JLabel(formLbl[i]);
					formWestPane.add(lbl);
				}
			formPane.add(BorderLayout.CENTER, formCenter);
				for(int i=0; i<formTf.length; i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
					p.add(formTf[i]);
					formCenter.add(p);
					if(i==0 || i==5) formTf[i].setEditable(false);
				}
	}
	
	//frame - Center
	public void setButtonTable() {
		add(centerPane);
			centerPane.add(BorderLayout.NORTH, btnList);
			for(int i=0; i<btn.length; i++) {
				btnList.add(btn[i]);
				//이벤트등록
				btn[i].addActionListener(this);
			}
		//JTable						제목
		model = new DefaultTableModel(title.split("/"),0);
		memberList = new JTable(model);
		sp = new JScrollPane(memberList);
		centerPane.add(sp);
		
		memberList.addMouseListener(new JTableMouseEventProcess(formTf, memberList));
			
	}
	
	//frame south
	public void setSearchForm() {
		add(BorderLayout.SOUTH, southPane);
		southPane.add(searchLbl);
		southPane.add(searchWord);
		southPane.add(searchBtn);
		
		searchBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("사원추가")){
			memberInsert();
		}else if(eventBtn.equals("폼지우기")) {
			formDataClear();
		}else if(eventBtn.equals("종료")) {
			System.exit(0);
		}else if(eventBtn.equals("사원수정")) {
			memberUpdate();
		}
	}
	//사원수정
	public void memberUpdate() {
		MemberVO vo = new MemberVO();
		vo.setMem_no(Integer.parseInt(formTf[0].getText()));
		vo.setTel(formTf[2].getText());
		vo.setEmail(formTf[3].getText());
		vo.setAddr(formTf[4].getText());
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateRecord(vo);
		if(cnt>0) {//수정시 리스트 다시 선택하기
			memberAllList();
		}else {//수정실패시 안내메세지 표시
			JOptionPane.showMessageDialog(this, "회원정보를 수정실패하였습니다.");
		}
	}
	public void memberInsert() {
		//폼의 이름이 입력된 상태인지 확인
		String username = formTf[1].getText();
		if(username==null || username.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		}else {
			MemberVO vo = new MemberVO();
			vo.setUsername(username);
			vo.setTel(formTf[2].getText());
			vo.setEmail(formTf[3].getText());
			vo.setAddr(formTf[4].getText());
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {//회원추가
				formDataClear();//회읭이 추가 되면 폼의 데이터를 지운다.
				memberAllList();
			}else {//회원추가실패
				JOptionPane.showMessageDialog(this, "회원추가실패");
			}
		}
	}
	public void formDataClear() {
		//폼의 값을 지운다
		for(int i=0; i<formTf.length; i++) {
			formTf[i].setText("");
		}
	}
	//마우스 이벤트처리 내부 클래스
	
	public static void main(String[] args) {
		new MemberMain();
	}


}
