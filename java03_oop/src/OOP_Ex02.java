import java.util.Scanner;

public class OOP_Ex02 {
	int dan;//�Է¹��� ���� ������ ����=0
	String gugu="";// �������� ������ ����
	public OOP_Ex02() {
	}
	//���Է¹ޱ�
	int danInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���Է�=");
		return scan.nextInt();
	}
	
	//����������ϱ�
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
		OOP_Ex02 oop = new OOP_Ex02();//new �ϸ� ������ �޼ҵ尡 ����ȴ�.
		oop.start();
//		System.out.print(oop.gugudan(oop.danInput()));
		
	}

}
//�ֿܼ��� ���� �Է¹޾� �Է¹��� �������� ����϶�.
//