import java.util.Scanner;
public class ArrayEx03_money2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
				
		do {
			
			System.out.print("�ݾ�=");
			int money = scan.nextInt();
			
			//ȭ�����
			//ȭ������Ͱ����� 2������ �ʱ�ȭ�Ͽ� �����Ѵ�.
			
			int result[][] = {{50000,0}, {10000,0},{5000,0},{1000,0},
								{500,0},{100,0},{50,0}, {10,10},{5,0},{1,0}};
			//ȭ����� ����ϱ�
			for(int row=0; row<result.length; row++) {//0,1,2,3,4,
				result[row][1]= money / result[row][0]; //ȭ�󰹼�
				money -= result[row][1]*result[row][0];//��������� ȭ��ݾ׸�ŭ ����
			}
			
			//���
			for(int row=0; row<result.length; row++) {
				if(result[row][1]>0) {
					System.out.print(result[row][0]+"="+result[row][1]);
					if(result[row][0]>=1000) {
						System.out.println("��");
					}else {
						System.out.println("��");
					}
				}
			}
			
			System.out.print("����ұ��?(1.��  2.�ƴϿ�)");
			if(scan.nextInt()==2) {
				break;
			}
		}while(true);

	}

}
