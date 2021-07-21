import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

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
//			JLabel searchLbl = new JLabel(" 이름 ");
			DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
			JComboBox<String> searchKey = new JComboBox<String>(searchModel);
			JTextField searchWord = new JTextField(15);
			JButton searchBtn = new JButton("Search");
		
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
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.allRecord();
		setMemberModel(list);
	}
	public void setMemberModel(List<MemberVO> list) {
		//기존 JTable의 목록을 지우고 새로 리스트를 출력한다
		model.setRowCount(0);
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
//		southPane.add(searchLbl);
		
		searchModel.addElement("이름");
		searchModel.addElement("전화번호");
		searchModel.addElement("주소");
		southPane.add(searchKey);//콤보박스
		
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
		}else if(eventBtn.equals("사원삭제")) {
			memberDelete();
		}else if(eventBtn.equals("Search")) {
			memberSearch();
		}else if(eventBtn.equals("전체목록")) {
			memberAllList();
		}else if(eventBtn.equals("엑셀쓰기")) {
			//jtable 의 레코드를 엑셀로 쓰기
			excelWrite();
		}else if(eventBtn.equals("엑셀읽기")) {
			excelRead();
		}
	}
	//엑셀로 읽기
	public void excelRead() {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state==0) {
			try {
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f);
				POIFSFileSystem poi = new POIFSFileSystem(fis);
				HSSFWorkbook workbook = new HSSFWorkbook(poi);
				HSSFSheet sheet = workbook.getSheet("회원목록");
				
				//기존jtable 데이터 지우기
				model.setRowCount(0);
				
				//시트의 행의수
				int rows = sheet.getPhysicalNumberOfRows();
				for(int r=1; r<rows; r++) {
					//행얻어오기
					HSSFRow row= sheet.getRow(r);
					int cols = row.getPhysicalNumberOfCells();//열수
					Vector v = new Vector();
					for(int c=0; c<cols; c++) {
						if(c==0) {
							v.add((int)row.getCell(c).getNumericCellValue());
						}else {
							v.add(row.getCell(c).getStringCellValue());
						}
					}
					model.addRow(v);
				}
				poi.close();
				fis.close();
				
						
			}catch(Exception e) {
				System.out.println("엑셀열기 오류");
				e.printStackTrace();
			}
		}
		
		
//		try {
//			File file = new File("c://mypro/testFile", "memberList.xls");
//			FileInputStream fis = new FileInputStream(file);
//			POIFSFileSystem poi = new POIFSFileSystem(fis);
//			HSSFWorkbook workbook = new HSSFWorkbook(poi);
//			int sheetCnt = workbook.getNumberOfSheets();
//			System.out.println("시트수="+sheetCnt);
//			HSSFSheet sheet = workbook.getSheet("회원목록");
//			int rowCount = sheet.getPhysicalNumberOfRows();
//			System.out.println("행의수="+rowCount);
//			String excelTitle[] = title.split("/");
//			
//			for(int i=0; i<excelTitle.length; i++) {
//				System.out.print(excelTitle[i]+"\t");
//			}
//			System.out.println();
//			
//			for(int rowIdx=1; rowIdx<rowCount; rowIdx++) {
//				HSSFRow row = sheet.getRow(rowIdx);
//				int cellCount = row.getPhysicalNumberOfCells();
//				for(int cellIdx=0; cellIdx<cellCount; cellIdx++) {
//					HSSFCell cell = row.getCell(cellIdx);
//					if(cellIdx==0) {
//						int data = (int)cell.getNumericCellValue();
//						System.out.println(data+"\t");
//					}else if(cellIdx==5) {
//						Date data = cell.getDateCellValue();
//						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//						String dateStr = format.format(data);
//						System.out.println(dateStr);
//					}
//					String data = cell.getStringCellValue();
//					System.out.println(data+"\t");
//				}
//			}
//		}catch(Exception e) {
//			System.out.println("엑셀읽기 오류");
//			e.printStackTrace();
//		}
		
	}
	//엑셀로 쓰기
	public void excelWrite(){
		JFileChooser fc = new JFileChooser();
		
		int state = fc.showSaveDialog(this);
		if(state==0) {
			File f = fc.getSelectedFile();
			
			//엑셀
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("회원목록");
			//제목
			HSSFRow rowTitle = sheet.createRow(0);
			String[] excelTitle = title.split("/");
			for(int i=0; i<excelTitle.length; i++) {
				rowTitle.createCell(i).setCellValue(excelTitle[i]);
			}
			//jtable목록의 행의수
			int rows = memberList.getRowCount();	//5
			int cols = memberList.getColumnCount();	//6
			for(int i=0; i<rows; i++) {//0,1,2,3,4
				HSSFRow row = sheet.createRow(i+1);
				//jtable목록의 열의수
				for(int j=0; j<cols; j++) {	//0,1,2,3,4,5
					if(j==0) {
					row.createCell(j).setCellValue((int)memberList.getValueAt(i, j));
					}else {
						row.createCell(j).setCellValue((String)memberList.getValueAt(i, j));
					}
				}
			}
			
			//엑셀을 파일로쓰기
			try {
				FileOutputStream fos = new FileOutputStream(f);
				workbook.write(fos);
				fos.close();
				workbook.close();
			}catch(Exception e) {
				System.out.println("엑셀파일쓰기 오류");
				e.printStackTrace();
			}
		}
	}
	
	//레코드 검색
	public void memberSearch() {
		//검색어가 입력되어 있는지
		String search = searchWord.getText();
		if(search!=null || search.equals("")) {
			String searchField = (String)searchKey.getSelectedItem();//검색키 "이름", "전화번호", "주소"
			String fieldName ="";
			if(searchField.equals("이름")) {
				fieldName = "username";
			}else if(searchField.equals("전화번호")) {
				fieldName = "tel";
			}else if(searchField.equals("주소")) {
				fieldName = "addr";
			}
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.searchRecord(search, fieldName);
			setMemberModel(list);
			searchWord.setText("");
			
		}
	}
	//사원삭제
	public void memberDelete() {
		//삭제할 사원번호
		String delNum = formTf[0].getText();
		if(delNum == null || delNum.equals("")) {
			JOptionPane.showMessageDialog(this, "삭제할 사원을 선택후 삭제버튼을 클릭하세요");
		}else {
			MemberDAO dao = new MemberDAO();
			int result = dao.deleteRecord(Integer.parseInt(delNum));
			if(result > 0) {///회원 삭제
				JOptionPane.showMessageDialog(this, delNum+"사원 삭제 완료.");
				memberAllList();
				formDataClear();
			}else {//회원 삭제 실패
				JOptionPane.showMessageDialog(this, delNum+"사원 삭제 실패.");
			}
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
	
	//사원 추가
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
			if(cnt>0) {//사원추가
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
