import java.util.Scanner;
class ForTest04 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수입력 =");
		int num = scan.nextInt();

		int sum=0;	// 합
		int sum2=0;	// 짝수
		int sum3=0;	// 홀수

		for(int i=1; i<=num; i++){
			sum += i;
			if(i%2==0){
				sum2 += i;
			}else{
				sum3 += i;
			}
		}
		System.out.printf("1~%d까지의 합은 %d\n",num,sum);
		System.out.printf("1~%d까지의 짝수의 합은 %d\n",num,sum2);
		System.out.printf("1~%d까지의 홀수의 합은 %d\n",num,sum3);
	}
}

/*
	실행
	정수입력=100
	1~100까지의 합은 5050
	1~100까지의 홀수의 합은 2500
	1~100까지의 짝수의 합은 2550
*/