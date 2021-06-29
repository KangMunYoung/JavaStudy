import java.util.Scanner;

public class StandardWeightOOP2 {
	
	public StandardWeightOOP2() {
		// TODO Auto-generated constructor stub
	}
	//정보 입력
	int age;
	int gender;
	double hight=0.0;
	double weight=0.0;
	
	//데이터 입력 메소드
	double getConData(String msg){
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextDouble();
	}
	
	void setData() {
		age = (int)getConData("나이");
		gender = (int)getConData("성별");
		hight = getConData("키");
		weight = getConData("몸무게");
	}
	/*
	 * void dataInput(){ Scanner scan = new Scanner(System.in);
	 * System.out.print("나이="); age = scan.nextInt();
	 * 
	 * System.out.print("성별(1.남자 2.여자)="); gender = scan.nextInt();
	 * 
	 * System.out.print("키="); hight = scan.nextInt();
	 * 
	 * System.out.print("현재체중="); weight = scan.nextInt(); }
	 */
	
	//분류
	double idxOop() {
		double idx=0.90;
		if(age <=35 && gender ==2) idx = 0.85;
		else if(age >=36 && gender ==1) idx = 0.95;
		return idx;
	}
	//표준체중계산
	double sWeightOop() {
		double sWeight=(hight-100)*idxOop();
		return sWeight;
	}
	//표준체중지수
	double sWeightIndexOop() {
		double sWeightIndex=(weight / sWeightOop()) * 100;
		return sWeightIndex;
	}
	
	//표준체중지수 평가기준
	String sWeightMsgOop() {
		String sWeightMsg="";
		if(sWeightIndexOop()<=85) sWeightMsg = "마른형";
		else if(sWeightIndexOop()<=95) sWeightMsg = "조금마른형";
		else if(sWeightIndexOop()<=115) sWeightMsg = "표준형";
		else if(sWeightIndexOop()<=125) sWeightMsg = "조금비만형";
		else sWeightMsg = "비만형";
		return sWeightMsg;
	}
	//출력
	void print() {
		System.out.printf("표준체중=%.2f\n", sWeightOop());
		System.out.printf("당신의 표중체중지수는 %.2f으로 %s입니다\n",sWeightIndexOop(), sWeightMsgOop());
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
/*나이=36
성별(1:남성,2:여성)=1
키=168
현재체중=85
표준체중=64
당신의 표준체중지수는 131.57894736842107으로 비만형입니다.

 * */
 