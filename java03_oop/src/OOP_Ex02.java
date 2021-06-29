import java.util.Scanner;

public class OOP_Ex02 {
	int dan;//입력받은 단을 저장할 변수=0
	String gugu="";// 구구단을 저장할 변수
	public OOP_Ex02() {
	}
	//단입력받기
	int danInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("단입력=");
		return scan.nextInt();
	}
	
	//구구단출력하기
	void gugudan() {
		for(int i=2; i<=9; i++) {
			gugu += dan + "*" + i + "=" + dan*i + "\n";
		}
	}
	
	
	void start() {
		dan = danInput();
		gugudan();
		System.out.println(gugu);
	}
	public static void main(String[] args) {
		OOP_Ex02 oop = new OOP_Ex02();//new 하면 생성자 메소드가 실행된다.
		oop.start();
//		System.out.print(oop.gugudan(oop.danInput()));
		
	}

}
//콘솔에서 단을 입력받아 입력받은 구구단을 출력하라.
//