import java.util.Scanner;
import java.util.Calendar;
class CalendarExOOP 
{
	
	public CalendarExOOP() {
	}
	
	int year, month;
	
	int getData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"=");
		return scan.nextInt();
	}
	
	void setData() {
		year = getData("년도");
		month = getData("월");
	}
	
	//년,월,요일 출력
	void setForm() {
		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	
	//달력 출력
	void setDate() {
		Calendar date = Calendar.getInstance();
		
		
		date.set(year, month-1,1);
		
		//월의 시작요일
		int week = date.get(Calendar.DAY_OF_WEEK);
		
		//월의 최대일수
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//공백출력
		for (int s=1; s<week; s++) System.out.print("\t");
		
		//날짜출력
		for(int d=1; d<=lastDay; d++) {
			System.out.print(d+"\t");
			if((d+week-1)%7==0) {//출력한 문자가 7의 배수개이면 줄바꾸기
				System.out.println();
			}
		}
		System.out.println();
	}
	
	void startSet() {
		setData();
		setForm();
		setDate();
	}
	
	public static void main(String[] args)	{
		CalendarExOOP oop = new CalendarExOOP();
		oop.startSet();
	}
}
