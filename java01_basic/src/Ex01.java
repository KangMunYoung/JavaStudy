import java.util.Scanner;

class Ex01 
{
	public static void main(String[] args) 
	{     
		//입력선언??
		Scanner scan = new Scanner(System.in);
		//입력
		System.out.print("num1 입력 ->");
		int num1 = scan.nextInt();
		System.out.print("num2 입력 ->");
		int num2 = scan.nextInt();
		
		//계산
		int result = (num1 > num2)? num1:num2;
		
		//출력
		System.out.println("큰값 : " + result);
		System.out.println(num1+"과 "+num2+"중에 큰것은"+result);
	}
}
/*
	두수를 입력받아 큰값을 출력하라.
*/