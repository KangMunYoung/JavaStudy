import java.util.Scanner;
class DoWhileEx111 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int yesNo=1;
			
		do
		{
			int m5=0, m1=0, c5=0, c1=0, b5=0, b1=0, w5=0, w1=0, w=0 ;
			//금액
			System.out.print("금액을 입력하세요.?");
			int money = scan.nextInt();			
			
			//화페
			int cnt = money/50000;
			if(cnt>0){
				System.out.println("50000원="+cnt+"장");
				money= money - cnt*50000;
			}
			cnt = money/10000;
			if(cnt>0){
				System.out.println("10000원="+cnt+"장");
				money= money - cnt*10000;
			}
			cnt = money/5000;
			if(cnt>0){
				System.out.println("5000원="+cnt+"장");
				money= money - cnt*5000;
			}

			


			System.out.print("다시하시겠습니까?(1.예 2.아니요)?");
			yesNo = scan.nextInt();
			if(yesNo==2)
				break;
		}
		while (true);



	}

}

/*

50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1
실행
금액을 입력하세요.? 123300
50000원=2장
10000원=2장
1000원=3장
100원=3개
다시하시겠습니까(1.예 2.아니요)?

금액을 입력하세요.? 5435
5000월=1장
100원=4개
10원=3개
1원=5개
다시하시겠습니까(1.예 2.아니요)?2

*/