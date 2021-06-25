import java.lang.System;
import java.lang.String;
import java.util.Scanner;

class  ScannerTest
{
	public static void main(String[] args) 
	{
		//	Scanner 콘솔에서 정수 또는 문자 실수등을 입력받는 클래스
		//	1. 객체를 생성
		//		레퍼런스변수

		Scanner scan = new Scanner(System.in);
		
		//	2.	값입력받는 메소드를 호출한다.
		//	객체명.메소드()
		//	nextInt() : w정수가 입력, nextDouble() : 실수가입력, next() : 1개의 단어가 문자열로 입력
		//	nextLine() : 한줄이 문자열로 입력
		System.out.print("첫번째 정수 -> ");
		int num = scan.nextInt() ;
		System.out.print("두번째 정수 => ");
		int num2 = scan.nextInt() ;

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		System.out.println("sum = "+sum);
		System.out.println("minus = "+ minus);
		System.out.println("multiple = "+ multiple);
		System.out.println("devide = "+devide);

	}
}
