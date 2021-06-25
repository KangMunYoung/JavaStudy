import java.util.Scanner;
public class ArrayScore {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		
		do {
			try {
	
			//학생수 입력
			System.out.print("학색수=");
			int cnt = Integer.parseInt(scan.nextLine());
			
			//이름배열 점수배열 생성
			String name[] = new String[cnt];
			int jumsu[][] = new int[cnt+2][6];
							
			
			//이름 점수 입력
			String title[] = {"국어","영어","수학"};
			for(int i=0; i<cnt; i++) { //0,1,2 <-행번호
				System.out.print("이름=");
				name[i] = scan.nextLine();
				
				for(int j=0; j<title.length; j++) {
					System.out.print(title[j]+"=");
					jumsu[i][j]=Integer.parseInt(scan.nextLine());
				}
			}
		
		//개인별 총점,평균
		//과목별 총점
		for(int i=0; i<cnt; i++) {//0,1,2
			for(int j=0; j<3; j++) {//0,1,2
				jumsu[i][3] += jumsu[i][j]; //개인별총점
				jumsu[cnt][j] += jumsu[i][j];//과목별총점
			}
			// 개인별총점
			jumsu[i][4]=jumsu[i][3]/3; 
		}
		//과목별 평균
		for(int i=0; i<3; i++) {
			jumsu[cnt+1][i] = jumsu[cnt][i]/cnt;
		}
		
		//석차구하기
		for(int i=0; i<cnt; i++) {//0,1,2,3
			//i가 본인의 점수
			for(int j=0; j<cnt; j++) {
				//	내점수			상대방점수
				if(jumsu[i][3] < jumsu[j][3]) {
					jumsu[i][5]++;
				}
			}
			jumsu[i][5]++;
		}
		
		//석차순으로 정렬
		for(int i=0; i<cnt-1; i++) {//3명이면 0,1
			//				
			for(int j=0; j<cnt-1-i; j++) {//3명이면 0,1
				if(jumsu[j][5] > jumsu[j+1][5]) {
					//교환
					//이름교환
					String nameTemp = name[j];
					name[j] = name[j+1];
					name[j+1] = nameTemp;
					for(int k=0; k<jumsu[j].length; k++) { //0,1,2,3,4,5
						int temp = jumsu[j][k];
						jumsu[j][k]=jumsu[j+1][k];
						jumsu[j+1][k]=temp;
						
					}
				}
			}
		}
		
		
		//출력
		System.out.println("=========================================================");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t석차");
		System.out.println("=========================================================");

		for(int i=0; i<cnt; i++) {
			System.out.print(name[i]+"\t");
			for(int j=0; j<jumsu[i].length; j++) {
				System.out.print(jumsu[i][j]+"\t");
			}
			System.out.println();
		}
		
		//과목별 총점
		System.out.print("총점\t");
		for(int i=0; i<3; i++) {
			System.out.print(jumsu[cnt][i]+"\t");
		}
		System.out.println();
		
		//과목별 평균
		System.out.print("평균\t");
		for(int i=0; i<3; i++) {
			System.out.print(jumsu[cnt+1][i]+"\t");
		}
		System.out.println();
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를입력하세요");
			}
		
		}while(true);
		
		

	}

}

/*
 * 학생수를 입력받아 이름과, 세과목의 점수를 입력받은 후
 * 각 학생의 총점,평균,석차, 과목별 총점, 평균을 구하여 
 * 석차순으로 출력하라.
 * 
 * 실행
 * 학생수=3
 * 
 * 이름=홍길동
 * 국어=90
 * 영어=89
 * 수학=90
 * 이름=이순신
 * 국어=90
 * 영어=90
 * 수학=43
 * :
 * :
 * ====================================================
 * 이름		국어		영어		수학		총점		평균		석차
 * ====================================================
 * 홍길동		90		89		90		269		___		1
 * 이순신		90		90		43		233		___		2
 * :		:		:		:		:		:		:
 * 과목별총점	__		__		__		__			
 * 과목별평균	__		__		__		__
 * 
 * 총점이 동륭이면 석차는 동일하다
 * 
 * */
