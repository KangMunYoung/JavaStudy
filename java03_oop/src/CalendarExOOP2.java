import java.util.Calendar;
import java.util.Scanner;

public class CalendarExOOP2 {
	Scanner scan =new Scanner(System.in);
	Calendar date;
	
	public CalendarExOOP2() {
		calendarStart();
	}
	
	public void calendarStart() {
		/////년도 월
		int year = getDate("년도");
		int month = getDate("월");
		
		titlePrint(year, month);
		
		
		date = Calendar.getInstance();
		//입력받은 년월, 1일을 세팃팅
		
		date.set(year,  month-1,1);
		//요일구하기
		
		int week = date.get(Calendar.DAY_OF_WEEK);
		
		spacePrint(week-1);//요일정보 이용 공백출력
		
		//현년월의 마지막날
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//날짜 출력
		dayPrint(week-1, lastDay);
	}
	
	//날짜출력
	public void dayPrint(int space, int lastDay) {
		for(int day=1; day<=lastDay; day++) {
			System.out.print(day+"\t");
			if((day+space)%7==0) {
				System.out.println();
			}
		}
	}
	
	public void spacePrint(int cnt) {
		for(int i=1; i<=cnt; i++) {
			System.out.print("\t");
		}
	}
	
	
	public void titlePrint(int year, int month) {
		System.out.println("\t\t"+year+"년 "+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	
	
	public int getDate(String msg) {
		System.out.print(msg+"->");
		return Integer.parseInt(scan.nextLine());
	}
	
	
	public static void main(String[] args) {
		new CalendarExOOP2();
	}

}
/*
 * 년월을 입력받아 달력출력
 * 멤버에는 Scanner Calendar 존재한다.
 */