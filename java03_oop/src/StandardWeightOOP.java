import java.util.Scanner;

public class StandardWeightOOP {
	
	public StandardWeightOOP() {
		// TODO Auto-generated constructor stub
	}
	//정보 입력
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
		System.out.print("나이=");
		age = scan.nextInt();
		
		System.out.print("성별(1.남자 2.여자)=");
		gender = scan.nextInt();
		
		System.out.print("키=");
		hight = scan.nextInt();
		
		System.out.print("현재체중=");
		weight = scan.nextInt();
	}
	
	//분류
	void result() {
		idx = 0.90;
		if(age <=35 && gender ==2) idx = 0.85;
		else if(age >=36 && gender ==1) idx = 0.95;
	}
	//표준체중계산
	void sWeight() {
		sWeight = (hight-100)*idx;
	}
	//표준체중지수
	void sWeightIndex() {
		sWeightIndex = (weight / sWeight) * 100;
	}
	
	//표준체중지수 평가기준
	void sWeightMsg() {
		
		if(sWeightIndex<=85) sWeightMsg = "마른형";
		else if(sWeightIndex<=95) sWeightMsg = "조금마른형";
		else if(sWeightIndex<=115) sWeightMsg = "표준형";
		else if(sWeightIndex<=125) sWeightMsg = "조금비만형";
		else sWeightMsg = "비만형";
	}
	//출력
	void print() {
		System.out.printf("표준체중=%.2f\n", sWeight);
		System.out.printf("당신의 표중체중지수는 %.2f으로 %s입니다\n",sWeightIndex, sWeightMsg);
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
/*나이=36
성별(1:남성,2:여성)=1
키=168
현재체중=85
표준체중=64
당신의 표준체중지수는 131.57894736842107으로 비만형입니다.

 * */
 