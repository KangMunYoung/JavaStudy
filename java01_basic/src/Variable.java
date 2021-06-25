class Variable	// 클래스는 대문자로 시작, 합성어 일때는 각 단어의 첫번재문자를 대문자로 한다.
				//	 256글자까지 가능하다.
{
	public static void main(String[] args) 
	{
		//변수란 : 값 또는 데이터를 보관하는 기능을 가진다.
		// 국어 50, 영어 80, 수학 70
		
		// 기본데이터형
		// 데이터 형:	정수(4개)	-->	byte(1byte), short(2byte), int(4byte), long(8byte) //영어문자 기준
		//			실수(2개)	--> float(4byte), double(8byte)
		//			논리(1개)	--> boolean(1byte)
		//			문자(1개)	-->	char(2byte)
		
		//			레퍼런스형

		//byte kor = 50;	//1byte 메모리 차지
		int kor2 = 50;	//4byte 메모리 차지		정수형 상수는 int형이다.
		int eng = 80;
		int math = 70;
		

		//변수 생성 규칙
		//		첫번째글자는 영문 소문자로 시작하거나, _, $로 시작할수 있다.
		//		합성어일때는 두번째 이후 단어는 대문자로 시작한다.
		//		명령어(예약어)는 변수로 사용할수 없다.
		//			name, _name, $name			-사용가능
		//			9name, *name, if(예약어)...	-사용불가
		
		//계산
		//	연산자 : +,-, *, /, %(나머지)

		int sum = kor2 + eng + math;
		//			정수, 정수 = 정수
		//			정수, 실수 = 실수
		//			실수, 정수 = 실수
		//			실수, 실수 = 실수
		double ave = sum / 3.0;	//	실수의 기본 데이터 타입은 double 31.4

		System.out.println("총점 = " + sum);
		System.out.println("평균 = " + ave);

		boolean state = true;	//	true,false	(1byte)
		char lastName = '홍';
		String firstName = "길동";

		//형변환
		float data = (float)3562.3265;
		int data2 = (int)12.1;
		System.out.println(data);		
		System.out.println(data2);
		//	큰 데이터형의 데이터를 작은 데이터형의 변수에 대입할때는 형변환을 하면 된다.
		//	작은 데이터형의 데이터를 큰 데이터형의 변수 대입할때는 형변환 하지 않아도 된다.

		double data3 = 1234567;
		System.out.println(data3);
	}
}
