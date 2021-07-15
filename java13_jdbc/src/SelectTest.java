import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		try {
			//1. JVM 에 jdbc8 드라이브로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc드라이브 로딩 실패-->"+ cnfe.getMessage());
		}
		
		try {
		//2 DB연결						 서버ip, localhost:port:전역데이터qpdltm변수
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
													//dbserver, 계정, 비번
		Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
		
		
		//3.쿼리문을 만든다 "문자열"
		String sq1 = "select empno, ename, job, to_char(hiredate, 'YYYY-MM-DD') hiredate, sal, comm, deptno"
				+" from emp where sal>=? or job=? order by ename";
				
		
		//4.쿼리문을 이용하여  PrepareStatement  객체생성
		PreparedStatement pstmt = conn.prepareStatement(sq1);
		// ? 를 세팅
		pstmt.setInt(1, 3000);
		pstmt.setString(2, "세일맨");
		
		
		//5.실행하기
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			//한줄의 레코드를 처리한다.
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
		//클로징은 마지막에 실행된 것부터
		rs.close();
		pstmt.close();
		conn.close();
		
		}catch(SQLException se) {
			System.out.println("db연결 에러-->"+se.getMessage());
		}
	}

	public static void main(String[] args) {

		new SelectTest();
	}

}
