import java.util.Scanner;
class Ex02 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� ->");
		int n1 = scan.nextInt();

		int result = (100 < n1 && n1 < 200  ) ? n1 : 0;
		System.out.println("result= " +result);


	}
}

/*
	������ ���� �Է¹޾� �Է¹��� ���� 100~200�����̸� �Է¹��� ���� ����ϰ�
								�ƴϸ� 0�� ����϶�
*/