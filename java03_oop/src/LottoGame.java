import java.util.Scanner;
import java.util.Arrays;

public class LottoGame {
	int lottoData[] = new int[7];

	
	public LottoGame() {
		start();
	}
	
	public void start() {
		int check;
		do {
			System.out.print("게임수->");
			int game = inputNum();
			
			for(int i=1; i<=game; i++) {
				lotto();
				gamePrint(i);
			}
			
			System.out.print("계속하시겠습니까? [1.예 2.아니오]");
			check = inputNum();
		}while(check != 2);
	}
	
	public int inputNum() { // 번호입력
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public void lotto() {	//번호생성&중복제거
		for(int i=0; i<lottoData.length; i++) {
			lottoData[i]=(int)(Math.random()*45)+1;
			for(int c=0; c<i; c++) {
				if(lottoData[i]==lottoData[c]) {
					i--;
				}
			}
		}
	}
	
	public void gamePrint(int i) {	// 정렬 & 보너스 구분
		int lottoArr[] = Arrays.copyOfRange(lottoData, 0, 6);
		Arrays.sort(lottoArr);
		System.out.println(i+"게임="+Arrays.toString(lottoArr)+" 보너스="+lottoData[6]);
	}
	
	public static void main(String[] args) {
		new LottoGame();
	}
}
