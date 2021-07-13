import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{

	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	// JTable에서 제목으로 사용할 배열
	String title[] = {"번호", "이릅", "연락처", "주소"};
	// JTable에서 목록으로 사용할 2차원 배열
	Object[][] data = {	{100, "홍길동", "010-1234-5678", "서울시 마포구"},
						{200, "이순신", "010-7878-9696", "서울시 종로구"},
						{300, "세종대왕", "010-8787-5555", "서울시 영등포구"}
						};
	JLabel lbl = new JLabel(" ");
	public JTableTest() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		add(BorderLayout.SOUTH, lbl);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {}
		
		//행추가
		Object[] row = {400, "김삿갓", "010-1234-5678", "서울시 서초구"};
		Vector<Object> v = new Vector<Object>();
		v.add(500);
		v.add("강감찬");
		v.add("010-4567-8888");
		v.add("서울시 은평구");
		
		model.addRow(row);
		model.addRow(v);
		
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		//행삽입 insertRow();
		Object[] row2 = {600, "광개토대왕", "010-1111-2222", "서울시 강남구"};
		model.insertRow(2, row2);
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		//행이동
		//			start, end, to
		model.moveRow(2, 4, 0);
		
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		/*컬럼 추가
		model.addColumn("기타");
		Object cData[] = {1,2,3,4,5,6};
		model.addColumn("메모",cData);
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		//행삭제
		model.removeRow(3);
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		//컬럼삭제
		table.removeColumn(table.getColumn("기타"));
		 */
		table.addMouseListener(new MyEvent());
		
	}

	
	//마우스이벤트 내부클래스
	public class MyEvent extends MouseAdapter{
		//재오버라이딩
		public void mouseClicked(MouseEvent me) {
			//1. 버튼의 종류( 1왼쪽 2휠 3오른쪽)
			int eventBtn = me.getButton();
			if(eventBtn == 1 ) {
				int row = table.getSelectedRow();//선택한 행번호 얻어오기
				String dataStr = "";
				//				칸의수
				for(int c=0; c<table.getColumnCount(); c++) {
					Object data = table.getValueAt(row, c);
					dataStr += data +", ";
				}
				lbl.setText(dataStr);
			}
		}
	}
	public static void main(String[] args) {

		new JTableTest();
	}

}
