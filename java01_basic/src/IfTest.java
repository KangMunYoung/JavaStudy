import java.util.Scanner;

class IfTest 
{
	public static void main(String[] args) 
	{
		//����� �Է¹޾� ¦���϶��� ����ϰ� ¦���� �ƴϸ� ������� �ʴ´�.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("0���� ū ������ �Է��ϼ���...");
		int num = scan.nextInt();

		//if(num % 2==0){
		//if(num/2 == num/2.0){
		if(num % 3 != 0){
			//System.out.printf("�Է��� ���� %d���� ¦�� �Դϴ�.\n", num);
			System.out.printf("%d�� 3�� ���.\n", num);
		}
		
		System.out.println("End.....");
	}
}
/*
	if��
	���ǹ��� �ݵ�� ��� ������� �Ѵ�.

	if(���ǹ� or ���� or ���� or ���) {
		���϶� ������ ���๮;
		���๮
		���๮;
	}
*/