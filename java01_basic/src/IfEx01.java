import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�μ��� �Է��ϼ���");
		System.out.print("�Է�1 =");
		int num1 = scan.nextInt();
		System.out.print("�Է�2 =");
		int num2 = scan.nextInt();
		
		int add = num1+num2;
		int minus = num1-num2;
		int mul = num1*num2;
		int divide = num1/num2;

		if(0 < num1 && 0 < num2){
			/*
			System.out.println("���ϱ� " + (num1+num2));
			System.out.println("���� " + (num1-num2));
			System.out.println("���ϱ� " + (num1*num2));
			System.out.println("������ " + (num1/num2));
			
			System.out.printf("���ϱ�=%d\n����=%d\n���ϱ�=%d\n������=%d\n", add,minus,mul,divide); 
			*/
			System.out.printf("%5d + %5d = %5d\n",num1,num2,add);
			System.out.printf("%5d - %5d = %5d\n",num1,num2,minus);
			System.out.printf("%5d * %5d = %5d\n",num1,num2,mul);
			System.out.printf("%5d / %5d = %5d\n",num1,num2,divide);

		}else{
			System.out.println("�����͸� �߸��Է��Ͽ����ϴ�.");
		}
	}
}
/*
	�μ��� �Է¹޾� �Է¹��� ��� ���� ����϶��� ��Ģ������ �� ����� ����ϰ�
	�μ� ��� ����� �ƴҶ��� "�����͸� �߸��Է��Ͽ����ϴ�."��� �޼����� ����϶�/
*/