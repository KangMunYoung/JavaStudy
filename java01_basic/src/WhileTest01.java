class WhileTest01 
{
	public static void main(String[] args) 
	{
		//1~5까지 출력
		//초기값, 증가값이 while문에 존재하지 않기 때문에 별도로 식을 표시하여야한다.

		int i=1;//초기값
		

		while(i<=5){//조건식이 참일때 실행
			System.out.println(i);
			//i의 값을 증가하는 수식
			i++; //++i; i+=1; i=i+1;
		}
		//////////////////////////////////////////////
		// 5, 4, 3, 2, 1
		int j=6;
		while(j>1){
			j--;////////수정불가
			System.out.println(j);
			
		}
	}
}
/*
	While : 반복문
	
	While(조건문){
		실행문;
		실행문;
		:
	}
*/