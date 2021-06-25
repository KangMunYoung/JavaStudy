class Operator2 
{
	public static void main(String[] args) 
	{
		//비트 연산자 : &, |, ^(XOR), ~ -> 2진수 데이터를 이용한 연산자
		int a = 12;
		int b = 4;

		int result = a & b; //	true : 1, false : 0
		System.out.println("result = "+result);

		int result2 = a | b;
		System.out.println("result2="+result2);

		// XOR	: 두값이 다를때 참

		int result3 = a ^ b;
		System.out.println("result3="+result3);

		//	~ (부정)
		//	음수인 데이터를 환산하는 방법 : 2보수 -> 1의보수 +1
		//	1의 보수는 0은 1ㄹ로 1은 0으로 바꾸는 것이다.

		int result4 = ~a;	// -13
		System.out.println("a= " + a + ", result4=" + result4);


		// 시프트 연사자 : 비트의 이동
		// << : 비트가 왼쪽으로 이동 *기능
		// >>(부호로 채워짐), >>>(0으로 채워짐) : 비트가 오른쪽으로 이동 /기능


		int result5 = a << 2;	// 왼쪽으로 2bit 이동 오른쪽 0으로 채움 48 = 12*4
		System.out.println("result5 = " + result5);

		int result6 = a >> 2;	// 오른쪽으로 2bit 이동 왼쪽에 남는 자리는 부호로 채워진다. 3 12/4
		int result7 = result4 >> 2;	// -4
		System.out.println("result6 = " + result6 + ", result7 = " + result7);


		int result8 = result4 >>> 2;
		System.out.println("result4 = " + result4);
		System.out.println("result8=" + result8);
	}
}
