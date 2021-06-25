import java.util.Scanner;
public class ArrayEx03_money {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int yesNo=1;
		do {
			//금액입력
			System.out.print("금액을 입력하세요.?");
			int money = scan.nextInt();
			
			//지갑 배열
			int monArr[] = new int[10];
			int don = 50000;
			int div = 5;
			
			for(int i=0; i<monArr.length; i++) {
				
				monArr[i]=money/don;
				if(monArr[i] != 0) {
					System.out.print(don+"원"+monArr[i]);
					if(money >= 1000) {
						System.out.println("장");
					}else {
						System.out.println("개");
					}
				}
				
				money = money - don*monArr[i];
				don /= div;
				
				if(div==5) div = 2;
				else div = 5;
			}
			
			System.out.print("다시하시겠습니까?(1.예 2.아니요)?");
			yesNo = scan.nextInt();
			if(yesNo==2)
				break;
		}while(true);
			

	}

}
/*				if(monArr[i] != 0 && money > 1000) {
System.out.println(don+"원"+monArr[i]+"장");						
}else if(monArr[i] != 0){
System.out.println(don+"원"+monArr[i]+"개");
}
*/			

//배열 찍어보기
/*
for(int i=0; i<monArr.length; i++) {
	System.out.print(monArr[i]+", ");
}
System.out.println();
*/

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