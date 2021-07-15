import java.util.Scanner;

public class DeleteTest extends DBConnection{

	public DeleteTest() {
		try {
			//콘솔에서 사원명을 입력받아 입력받은 사원을 삭제한다.
			Scanner scan = new Scanner(System.in);
			System.out.print("delete ename=");
			String name = scan.nextLine();
			
			//DB연결
			dbConn();
			
			sql = "delete from emp where ename=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"개의 레코드가 삭제되었습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest();
	}

}
