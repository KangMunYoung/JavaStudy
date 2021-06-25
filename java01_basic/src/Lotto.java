//package java01_basic;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int end=0;
				
		do {
			//게임수 입력
			System.out.print("게임수 = ");
			int gameNum = scan.nextInt();
			
			for(int gi=1; gi<=gameNum; gi++) {
				//난수보관 배열
				int num[] = new int[7];
				
				//난수 생성
				for(int i=0; i<num.length; i++) {
					int random = (int)(Math.random()*46)+1;
					num[i]= random;
					
					
					if(num[i] != num[0] && num[i-1] == num[i]) {
						num[i] = random;
					}
					
				}
				
				
				System.out.printf("%d 게임= ",gi+1);
				for(int j=0; j<num.length-1; j++) {
					System.out.print(num[j]+", ");
				}
				System.out.print("보너스 "+num[gameNum]);
				System.out.println();
				end++;
			}
			
			if(end == gameNum) {
				System.out.print("게임을 계속 하시겠습니까?(1.예 2.아니요)");
				int yesNo = scan.nextInt();
				if(yesNo == 2) {
					break;
				}	
			}
				
		}while(true);
		
		
	}
		

}


/*
 * 
public class ArrayBublleSort {

	public static void main(String[] args) {
		
		int num[] = new int[10];
		
		//난수 생성
		for(int i=0; i<num.length; i++) {
			int random = (int)(Math.random()*100)+1;
			num[i]=random;
		}
		System.out.println();
		
		System.out.println("========================");
		
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+", ");
		}
		System.out.println();
		
		for(int j=0; j<num.length-1; j++) {
			for(int i=0; i<num.length-1; i++) {
				if(num[i]>num[i+1]) {
					// 교환하기
					int temp = num[i];
					num[i] = num[i+1];
					num[i+1] = temp;
				}
			}
		}
		
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+", ");
		}
		System.out.println();
	}

}

 */
/*
로또 번호 : 1~45까지 번호 6개
			보너스1개

실행
게임수 = 3
1게임 = 5, 13, 2, 32, 33, 45, 보너스 11
2게임 = 11, 23,26,32,35,41, 보너스 9
3게임 = 15,13,26,37,38,42, 보너스 23
계속하시겠습니까(1:예, 2:아니오)?1

게임수 = 5
1게임 = 5, 13, 2, 32, 33, 45, 보너스 11
2게임 = 11, 23,26,32,35,41, 보너스 9
3게임 = 15,13,26,37,38,42, 보너스 23
4게임 = 15,13,26,37,38,42, 보너스 23
5게임 = 15,13,26,37,38,42, 보너스 23
계속하시겠습니까(1:예, 2:아니오)?2


*/