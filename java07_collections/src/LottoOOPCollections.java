
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

//�÷��� Ŭ���� Ȱ���Ͽ� �����
public class LottoOOPCollections {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public LottoOOPCollections() {}
	public void lottoStart() {
		do {
			System.out.print("���Ӽ�=");
			int game = Integer.parseInt(scan.nextLine());
			
			for(int i=1; i<=game; i++) {
				lottoCreate(i);
			}
			//��ӿ���
			if(!yesNo()) {
				break;
			}
		}while(true);
	}
	
	//1���Ӹ����
	public void lottoCreate(int i) {
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		int num=0;
		while(lotto.size()<7) {
			num = random.nextInt(45)+1;
			lotto.add(num); 
		}
		// lotto TreeSet ��ȣ7���� �ְ�, num���� ���������� ���� ��ȣ�� �ִ�.
		// bonus��ȣ�� �ζǹ�ȣ���� �����.
		lotto.remove(num);
		lottoPrint(i, lotto.toString(), num);
	}
	//���
	public void lottoPrint(int cnt, String lotto, int bonus) {
		System.out.print(cnt+"����");
		System.out.print(lotto);//��ȣ
		System.out.println(", bonus="+bonus);
	}
	//��ӿ��� Ȯ���ϴ� �޼ҵ�
	public boolean yesNo() {
		do {
			System.out.print("����Ͻðڽ��ϱ�?(y:��, n:�ƴϿ�)?");
			String qa = scan.nextLine();
			//y:���(true), n:����(false) �׿� �ٽ�
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
