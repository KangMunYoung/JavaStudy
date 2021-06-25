import java.util.Scanner;
import java.util.Calendar;
class CalendarExOOP 
{
	
	public CalendarExOOP() {
	}
	
	int year, month;
	
	int getData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextInt();
	}
	
	void setData() {
		year = getData("�⵵");
		month = getData("��");
	}
	
	//��,��,���� ���
	void setForm() {
		System.out.printf("\t\t%d�� %d��\n", year, month);
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	}
	
	//�޷� ���
	void setDate() {
		Calendar date = Calendar.getInstance();
		
		
		date.set(year, month-1,1);
		
		//���� ���ۿ���
		int week = date.get(Calendar.DAY_OF_WEEK);
		
		//���� �ִ��ϼ�
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//�������
		for (int s=1; s<week; s++) System.out.print("\t");
		
		//��¥���
		for(int d=1; d<=lastDay; d++) {
			System.out.print(d+"\t");
			if((d+week-1)%7==0) {//����� ���ڰ� 7�� ������̸� �ٹٲٱ�
				System.out.println();
			}
		}
		System.out.println();
	}
	
	void startSet() {
		setData();
		setForm();
		setDate();
	}
	
	public static void main(String[] args)	{
		CalendarExOOP oop = new CalendarExOOP();
		oop.startSet();
	}
}
