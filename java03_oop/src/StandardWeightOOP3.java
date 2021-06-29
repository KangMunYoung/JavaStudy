import java.util.Scanner;

public class StandardWeightOOP3 {
	
	public StandardWeightOOP3() {		
	}
	
	//정보 입력
	int age, gender;//0
	double height, weight;//0.0
	double sWeight;//표준체중
	double sWeightIndex;//표준체중지수
	String sWeightMsg="";//유형
	
	
	//데이터 입력 메소드
	double getConData(String msg){
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextDouble();
	}
	
	void setData() {
		age = (int)getConData("나이");
		gender = (int)getConData("성별");
		height = getConData("키");
		weight = getConData("몸무게");
	}
	
	
	//표준체중 index구하기
	void setStandardWeight() {
		double index=0.90;
		if(age <=35 && gender ==2) index = 0.85;
		else if(age >=36 && gender ==1) index = 0.95;
		
		sWeight = (height-100)*index;
	}
	
	
	//표준체중지수 평가기준
	void setStandardWeightMsg() {
		sWeightIndex = (weight/sWeight)*100;
		
		if(sWeightIndex<=85) sWeightMsg = "마른형";
		else if(sWeightIndex<=95) sWeightMsg = "조금마른형";
		else if(sWeightIndex<=115) sWeightMsg = "표준형";
		else if(sWeightIndex<=125) sWeightMsg = "조금비만형";
		else sWeightMsg = "비만형";
	}
	//출력
	void StandardWeightMsgOutput() {
		System.out.println("표준체중="+ sWeight);
		System.out.println("당신의 표중체중지수는"+sWeightIndex+"으로"+sWeightMsg);
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
/*나이=36
성별(1:남성,2:여성)=1
키=168
현재체중=85
표준체중=64
당신의 표준체중지수는 131.57894736842107으로 비만형입니다.

 * */
 