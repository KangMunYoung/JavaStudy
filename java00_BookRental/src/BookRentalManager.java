import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import dataInfo.BookDataSet;
import dataInfo.BookVO;
import dataInfo.ProfileDataSet;
import dataInfo.ProfileVO;

public class BookRentalManager {
	Scanner scan = new Scanner(System.in);
	static String session = "";	// 로그아웃상태, 관리자로그인, 멤버로그인
	String id = "";
	String memberName="";
	public BookRentalManager() {
	}

	public void bookRentalStart() {
		ProfileDataSet.basicProfileSet();
		BookDataSet.basicBookSet();
		BookDataSet.rentalBookListSet();
		
		do {
			firstMenu();
			if(session.equals("admin")) {
				System.out.println("관리자계정으로 로그인 되었습니다.");
				adminMenu();
			}else if(session.equals("user")) {
				System.out.println("로그인 되었습니다.");
				memberName = ProfileDataSet.profileList.get(id).getName();
				memberMenu();
			}
		}while(true);
	}
	
	public void firstMenu() {//로그인//회원가입//종료
		boolean logResult = false;
		Login log = new Login();
		do {
			String menu = inData("메뉴를 선택해주세요[1.로그인, 2.회원가입, 3.종료]");
			if(menu.equals("1")) {//로그인
				id = inData("아이디");
				String pwd = inData("비밀번호");
				logResult = log.loginCheck(id, pwd);
			}else if(menu.equals("2")) {//회원가입
				logResult = signUp();
			}else if(menu.equals("3")) {//프로그램종료
				programExit();
			}else {
				System.out.println("메뉴를 잘못입력하셨습니다. 다시입력하세요.");
			}
		}while(!logResult);
	}

