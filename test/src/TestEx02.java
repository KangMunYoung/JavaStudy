import java.util.Scanner;

public class TestEx02 {

	public TestEx02() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("����1");
			int a = Integer.parseInt(scan.nextLine());
			System.out.print("����2");
			int b = Integer.parseInt(scan.nextLine());
			int c = a/b;
			System.out.println("c="+c);
			
		}catch(Exception e) {
			System.out.println("���ڰ� �ƴ� ���� ���� ����, ����2���� 0���� ���� �����ϴ�.");
			
		}
		
	}

	public static void main(String[] args) {
		new TestEx02();
	}

}
