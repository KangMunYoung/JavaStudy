/*
[3-4] 야래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다.
(1)에 알맞는 코드를 넣으시오
*/
class Exercise3_4 
{
	public static void main(String[] args) 
	{
		int num = 111;
		System.out.println((num/100)*100);
	}
}
