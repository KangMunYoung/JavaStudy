import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두수를 입력하세요");
		System.out.print("입력1 =");
		int num1 = scan.nextInt();
		System.out.print("입력2 =");
		int num2 = scan.nextInt();
		
		int add = num1+num2;
		int minus = num1-num2;
		int mul = num1*num2;
		int divide = num1/num2;

		if(0 < num1 && 0 < num2){
			/*
			System.out.println("더하기 " + (num1+num2));
			System.out.println("빼기 " + (num1-num2));
			System.out.println("곱하기 " + (num1*num2));
			System.out.println("나누기 " + (num1/num2));
			
			System.out.printf("더하기=%d\n빼기=%d\n곱하기=%d\n나누기=%d\n", add,minus,mul,divide); 
			*/
			System.out.printf("%5d + %5d = %5d\n",num1,num2,add);
			System.out.printf("%5d - %5d = %5d\n",num1,num2,minus);
			System.out.printf("%5d * %5d = %5d\n",num1,num2,mul);
			System.out.printf("%5d / %5d = %5d\n",num1,num2,divide);

		}else{
			System.out.println("데이터를 잘못입력하였습니다.");
		}
	}
}
/*
	두수를 입력받아 입력받은 모든 수가 양수일때는 사칙연산을 한 결과를 출력하고
	두수 모두 양수가 아닐때는 "데이터를 잘못입력하였습니다."라는 메세지를 출력하라/
*/