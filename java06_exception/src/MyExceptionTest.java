import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
	}
	public void start() {
		do {
			//임의의 정수(1~100)사이 값 입력 -> 그 수까지 합 구하여 출력
			try {
				System.out.print("정수입력(1~100)");
				int max = Integer.parseInt(scan.nextLine());//NumberFormatException
				//1~100
				if(max<1||max>100) {
					//throw : 예외를 강제로 발생시킨다.
					throw new MyException();
				}else {
					sum(max);
				}
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를입력하세요..");
			}catch(MyException me) {
				System.out.println(me.getMessage());
			}
		}while(true);
	}
	public void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"까지의 합은"+tot);
	}
	public static void main(String[] args) {
		new MyExceptionTest().start();
		
	}

}