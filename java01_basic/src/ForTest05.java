import java.util.Scanner;
class ForTest05 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		for(int i= 1; i<=100; i++){
			if(i%3 != 0 && i%5 != 0){
				System.out.printf("%d\t",i);
			}
		}
	}
}

/*
3의배수, 5의배수가 아닌 숫자를 출력
1~100까지 값중 다음데이터를 출력하라

1
2	1
4	2 
7	3 
8	1
11	3
13	2
14	1
16	2
17	1
19	2
22	3

:
98

*/