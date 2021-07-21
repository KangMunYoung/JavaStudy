import java.util.Scanner;

public class TestEx02 {

	public TestEx02() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("숫자1");
			int a = Integer.parseInt(scan.nextLine());
			System.out.print("숫자2");
			int b = Integer.parseInt(scan.nextLine());
			int c = a/b;
			System.out.println("c="+c);
			
		}catch(Exception e) {
			System.out.println("숫자가 아닌 값이 들어갈수 없고, 숫자2에는 0값이 들어갈수 없습니다.");
			
		}
		
	}

	public static void main(String[] args) {
		new TestEx02();
	}

}
