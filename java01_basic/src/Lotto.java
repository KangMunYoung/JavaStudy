//package java01_basic;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int end=0;
				
		do {
			//���Ӽ� �Է�
			System.out.print("���Ӽ� = ");
			int gameNum = scan.nextInt();
			
			for(int gi=1; gi<=gameNum; gi++) {
				//�������� �迭
				int num[] = new int[7];
				
				//���� ����
				for(int i=0; i<num.length; i++) {
					int random = (int)(Math.random()*46)+1;
					num[i]= random;
					
					
					if(num[i] != num[0] && num[i-1] == num[i]) {
						num[i] = random;
					}
					
				}
				
				
				System.out.printf("%d ����= ",gi+1);
				for(int j=0; j<num.length-1; j++) {
					System.out.print(num[j]+", ");
				}
				System.out.print("���ʽ� "+num[gameNum]);
				System.out.println();
				end++;
			}
			
			if(end == gameNum) {
				System.out.print("������ ��� �Ͻðڽ��ϱ�?(1.�� 2.�ƴϿ�)");
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
		
		//���� ����
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
					// ��ȯ�ϱ�
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
�ζ� ��ȣ : 1~45���� ��ȣ 6��
			���ʽ�1��

����
���Ӽ� = 3
1���� = 5, 13, 2, 32, 33, 45, ���ʽ� 11
2���� = 11, 23,26,32,35,41, ���ʽ� 9
3���� = 15,13,26,37,38,42, ���ʽ� 23
����Ͻðڽ��ϱ�(1:��, 2:�ƴϿ�)?1

���Ӽ� = 5
1���� = 5, 13, 2, 32, 33, 45, ���ʽ� 11
2���� = 11, 23,26,32,35,41, ���ʽ� 9
3���� = 15,13,26,37,38,42, ���ʽ� 23
4���� = 15,13,26,37,38,42, ���ʽ� 23
5���� = 15,13,26,37,38,42, ���ʽ� 23
����Ͻðڽ��ϱ�(1:��, 2:�ƴϿ�)?2


*/