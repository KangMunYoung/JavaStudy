import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		double aveWeigh = 0;	//ǥ��ü��
		double weighIndices=0;	//ǥ��ü�� ����
		
		//�Է�
		System.out.print("����=");
		int age = scan.nextInt();
		System.out.print("����(1:����,2:����)=");
		int sex = scan.nextInt();
		System.out.print("Ű=");
		int tall = scan.nextInt();
		System.out.print("����ü��=");
		int weigh = scan.nextInt();

		//���̱���
		if(35 >= age){
			switch(sex){
				case 1 : aveWeigh = (double)((tall-100)*0.90); break;
				case 2 : aveWeigh = (double)((tall-100)*0.85); break;
			}
		}else{
			switch(sex){
				case 1 : aveWeigh = (double)((tall-100)*0.95); break;
				case 2 : aveWeigh = (double)((tall-100)*0.90); break;
			}
		}

		//ǥ��ü������ ���
		weighIndices = ((weigh / aveWeigh) * 100);
		
		String std ="";

		if(weighIndices <= 85){
			std = "������";
		}else if(86 <= weighIndices && weighIndices <= 95){
			std = "���ݸ�����";
		}else if(96 <= weighIndices && weighIndices <= 115){
			std = "ǥ����";
		}else if(116 <= weighIndices && weighIndices <= 125){
			std = "���� ����";
		}else if(126 < weighIndices){
			std = "����";
		}	
	
		System.out.printf("ǥ��ü��=%d\n",(int)aveWeigh);
		System.out.printf("����� ǥ��ü�������� %.14f���� %s�Դϴ�.\n",weighIndices, std);

	}
}
/*
	ǥ��ü�� ����
	35�� ����
		����: (Ű-100)*0.90
		����: (Ű-100)*0.85
	36�� �̻�
		����: (Ű-100)*0.95
		����: (Ű-100)*0.90

	ǥ��ü������ = (����ü��/ǥ��ü��)*100
		
		ǥ��ü������ �򰡱���
			������ : 85����
			���ݸ����� : 86~95
			ǥ���� : 96~115
			���� ���� : 116~125
			���� : 126 �̻�
*/