import java.util.Scanner;
class Ex03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		for(;;){
			System.out.print("�޴����� 1.�簢���� ����, 2.�簢���� �ѷ�, 3.���� ->");
			int num1 = scan.nextInt();
			if(num1==3){
				System.exit(0);
			}
			System.out.print("����(�غ�)= ");
			int w = scan.nextInt();
			System.out.print("����(����)= ");
			int h = scan.nextInt();

	//		int result = (num1==1)? w * h : (w+h)*2;
	//		String text = (num1 == 1)? "�簢���� ����:"+ result : "�簢���� �ѷ� = "+result; 
			String text = (num1 == 1)? "�簢���� ����:"+ w*h : "�簢���� �ѷ� = "+(w+h)*2; 
			System.out.println(text);
		}
	}
}
/*
����
�޴�����(1. �簢���� ����, 2.�簢���� �ѷ�) 1
����(�غ�)=
����(����)=
�簢���� ���� = 

�޴�����(1. �簢���� ����, 2.�簢���� �ѷ�) 2
����(�غ�)=
����(����)=
�簢���� �ѷ� = 

*/