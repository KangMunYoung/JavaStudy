import java.util.Scanner;
class StandardWeight 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		double aveWeigh = 0;	//표준체중
		double weighIndices=0;	//표준체중 지수
		
		//입력
		System.out.print("나이=");
		int age = scan.nextInt();
		System.out.print("성별(1:남성,2:여성)=");
		int sex = scan.nextInt();
		System.out.print("키=");
		int tall = scan.nextInt();
		System.out.print("현재체중=");
		int weigh = scan.nextInt();

		//나이구분
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

		//표준체중지수 계산
		weighIndices = ((weigh / aveWeigh) * 100);
		
		String std ="";

		if(weighIndices <= 85){
			std = "마른형";
		}else if(86 <= weighIndices && weighIndices <= 95){
			std = "조금마른형";
		}else if(96 <= weighIndices && weighIndices <= 115){
			std = "표준형";
		}else if(116 <= weighIndices && weighIndices <= 125){
			std = "조금 비만형";
		}else if(126 < weighIndices){
			std = "비만형";
		}	
	
		System.out.printf("표준체중=%d\n",(int)aveWeigh);
		System.out.printf("당신의 표준체중지수는 %.14f으로 %s입니다.\n",weighIndices, std);

	}
}
/*
	표준체중 기준
	35세 이하
		남성: (키-100)*0.90
		여성: (키-100)*0.85
	36세 이상
		남성: (키-100)*0.95
		여성: (키-100)*0.90

	표준체중지수 = (현재체중/표준체중)*100
		
		표준체중지수 평가기준
			마른형 : 85이하
			조금마른형 : 86~95
			표준형 : 96~115
			조금 비만형 : 116~125
			비만형 : 126 이상
*/