import java.util.Scanner;

public class StandardWeightOOP2 {
	
	public StandardWeightOOP2() {
		// TODO Auto-generated constructor stub
	}
	//���� �Է�
	int age;
	int gender;
	double hight=0.0;
	double weight=0.0;
	
	//������ �Է� �޼ҵ�
	double getConData(String msg){
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextDouble();
	}
	
	void setData() {
		age = (int)getConData("����");
		gender = (int)getConData("����");
		hight = getConData("Ű");
		weight = getConData("������");
	}
	/*
	 * void dataInput(){ Scanner scan = new Scanner(System.in);
	 * System.out.print("����="); age = scan.nextInt();
	 * 
	 * System.out.print("����(1.���� 2.����)="); gender = scan.nextInt();
	 * 
	 * System.out.print("Ű="); hight = scan.nextInt();
	 * 
	 * System.out.print("����ü��="); weight = scan.nextInt(); }
	 */
	
	//�з�
	double idxOop() {
		double idx=0.90;
		if(age <=35 && gender ==2) idx = 0.85;
		else if(age >=36 && gender ==1) idx = 0.95;
		return idx;
	}
	//ǥ��ü�߰��
	double sWeightOop() {
		double sWeight=(hight-100)*idxOop();
		return sWeight;
	}
	//ǥ��ü������
	double sWeightIndexOop() {
		double sWeightIndex=(weight / sWeightOop()) * 100;
		return sWeightIndex;
	}
	
	//ǥ��ü������ �򰡱���
	String sWeightMsgOop() {
		String sWeightMsg="";
		if(sWeightIndexOop()<=85) sWeightMsg = "������";
		else if(sWeightIndexOop()<=95) sWeightMsg = "���ݸ�����";
		else if(sWeightIndexOop()<=115) sWeightMsg = "ǥ����";
		else if(sWeightIndexOop()<=125) sWeightMsg = "���ݺ���";
		else sWeightMsg = "����";
		return sWeightMsg;
	}
	//���
	void print() {
		System.out.printf("ǥ��ü��=%.2f\n", sWeightOop());
		System.out.printf("����� ǥ��ü�������� %.2f���� %s�Դϴ�\n",sWeightIndexOop(), sWeightMsgOop());
	}
	
	void start() {
		setData();
		print();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardWeightOOP2 oop = new StandardWeightOOP2();
		oop.start();
	}

}
/*����=36
����(1:����,2:����)=1
Ű=168
����ü��=85
ǥ��ü��=64
����� ǥ��ü�������� 131.57894736842107���� �����Դϴ�.

 * */
 