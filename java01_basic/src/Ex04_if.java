import java.util.Scanner;
class Ex04_if
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int kor=0, eng=0, math=0, total=0;
		double avg=0.0f;
		char grade = 'F';

		System.out.println("점수 입력");
		System.out.print("국어=");
		kor = scan.nextInt();
		System.out.print("영어=");
		eng = scan.nextInt();
		System.out.print("수학=");
		math = scan.nextInt();

		total = kor + eng + math;
		avg = total / 3.0f;

		if(90 <= avg && avg <= 100){
			grade = 'A';
		}else if(80 <= avg && avg < 90){
			grade='B';
		}else if(70 <= avg && avg < 80){
			grade='C';
		}else if(60 <= avg && avg < 70){
			grade='D';
		}
		System.out.printf("총점 = %d\n", total);
		System.out.printf("평균 = %.2f\n", avg);
		System.out.printf("학점 = %c\n", grade);

	}
}
/*
	국어,영어,수학 점수를 입력받아 총점,평균,학점을 구하여 출력하라
	각과목의 점수 0~100점 사이의 값이다.
	평균은 실수를 구한다.
	
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