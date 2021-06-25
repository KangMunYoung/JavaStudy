import java.util.Scanner;
class ForTest03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("단입력= ");
		int num = scan.nextInt();
		System.out.println();
		
		for(int i=2; i<=9; i++){
			int x = num*i;
			System.out.printf("%d x %d = %d\n",num,i,x);
		}
	}
}

/*
	실행
	단입력=5
	5 * 2 = 10
	:
	:
	5 * 9 = 45

*/