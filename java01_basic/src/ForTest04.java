import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�����Է� =");
		int num = scan.nextInt();

		int sum=0;	// ��
		int sum2=0;	// ¦��
		int sum3=0;	// Ȧ��

		for(int i=1; i<=num; i++){
			sum += i;
			if(i%2==0){
				sum2 += i;
			}else{
				sum3 += i;
			}
		}
		System.out.printf("1~%d������ ���� %d\n",num,sum);
		System.out.printf("1~%d������ ¦���� ���� %d\n",num,sum2);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n",num,sum3);
	}
}

/*
	����
	�����Է�=100
	1~100������ ���� 5050
	1~100������ Ȧ���� ���� 2500
	1~100������ ¦���� ���� 2550
*/