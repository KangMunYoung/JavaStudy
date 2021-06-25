import java.util.Scanner;
class SwitchEx 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어=");
		int kor = scan.nextInt();
		System.out.print("영어=");
		int eng = scan.nextInt();
		System.out.print("수학=");
		int math = scan.nextInt();

		int total = kor + eng + math;
		double avg = total / 3.0;
		char grade='F';

		switch((int)(avg/10)){//10,9,8,7,6,5,4,3,2,1
			case 10 :
			case 9 :
				grade = 'A';
				break;
			case 8 :
				grade = 'B';
				break;
			case 7 :
				grade = 'C';
				break;
			case 6 :
				grade = 'D';
				break;
		}
		System.out.printf("총점= %d\n평균= %.2f\n학점= %c\n",total, avg, grade);		
				
	}//main
}//clss
/*
	국어,영어,수학 점수를 입력받아 총점,평균,학점을 구하여 출력하라
	각과목의 점수 0~100점 사이의 값이다.
	평균은 실수를 구한다.
	
	**학점은 switch문으로 작성한다.

	학점
	90~100	A
	80~89	B
	70~79	C
	60~69	D
	0~59	F

	실행
	국어=80
	영어=80
	수학=80
	=============
	총점=240
	평균=80.0
	학점=B

*/