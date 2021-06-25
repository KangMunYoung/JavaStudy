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
			System.out.print("���Ӽ�->");
			int game = inputNum();
			
			for(int i=1; i<=game; i++) {
				lotto();
				gamePrint(i);
			}
			
			System.out.print("����Ͻðڽ��ϱ�? [1.�� 2.�ƴϿ�]");
			check = inputNum();
		}while(check != 2);
	}
	
	public int inputNum() { // ��ȣ�Է�
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public void lotto() {	//��ȣ����&�ߺ�����
		for(int i=0; i<lottoData.length; i++) {
			lottoData[i]=(int)(Math.random()*45)+1;
			for(int c=0; c<i; c++) {
				if(lottoData[i]==lottoData[c]) {
					i--;
				}
			}
		}
	}
	
	public void gamePrint(int i) {	// ���� & ���ʽ� ����
		int lottoArr[] = Arrays.copyOfRange(lottoData, 0, 6);
		Arrays.sort(lottoArr);
		System.out.println(i+"����="+Arrays.toString(lottoArr)+" ���ʽ�="+lottoData[6]);
	}
	
	public static void main(String[] args) {
		new LottoGame();
	}
}
