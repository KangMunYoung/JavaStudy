import java.util.Scanner;
public class ArrayEx03_money2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
				
		do {
			
			System.out.print("금액=");
			int money = scan.nextInt();
			
			//화폐단위
			//화폐단위와갯수를 2차원에 초기화하여 생성한다.
			
			int result[][] = {{50000,0}, {10000,0},{5000,0},{1000,0},
								{500,0},{100,0},{50,0}, {10,10},{5,0},{1,0}};
			//화폐단위 계산하기
			for(int row=0; row<result.length; row++) {//0,1,2,3,4,
				result[row][1]= money / result[row][0]; //화폐갯수
				money -= result[row][1]*result[row][0];//현재단위의 화폐금액만큼 차감
			}
			
			//출력
			for(int row=0; row<result.length; row++) {
				if(result[row][1]>0) {
					System.out.print(result[row][0]+"="+result[row][1]);
					if(result[row][0]>=1000) {
						System.out.println("장");
					}else {
						System.out.println("개");
					}
				}
			}
			
			System.out.print("계속할까요?(1.예  2.아니오)");
			if(scan.nextInt()==2) {
				break;
			}
		}while(true);

	}

}
