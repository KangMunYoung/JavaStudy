import java.util.Scanner;

public class OOP_Ex01 {

	public OOP_Ex01() {
//		int dan = danInput();
//		String result = gugudan(dan);
//		System.out.print(result);
		
//		System.out.print(gugudan(danInput()));
	}
	
	//���Է¹ޱ�
	int danInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���Է�=");
		return scan.nextInt();
	}
	
	//����������ϱ�
	String gugudan(int dan) {
		String gugu="";
		for(int i=2; i<=9; i++) {
			gugu += dan + "*" + i + "=" + dan*i + "\n";
		}
		return gugu;
	}
	
	
	void start() {
		int dan = danInput();
		String result = gugudan(dan);
		System.out.println(result);
	}
	public static void main(String[] args) {
		OOP_Ex01 oop = new OOP_Ex01();//new �ϸ� ������ �޼ҵ尡 ����ȴ�.
		oop.start();
//		System.out.print(oop.gugudan(oop.danInput()));
		
	}

}
//�ֿܼ��� ���� �Է¹޾� �Է¹��� �������� ����϶�.
//