import java.util.Scanner;
public class ArrayScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		
		do {
			try {
	
			//�л��� �Է�
			System.out.print("�л���=");
			int cnt = Integer.parseInt(scan.nextLine());
			
			//�̸��迭 �����迭 ����
			String name[] = new String[cnt];
			int jumsu[][] = new int[cnt+2][6];
							
			
			//�̸� ���� �Է�
			String title[] = {"����","����","����"};
			for(int i=0; i<cnt; i++) { //0,1,2 <-���ȣ
				System.out.print("�̸�=");
				name[i] = scan.nextLine();
				
				for(int j=0; j<title.length; j++) {
					System.out.print(title[j]+"=");
					jumsu[i][j]=Integer.parseInt(scan.nextLine());
				}
			}
		
		//���κ� ����,���
		//���� ����
		for(int i=0; i<cnt; i++) {//0,1,2
			for(int j=0; j<3; j++) {//0,1,2
				jumsu[i][3] += jumsu[i][j]; //���κ�����
				jumsu[cnt][j] += jumsu[i][j];//��������
			}
			// ���κ�����
			jumsu[i][4]=jumsu[i][3]/3; 
		}
		//���� ���
		for(int i=0; i<3; i++) {
			jumsu[cnt+1][i] = jumsu[cnt][i]/cnt;
		}
		
		//�������ϱ�
		for(int i=0; i<cnt; i++) {//0,1,2,3
			//i�� ������ ����
			for(int j=0; j<cnt; j++) {
				//	������			��������
				if(jumsu[i][3] < jumsu[j][3]) {
					jumsu[i][5]++;
				}
			}
			jumsu[i][5]++;
		}
		
		//���������� ����
		for(int i=0; i<cnt-1; i++) {//3���̸� 0,1
			//				
			for(int j=0; j<cnt-1-i; j++) {//3���̸� 0,1
				if(jumsu[j][5] > jumsu[j+1][5]) {
					//��ȯ
					//�̸���ȯ
					String nameTemp = name[j];
					name[j] = name[j+1];
					name[j+1] = nameTemp;
					for(int k=0; k<jumsu[j].length; k++) { //0,1,2,3,4,5
						int temp = jumsu[j][k];
						jumsu[j][k]=jumsu[j+1][k];
						jumsu[j+1][k]=temp;
						
					}
				}
			}
		}
		
		
		//���
		System.out.println("=========================================================");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("=========================================================");

		for(int i=0; i<cnt; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println();
		}
		
		//���� ����
		System.out.print("����\t");
		for(int i=0; i<3; i++) {
			System.out.print(jumsu[cnt][i]+"\t");
		}
		System.out.println();
		
		//���� ���
		System.out.print("���\t");
		for(int i=0; i<3; i++) {
			System.out.print(jumsu[cnt+1][i]+"\t");
		}
		System.out.println();
			}catch(NumberFormatException nfe) {
				System.out.println("���ڸ��Է��ϼ���");
			}
		
		}while(true);
		
		

	}

}

/*
 * �л����� �Է¹޾� �̸���, �������� ������ �Է¹��� ��
 * �� �л��� ����,���,����, ���� ����, ����� ���Ͽ� 
 * ���������� ����϶�.
 * 
 * ����
 * �л���=3
 * 
 * �̸�=ȫ�浿
 * ����=90
 * ����=89
 * ����=90
 * �̸�=�̼���
 * ����=90
 * ����=90
 * ����=43
 * :
 * :
 * ====================================================
 * �̸�		����		����		����		����		���		����
 * ====================================================
 * ȫ�浿		90		89		90		269		___		1
 * �̼���		90		90		43		233		___		2
 * :		:		:		:		:		:		:
 * ��������	__		__		__		__			
 * �������	__		__		__		__
 * 
 * ������ �����̸� ������ �����ϴ�
 * 
 * */
