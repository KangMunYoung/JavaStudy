import java.util.Scanner;

class Ex01 
{
	public static void main(String[] args) 
	{     
		//�Է¼���??
		Scanner scan = new Scanner(System.in);
		//�Է�
		System.out.print("num1 �Է� ->");
		int num1 = scan.nextInt();
		System.out.print("num2 �Է� ->");
		int num2 = scan.nextInt();
		
		//���
		int result = (num1 > num2)? num1:num2;
		
		//���
		System.out.println("ū�� : " + result);
		System.out.println(num1+"�� "+num2+"�߿� ū����"+result);
	}
}
/*
	�μ��� �Է¹޾� ū���� ����϶�.
*/