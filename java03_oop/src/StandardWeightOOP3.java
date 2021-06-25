import java.util.Scanner;

public class StandardWeightOOP3 {
	
	public StandardWeightOOP3() {		
	}
	
	//���� �Է�
	int age, gender;//0
	double height, weight;//0.0
	double sWeight;//ǥ��ü��
	double sWeightIndex;//ǥ��ü������
	String sWeightMsg="";//����
	
	
	//������ �Է� �޼ҵ�
	double getConData(String msg){
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextDouble();
	}
	
	void setData() {
		age = (int)getConData("����");
		gender = (int)getConData("����");
		height = getConData("Ű");
		weight = getConData("������");
	}
	
	
	//ǥ��ü�� index���ϱ�
	void setStandardWeight() {
		double index=0.90;
		if(age <=35 && gender ==2) index = 0.85;
		else if(age >=36 && gender ==1) index = 0.95;
		
		sWeight = (height-100)*index;
	}
	
	
	//ǥ��ü������ �򰡱���
	void setStandardWeightMsg() {
		sWeightIndex = (weight/sWeight)*100;
		
		if(sWeightIndex<=85) sWeightMsg = "������";
		else if(sWeightIndex<=95) sWeightMsg = "���ݸ�����";
		else if(sWeightIndex<=115) sWeightMsg = "ǥ����";
		else if(sWeightIndex<=125) sWeightMsg = "���ݺ���";
		else sWeightMsg = "����";
	}
	//���
	void StandardWeightMsgOutput() {
		System.out.println("ǥ��ü��="+ sWeight);
		System.out.println("����� ǥ��ü��������"+sWeightIndex+"����"+sWeightMsg);
	}
	
	void start() {
		setData();
		setStandardWeight();
		setStandardWeightMsg();
		StandardWeightMsgOutput();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardWeightOOP3 oop = new StandardWeightOOP3();
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
 