	//날짜정보==============================================================
	public String nowDate() {	//날짜정보
		Calendar now = Calendar.getInstance();
		String year = Integer.toString(now.get(Calendar.YEAR));
		String month = Integer.toString(now.get(Calendar.MONTH)+1);
		String day = Integer.toString(now.get(Calendar.DAY_OF_MONTH));
		return year+"-"+month+"-"+day;
	}
	//회원가입=======================================================
	public boolean signUp() {	//회원가입
		ProfileVO vo = new ProfileVO();
		vo.setMemberId(inData("아이디"));
		vo.setMemberPwd(inData("비밀번호"));
		vo.setName(inData("이름"));
		vo.setTel(inData("전화번호"));
		vo.setSince(nowDate());
		do {
			boolean flag = true;
			try {
				vo.setMoney(Integer.parseInt(inData("가진돈")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("돈은 숫자로 입력하세요");
			}
			if(flag) break;
		}while(true);
		ProfileDataSet.profileList.put(vo.getMemberId(), vo);
		return true;
	}
	
	//회원메뉴
	public void memberMenu() {
		String memberTitle = "메뉴[1.책대여, 2.책반납, 3.선금넣기, 4.로그아웃, 5.종료]";
		do {
			try {
				allBookList();
				rentalList();
				
				System.out.println("선금->"+ProfileDataSet.profileList.get(id).getMoney());
				int menu = Integer.parseInt(inData(memberTitle));
				if(menu == 1) {rental(menu);	//책대여
				}else if(menu == 2) { 
					rental(menu);	//책반납
				}else if(menu == 3) { 
					memMoney();//선금넣기
				}else if(menu == 4) { 
					logout();	//로그아웃
				}else if(menu == 5) { 
					programExit();	//종료
				}
			}catch(NumberFormatException nfe) {
				System.out.println("잘못입력하셨습니다. 1~7사이의 메뉴를 골라주세요");
			}
		}while(session.equals("user"));
	}
	//선금넣기
	public void memMoney() {
		int money = Integer.parseInt(inData("얼마를 추가하시겠습니까."));
		ProfileVO vo = ProfileDataSet.profileList.get(id);
		int wallet = vo.getMoney()+money;
		vo.setMoney(wallet);
	}
	
	//책대여
	public void rental(int menu) { // 책대여&책반납
		String pick = inData("대여할 책제목을 입력하세요");
		if(BookDataSet.bookList.containsKey(pick) || BookDataSet.rentalBookList.containsKey(pick)) {
			BookVO vo = BookDataSet.bookList.get(pick);
			ProfileVO pvo = ProfileDataSet.profileList.get(id);
			
			if(menu == 1 && vo.getBookStatus().equals("보유중")) {		//책대여
				statusUpdate(pick, menu);
				BookDataSet.rentalBookList.put(vo.getBookName(), vo);
				int don = pvo.getMoney() - vo.getRentalFee(); 
				pvo.setMoney(don);
				
			}else if(menu == 2) {	//책반납
				statusUpdate(pick, menu);
				BookDataSet.bookList.put(vo.getBookName(), vo);
				BookDataSet.rentalBookList.remove(pick);
			}else {
				System.out.println("대여할수 없는 책입니다.");
			}
		}else {
			System.out.println("목록에 없는 책입니다.");
		}
		
	}
	//대여목록
	public void rentalList() {
		Collection<BookVO> rentalList = BookDataSet.rentalBookList.values();
		Iterator<BookVO> ii = rentalList.iterator();
		System.out.println("--------------------------------대여목록--------------------------------");
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			
			BookVO vo = ii.next();
			if(memberName.equals(vo.getBookStatus())) {
				vo.bookPrint();
			}
		}
	}

	
	//관리자메뉴==================================================================
	public void adminMenu() {
		String adminTitle = "메뉴[1.책등록, 2.책삭제, 3.책목록, 4.회원등록, 5.회원목록, 6.회원삭제, 7.로그아웃, 8.종료]";
		do {
			try {
				System.out.println("관리자메뉴");
				int menu = Integer.parseInt(inData(adminTitle));
				if(menu == 1) {	//책등록
					addBook(); allBookList(); 
				}else if(menu == 2) {	//책삭제
					delBook(); allBookList();
				}else if(menu == 3) {	//책목록
					allBookList();
				}else if(menu == 4) {	//회원등록
					signUp(); allProfileList();
				}else if(menu == 5) {	//회원목록
					allProfileList();
				}else if(menu == 6) {	//회원삭제
					delProfile(); allProfileList();
				}else if(menu == 7) {	//로그아웃
					logout();
				}else if(menu == 8) {	//종료
					programExit();
				}
			}catch(NumberFormatException nfe) {
				System.out.println("잘못입력하셨습니다. 1~8사이의 메뉴를 골라주세요");
			}
		}while(session.equals("admin"));
	}
	//책등록===========================================================
	public void addBook() {
		BookVO vo = new BookVO();
		vo.setBookName(inData("제목"));
		vo.setGenre(inData("장르"));
		do {
			boolean flag = true;
			try {
				vo.setRentalFee(Integer.parseInt(inData("대여비")));
				vo.setRentalDate(Integer.parseInt(inData("대여일")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("잘못입력 하셨습니다. 대여비용을 숫자로 입력하세요");
			}
			if(flag) break;
		}while(true);
		BookDataSet.bookList.put(vo.getBookName(), vo);
	}
	
	//책삭제============================================================
	public void delBook() {
		String delName = inData("삭제할 책제목");
		BookDataSet.bookList.remove(delName);
	}

	
	//회원목록 출력하기====================================================
	public void allProfileList() {
		Collection<ProfileVO> list = ProfileDataSet.profileList.values();
		Iterator<ProfileVO> ii = list.iterator();
		ProfileVO.profileTitlePrint();
		while(ii.hasNext()) {
			ProfileVO vo = ii.next();
			vo.profilePrint();
		}
	}
	//회원삭제=============================================================
	public void delProfile() {
		allProfileList();
		String delName = inData("삭제할 아이디");
		ProfileDataSet.profileList.remove(delName);
		System.out.println(delName+"삭제됨");
	}
	
	//공통=================================================================
	//로그아웃 & 종료 & 입력받기===============================================
	public void logout() {//로그아웃
		session = "logout";
		System.out.println("로그아웃되었습니다.");
	}
	public void programExit() {	//종료
		System.out.println("프로그램이 종료되었습니다.");
		System.exit(0);
	}
	
	public String inData(String msg) {	//입력받기
		System.out.print(msg+"->");
		return scan.nextLine();
	}
	//책목록 출력하기=============================================
	public void allBookList() {
		Collection<BookVO> bookList = BookDataSet.bookList.values();
		Iterator<BookVO> ii = bookList.iterator();
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	
	//정보수정===========================================================
	public void statusUpdate(String pic, int menu) {//상태수정
		if(menu == 1) {
			BookVO vo = BookDataSet.bookList.get(pic);
			vo.setBookStatus(memberName);
		}else if(menu == 2) {
			BookVO vo = BookDataSet.rentalBookList.get(pic);
			vo.setBookStatus("보유중");
		}
	}
	
}
