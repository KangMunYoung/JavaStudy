import java.util.Scanner;

public class DeleteTest {

	public DeleteTest() {
		//콘솔에서 사원명을 입력받아 입력받은 사원을 삭제한다.
		Scanner scan = new Scanner(System.in);
		System.out.print("delete ename=");
		String name = scan.nextLine();
		
	}

	public static void main(String[] args) {
		new DeleteTest();
	}

}
