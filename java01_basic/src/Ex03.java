import java.util.Scanner;
class Ex03 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		for(;;){
			System.out.print("메뉴선택 1.사각형의 넓이, 2.사각형의 둘레, 3.종료 ->");
			int num1 = scan.nextInt();
			if(num1==3){
				System.exit(0);
			}
			System.out.print("가로(밑변)= ");
			int w = scan.nextInt();
			System.out.print("세로(높이)= ");
			int h = scan.nextInt();

	//		int result = (num1==1)? w * h : (w+h)*2;
	//		String text = (num1 == 1)? "사각형의 넓이:"+ result : "사각형의 둘레 = "+result; 
			String text = (num1 == 1)? "사각형의 넓이:"+ w*h : "사각형의 둘레 = "+(w+h)*2; 
			System.out.println(text);
		}
	}
}
/*
실행
메뉴선택(1. 사각형의 넓이, 2.사각형의 둘레) 1
가로(밑변)=
세로(높이)=
사각형의 넓이 = 

메뉴선택(1. 사각형의 넓이, 2.사각형의 둘레) 2
가로(밑변)=
세로(높이)=
사각형의 둘레 = 

*/