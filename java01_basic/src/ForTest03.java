import java.util.Scanner;
class ForTest03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("���Է�= ");
		int num = scan.nextInt();
		System.out.println();
		
		for(int i=2; i<=9; i++){
			int x = num*i;
			System.out.printf("%d x %d = %d\n",num,i,x);
		}
	}
}

/*
	����
	���Է�=5
	5 * 2 = 10
	:
	:
	5 * 9 = 45

*/