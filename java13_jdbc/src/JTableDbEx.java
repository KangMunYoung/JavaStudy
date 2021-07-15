import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableDbEx extends JFrame{
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	String title[] = {"이름", "급여", "보너스", "입사일"};
	Object[][] data;
	
	public JTableDbEx() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		add(sp);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc드라이브 로딩 실패-->"+ cnfe.getMessage());
		}
		
		try {
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			String sq1 = "select ename, sal, comm, to_char(hiredate, 'YYYY-MM-DD') hiredate"
					+" from emp";
			PreparedStatement pstmt = conn.prepareStatement(sq1);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String ename = rs.getString(1);
				int sal = rs.getInt(2);
				int comm = rs.getInt(3);
				String hiredate = rs.getString(4);
				
				Object row[] = {ename, sal, comm, hiredate};
				model.addRow(row);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(SQLException se) {
			System.out.println("db연결 에러-->"+se.getMessage());
		}
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableDbEx();
	}
}
