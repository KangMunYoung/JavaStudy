import java.util.Scanner;
class Ex04_if
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int kor=0, eng=0, math=0, total=0;
		double avg=0.0f;
		char grade = 'F';

		System.out.println("���� �Է�");
		System.out.print("����=");
		kor = scan.nextInt();
		System.out.print("����=");
		eng = scan.nextInt();
		System.out.print("����=");
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
		System.out.printf("���� = %d\n", total);
		System.out.printf("��� = %.2f\n", avg);
		System.out.printf("���� = %c\n", grade);

	}
}
/*
	����,����,���� ������ �Է¹޾� ����,���,������ ���Ͽ� ����϶�
	�������� ���� 0~100�� ������ ���̴�.
	����� �Ǽ��� ���Ѵ�.
	
	����
	90~100	A
	80~89	B
	70~79	C
	60~69	D
	0~59	F

	����
	����=80
	����=80
	����=80
	=============
	����=240
	���=80.0
	����=B

*/