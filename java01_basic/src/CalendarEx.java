import java.util.Calendar;
import java.util.Scanner;
class CalendarEx
{
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance(); // getInstance() -> ��ü�� �������ִ� �޼ҵ�
		Scanner scan = new Scanner(System.in);

		//�⵵, �� �Է�
		System.out.print("�⵵=");
		int inYear= scan.nextInt();
		System.out.print("��=");
		int inMonth= scan.nextInt();

		//�⵵, �� ���� �� ��,���� ���� ��������
		cal.set(Calendar.YEAR, inYear);
		cal.set(Calendar.MONTH, inMonth-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		int week = cal.get(Calendar.DAY_OF_WEEK);	//	6  ����		
		int l_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.printf("\t\t%d�� %d��\n",inYear,inMonth);
		System.out.printf("��\t��\tȭ\t��\t��\t��\t��\n");
						// 1  2   3  4  5   6   7 

		
		for (int i = 1; i < week; i++) { 
		System.out.print(" \t");// �����ϴ� ������ ä�������
		}
		for (int i = 1; i<=l_day ;i++ ){	//��¥ ���
			cal.set(Calendar.DATE,i);
			System.out.print(i+"\t");
			int j = cal.get(Calendar.DAY_OF_WEEK);
			if (j % 7==0){//����Ͽ� ����
				System.out.println();
			}
		}
		System.out.println();
	}
}
