import java.util.Scanner;
class WhileEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�����Է�=");
		int dataInt = scan.nextInt();
		
		int i=1;
		int sum=0, evenSum=0, oddSum=0, threeSum=0;
		while (i<=dataInt)
		{
			
			//��
			sum +=i;
			//¦����
			if(i%2==0){
				evenSum += i;
			}else{
				oddSum += i;
			}

			//3�ǹ����
			if(i%3==0){
				threeSum += i;
			}
			//System.out.println(num);
			i++;
		}
		System.out.printf("1~%d������ ���� %d\n",dataInt, sum);
		System.out.printf("1~%d������ Ȧ���� ���� %d\n",dataInt, oddSum);
		System.out.printf("1~%d������ ¦���� ���� %d\n",dataInt, evenSum);
		System.out.printf("1~%d������ 3�� ����� ���� %d\n",dataInt, threeSum);
		System.out.println("TheEnd.....");

	}
}
/*
������ ��(����)�� �Է¹޾� �� ������ �հ�, ¦����, Ȧ����, 3�� ����� ���� ���Ͽ� ����϶�.
�ݵ�� �ݺ����� while���� Ȱ���϶�

����
�����Է�=15
1~15������ ���� = ___
1~15������ Ȧ���� ���� ___
1~15������ ¦���� ���� ___
1~15������ 3�� ����� ���� ___
*/