import java.util.Scanner;

public class StandardWeightOOP {
	
	public StandardWeightOOP() {
		// TODO Auto-generated constructor stub
	}
	//���� �Է�
	int age;
	int gender;
	double hight=0.0;
	double weight=0.0;
	double idx=0.90;
	double sWeight=0.0;
	double sWeightIndex=0.0;
	
	String sWeightMsg = "";
	
	void dataInput(){
		Scanner scan = new Scanner(System.in);
		System.out.print("����=");
		age = scan.nextInt();
		
		System.out.print("����(1.���� 2.����)=");
		gender = scan.nextInt();
		
		System.out.print("Ű=");
		hight = scan.nextInt();
		
		System.out.print("����ü��=");
		weight = scan.nextInt();
	}
	
	//�з�
	void result() {
		idx = 0.90;
		if(age <=35 && gender ==2) idx = 0.85;
		else if(age >=36 && gender ==1) idx = 0.95;
	}
	//ǥ��ü�߰��
	void sWeight() {
		sWeight = (hight-100)*idx;
	}
	//ǥ��ü������
	void sWeightIndex() {
		sWeightIndex = (weight / sWeight) * 100;
	}
	
	//ǥ��ü������ �򰡱���
	void sWeightMsg() {
		
		if(sWeightIndex<=85) sWeightMsg = "������";
		else if(sWeightIndex<=95) sWeightMsg = "���ݸ�����";
		else if(sWeightIndex<=115) sWeightMsg = "ǥ����";
		else if(sWeightIndex<=125) sWeightMsg = "���ݺ���";
		else sWeightMsg = "����";
	}
	//���
	void print() {
		System.out.printf("ǥ��ü��=%.2f\n", sWeight);
		System.out.printf("����� ǥ��ü�������� %.2f���� %s�Դϴ�\n",sWeightIndex, sWeightMsg);
	}
	
	void start() {
		dataInput();
		result();
		sWeight();
		sWeightIndex();
		sWeightMsg();
		print();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardWeightOOP oop = new StandardWeightOOP();
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
 