import java.lang.System;
import java.lang.String;
import java.util.Scanner;

class  ScannerTest
{
	public static void main(String[] args) 
	{
		//	Scanner �ֿܼ��� ���� �Ǵ� ���� �Ǽ����� �Է¹޴� Ŭ����
		//	1. ��ü�� ����
		//		���۷�������

		Scanner scan = new Scanner(System.in);
		
		//	2.	���Է¹޴� �޼ҵ带 ȣ���Ѵ�.
		//	��ü��.�޼ҵ�()
		//	nextInt() : w������ �Է�, nextDouble() : �Ǽ����Է�, next() : 1���� �ܾ ���ڿ��� �Է�
		//	nextLine() : ������ ���ڿ��� �Է�
		System.out.print("ù��° ���� -> ");
		int num = scan.nextInt() ;
		System.out.print("�ι�° ���� => ");
		int num2 = scan.nextInt() ;

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		System.out.println("sum = "+sum);
		System.out.println("minus = "+ minus);
		System.out.println("multiple = "+ multiple);
		System.out.println("devide = "+devide);

	}
}
