import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		try {
			//1. JVM �� jdbc8 ����̺�ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc����̺� �ε� ����-->"+ cnfe.getMessage());
		}
		
		try {
		//2 DB����						 ����ip, localhost:port:����������qpdltm����
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
													//dbserver, ����, ���
		Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
		
		
		//3.�������� ����� "���ڿ�"
		String sq1 = "select empno, ename, job, to_char(hiredate, 'YYYY-MM-DD') hiredate, sal, comm, deptno"
				+" from emp where sal>=? or job=? order by ename";
				
		
		//4.�������� �̿��Ͽ�  PrepareStatement  ��ü����
		PreparedStatement pstmt = conn.prepareStatement(sq1);
		// ? �� ����
		pstmt.setInt(1, 3000);
		pstmt.setString(2, "���ϸ�");
		
		
		//5.�����ϱ�
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			//������ ���ڵ带 ó���Ѵ�.
			int empno = rs.getInt(1);// rs.getInt("empno");
			String ename = rs.getString(2);//rs.getString("ename");
			String job = rs.getString("job");//rs.getString(3);
			String hiredate = rs.getString(4);//rs.getString("hiredate");
//			double sal = rs.getDouble(5);
			int sal = rs.getInt(5);
			double comm = rs.getDouble(6);
			int deptno = rs.getInt(7);
		
			System.out.println(empno +", "+ename+", "+job+", "+hiredate+", "+sal+", "+comm+", "+deptno);
			
			/////////////////////////
			
		}
		//Ŭ��¡�� �������� ����� �ͺ���
		rs.close();
		pstmt.close();
		conn.close();
		
		}catch(SQLException se) {
			System.out.println("db���� ����-->"+se.getMessage());
		}
	}

	public static void main(String[] args) {

		new SelectTest();
	}

}
