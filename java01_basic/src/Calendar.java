import java.util.Calendar;
class CalendarTest 
{
	public static void main(String[] args) 
	{
		//컴퓨터의 날짜 시간정보 얻어오기
		//	Calendar(날짜,시간), Date(날짜)
		//
		Calendar now = Calendar.getInstance(); // getInstance() -> 객체를 생성해주는 메소드
		
		//날짜 변경 : set()	--> 기존정보 변경
		now.set(2018, 6, 14);
		
		//년도만 변경
		now.set(Calendar.YEAR, 2022);
		now.set(Calendar.MONTH, 10);

		//	2021년 6월 4일 (금) 16:37
		//	get() --> 날짜, 시간 관련정보를 얻어온다.
		int year = now.get(Calendar.YEAR);	//	2021
		int month = now.get(Calendar.MONTH)+1;	// 6	-> java는 0부터~11까지 (0 == 1월)
		int day = now.get(Calendar.DAY_OF_MONTH);	// 4
		int week = now.get(Calendar.DAY_OF_WEEK);	//	6
		int hour = now.get(Calendar.HOUR_OF_DAY);	//	16
		int minute = now.get(Calendar.MINUTE);	//	43
		
		String weekStr = "";
		switch(week){
			case 1 : weekStr = "일"; break;
			case 2 : weekStr = "월"; break;
			case 3 : weekStr = "화"; break;
			case 4 : weekStr = "수"; break;
			case 5 : weekStr = "목"; break;
			case 6 : weekStr = "금"; break;
			case 7 : weekStr = "토"; break;
		}

		System.out.printf("%d년 %d월 %d일 (%s) %d:%d\n", year, month, day, weekStr, hour,minute);


//		System.out.println(now);
	}
}
