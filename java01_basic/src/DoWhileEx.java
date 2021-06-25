import java.util.Scanner;
class DoWhileEx 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int yesNo=1;
			
		do
		{
			int m5=0, m1=0, c5=0, c1=0, b5=0, b1=0, w5=0, w1=0, w=0 ;
			
			System.out.print("금액을 입력하세요.?");
			int don = scan.nextInt();			
				
			while(don/50000 > 0){
				don=don-50000;
				m5++;			
			}
			while(don/10000>0){
				don=don-10000;
				m1++;
			}
			while(don/5000>0){
				don=don-5000;
				c5++;
			}
			while(don/1000>0){
				don=don-1000;
				c1++;
			}
			while(don/500>0){
				don=don-500;
				b5++;
			}
			while(don/100>0){
				don=don-100;
				b1++;
			}
			while(don/50>0){
				don=don-50;
				w5++;
			}
			while(don/10>0){
				don=don-10;
				w1++;
			}
			while(don/5>0){
				don=don-5;
				w++;
			}
				
			if(m5 != 0){
				System.out.printf("50000원=%d장\n", m5);
			}
			if(m1 != 0){
				System.out.printf("10000원=%d장\n", m1);
			}
			if(c5 != 0){
				System.out.printf("5000원=%d장\n", c5);
			}
			if(c1 != 0){
				System.out.printf("1000원=%d장\n", c1);
			}
			if(b5 != 0){
				System.out.printf("500원=%d개\n", b5);
			}
			if(b1 != 0){
				System.out.printf("100원=%d개\n", b1);
			}
			if(w5 != 0){
				System.out.printf("50원=%d개\n", w5);
			}
			if(w1 != 0){
				System.out.printf("10원=%d개\n", w1);
			}
			if(w != 0){
				System.out.printf("5원=%d개\n", w);
			}
			if(don != 0){
				System.out.printf("1원=%d개\n", don);
			}

			System.out.print("다시하시겠습니까?(1.예 2.아니요)?");
			yesNo = scan.nextInt();
		}
		while (yesNo==1);



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