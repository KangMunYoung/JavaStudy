import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("JDBC드라이브 로딩 에러");
			cnfe.printStackTrace();
		}
	}
	Connection conn;
	PreparedStatement pstmt;
	public InsertTest(){
		//사원번호, 사원명, 급여를 입력받아 레코드 추가한다.
		//입사일은 현재 날짜로 지정한다.
		
		//데이터 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("사원번호=");
			int empno = Integer.parseInt(br.readLine());
			System.out.print("사원명=");
			String ename = br.readLine();
			System.out.print("급여=");
			int sal = Integer.parseInt(br.readLine());
			
			//DB에 저장
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott", "tiger");
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			//?값 세팅
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setInt(3, sal);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("recode, add OK");
			}else {
				System.out.println("recode, add Not OK");
			}
			
		}catch(IOException ie) {
			System.out.println("데이터입력에러발생 ---->"+ie.getMessage());
		}catch(SQLException s) {
			System.out.println("데이터베이스 연결 에러 발생 ---->"+s.getMessage());
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				System.out.println("close Error...");
			}
		}
	}

	public static void main(String[] args) {
		new InsertTest();
	}

}
