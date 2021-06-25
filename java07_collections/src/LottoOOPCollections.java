
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

//컬렉션 클래스 활용하여 만들기
public class LottoOOPCollections {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public LottoOOPCollections() {}
	public void lottoStart() {
		do {
			System.out.print("게임수=");
			int game = Integer.parseInt(scan.nextLine());
			
			for(int i=1; i<=game; i++) {
				lottoCreate(i);
			}
			//계속여부
			if(!yesNo()) {
				break;
			}
		}while(true);
	}
	
	//1게임만들기
	public void lottoCreate(int i) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		int num=0;
		while(lotto.size()<7) {
			num = random.nextInt(45)+1;
			lotto.add(num); 
		}
		// lotto TreeSet 번호7개가 있고, num에는 마지막으로 만든 번호가 있다.
		// bonus번호는 로또번호에서 지운다.
		lotto.remove(num);
		lottoPrint(i, lotto.toString(), num);
	}
	//출력
	public void lottoPrint(int cnt, String lotto, int bonus) {
		System.out.print(cnt+"게임");
		System.out.print(lotto);//번호
		System.out.println(", bonus="+bonus);
	}
	//계속여부 확인하는 메소드
	public boolean yesNo() {
		do {
			System.out.print("계속하시겠습니까?(y:예, n:아니오)?");
			String qa = scan.nextLine();
			//y:계속(true), n:종료(false) 그외 다시
			if(qa.equalsIgnoreCase("y")) {
				return true;
			}else if(qa.equalsIgnoreCase("n")) {
				return false;
			}
		}while(true);
	}
	public static void main(String a[]) {
		LottoOOPCollections oop = new LottoOOPCollections();
		oop.lottoStart();
	}
	

}
