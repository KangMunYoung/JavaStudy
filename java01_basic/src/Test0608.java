/*
import java.util.Scanner;
class ForDiamondTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//�Է�
		System.out.print("������ Ȧ���Է�(1~49)=");
		int max = scan.nextInt();
		
		
		
		if(max%2==0){//Ȧ��Ȯ�� ¦����� +1
			max+=1;
		}
		char txt = 'A';
		int step = 2;
		for(int row=1; row>0; row+=step){// 1,3,5,7,9, 11,..... max
			
			for(int s=1; s<=(max-row)/2; s++){//����ó��
				System.out.print(" ");
			}
			for(int cnt=1; cnt<=row; cnt++){//1�ٹ��� ���
				System.out.print(txt++);
				if(txt > 'Z'){//	'Z'�� ����ϰ� ���� 'A'�� ����Ѵ�.
					txt = 'A';
				}
			}
			System.out.println();
			if(row>max){
				step=-2;
			}
		}
	}
}
*/