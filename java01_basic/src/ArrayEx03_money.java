import java.util.Scanner;
public class ArrayEx03_money {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int yesNo=1;
		do {
			//�ݾ��Է�
			System.out.print("�ݾ��� �Է��ϼ���.?");
			int money = scan.nextInt();
			
			//���� �迭
			int monArr[] = new int[10];
			int don = 50000;
			int div = 5;
			
			for(int i=0; i<monArr.length; i++) {
				
				monArr[i]=money/don;
				if(monArr[i] != 0) {
					System.out.print(don+"��"+monArr[i]);
					if(money >= 1000) {
						System.out.println("��");
					}else {
						System.out.println("��");
					}
				}
				
				money = money - don*monArr[i];
				don /= div;
				
				if(div==5) div = 2;
				else div = 5;
			}
			
			System.out.print("�ٽ��Ͻðڽ��ϱ�?(1.�� 2.�ƴϿ�)?");
			yesNo = scan.nextInt();
			if(yesNo==2)
				break;
		}while(true);
			

	}

}
/*				if(monArr[i] != 0 && money > 1000) {
System.out.println(don+"��"+monArr[i]+"��");						
}else if(monArr[i] != 0){
System.out.println(don+"��"+monArr[i]+"��");
}
*/			

//�迭 ����
/*
for(int i=0; i<monArr.length; i++) {
	System.out.print(monArr[i]+", ");
}
System.out.println();
*/

/*

50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1
����
�ݾ��� �Է��ϼ���.? 123300
50000��=2��
10000��=2��
1000��=3��
100��=3��
�ٽ��Ͻðڽ��ϱ�(1.�� 2.�ƴϿ�)?

�ݾ��� �Է��ϼ���.? 5435
5000��=1��
100��=4��
10��=3��
1��=5��
�ٽ��Ͻðڽ��ϱ�(1.�� 2.�ƴϿ�)?2

*/