import java.util.Calendar;
import java.util.Scanner;
class CalendarEx
{
	public static void main(String[] args) 
	{
		Calendar cal = Calendar.getInstance(); // getInstance() -> 객체를 생성해주는 메소드
		Scanner scan = new Scanner(System.in);

		//년도, 월 입력
		System.out.print("년도=");
		int inYear= scan.nextInt();
		System.out.print("월=");
		int inMonth= scan.nextInt();

		//년도, 월 삽입 후 일,요일 정보 가져오기
		cal.set(Calendar.YEAR, inYear);
		cal.set(Calendar.MONTH, inMonth-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		int week = cal.get(Calendar.DAY_OF_WEEK);	//	6  요일		
		int l_day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		System.out.printf("\t\t%d년 %d월\n",inYear,inMonth);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
						// 1  2   3  4  5   6   7 

		
		for (int i = 1; i < week; i++) { 
		System.out.print(" \t");// 시작하는 공백을 채우기위한
		}
		for (int i = 1; i<=l_day ;i++ ){	//일짜 출력
			cal.set(Calendar.DATE,i);
			System.out.print(i+"\t");
			int j = cal.get(Calendar.DAY_OF_WEEK);
			if (j % 7==0){//토요일에 개행
				System.out.println();
			}
		}
		System.out.println();
	}
}
