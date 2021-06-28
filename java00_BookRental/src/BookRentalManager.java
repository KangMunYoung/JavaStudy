import java.text.SimpleDateFormat;
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
	static String session = "";	// admin, user, logout
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
				System.out.println("관리자로그인");
				adminMenu();
			}else if(session.equals("user")) {
				System.out.println("로그인 되었습니다.");
				memberName = ProfileDataSet.profileList.get(id).getName();
		
				memberMenu();
			}
		}while(true);
	}
	public void firstMenu() {//로그인. 회원가입, 종료
		boolean logResult = false;
		Login log = new Login();
		do {
			String menu = inData("메뉴[1.로그인, 2.회원가입, 3.종료]");
			if(menu.equals("1")) {//로그인
				id = inData("아이디");
				String pwd = inData("비밀번호");
				logResult = log.loginCheck(id, pwd);
			}else if(menu.equals("2")) {//회원가입
				logResult = signUp();
			}else if(menu.equals("3")) {//종료
				programExit();
			}else {
				System.out.println("1~3번중에서 골라주세요");
			}
		}while(!logResult);
	}

	//달력==============================================================
	public String nowDate() {	//달력
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(now.getTime());
	}
	//회원가입=======================================================
	public boolean signUp() {	//회원가입
		allProfileList();
		ProfileVO vo = new ProfileVO();
		vo.setMemberId(inData("아이디"));
		vo.setMemberPwd(inData("비밀번호"));
		vo.setName(inData("이름"));
		vo.setTel(inData("전화번호"));
		vo.setSince(nowDate());
		do {
			boolean flag = true;
			try {
				vo.setMoney(Integer.parseInt(inData("선금")));
			}catch(NumberFormatException nfe) {
				System.out.println("잘못입력하셨습니다. 돈단위로 입력해주세요");
				flag = false;
			}
			if(flag) break;
		}while(true);
		ProfileDataSet.profileList.put(vo.getMemberId(), vo);
		allProfileList();
		return true;
	}
	
	//회원메뉴
	public void memberMenu() {
		String memberTitle = "메뉴[1.책대여, 2.책반납, 3.선금넣기, 4.로그아웃, 5.종료]";
		do {
			try {
				allBookList();
				rentalList();
				int money = ProfileDataSet.profileList.get(id).getMoney();
				int cnt = ProfileDataSet.profileList.get(id).getRentalCnt();
				System.out.println("이름: ["+memberName+"] 적립금->["+money+"] 대여권수->["+cnt+"]");
				int menu = Integer.parseInt(inData(memberTitle));
				if(menu == 1) {		//책 대여
					rental(menu);
				}else if(menu == 2) {	// 책 반납 
					rental(menu);	
				}else if(menu == 3) {	//선금 
					memMoney();
				}else if(menu == 4) {	//로그아웃 
					logout();
				}else if(menu == 5) {	//종료 
					programExit();
				}
			}catch(NumberFormatException nfe) {
				System.out.println("잘못입력하셨습니다.");
			}
		}while(session.equals("user"));
	}
	//선금추가
	public void memMoney() {
		ProfileVO vo = ProfileDataSet.profileList.get(id);
		do {
			boolean flag = true;
			try {
				vo.setMoney(vo.getMoney()+Integer.parseInt(inData("얼마를 추가하시겠습니까?")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("금액을 숫자로 입력해 주세요.");
			}
			if(flag) break;
		}while(true);
	}
	
	//대여 & 반납
	public void rental(int menu) { // 대여 & 반납
		String pick = inData("책 제목을 입력해주세요");
		if(BookDataSet.bookList.containsKey(pick) || BookDataSet.rentalBookList.containsKey(pick)) {
			BookVO vo = BookDataSet.bookList.get(pick);
			ProfileVO pvo = ProfileDataSet.profileList.get(id);
			
			if(menu == 1 && vo.getBookStatus().equals("보유중")) {	//대여
				statusUpdate(pick, menu);
				BookDataSet.rentalBookList.put(vo.getBookName(), vo);
				pvo.setMoney(pvo.getMoney() - vo.getRentalFee());
				pvo.setRentalCnt(pvo.getRentalCnt()+1);
			}else if(menu == 2) {	//반납
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
	//대여중 목록
	public void rentalList() {
		Collection<BookVO> rentalList = BookDataSet.rentalBookList.values();
		Iterator<BookVO> ii = rentalList.iterator();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("아래는 대여중인 항목입니다.-----------------------------------------------------");
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			if(session.equals("admin")) {
				vo.bookPrint();
			}else if(memberName.equals(vo.getBookStatus())) {
				vo.bookPrint();
			}
		}
	}
	
	//관리자 메뉴==================================================================
	public void adminMenu() {
		String adminTitle = "관리자 메뉴[1.책등록, 2.책삭제, 3.책목록, 4.회원등록, 5.회원목록, 6.회원삭제, 7.회원정보 수정 8.책정보 수정 9.로그아웃, 10.종료]";
		
		do {
			try {
				int menu = Integer.parseInt(inData(adminTitle));
				if(menu == 1) {	//책등록
					addBook(); 
				}else if(menu == 2) {	//책삭제
					delBook(); 
				}else if(menu == 3) {	//책목록
					allBookList(); rentalList();
				}else if(menu == 4) {	//회원등록
					signUp(); 
				}else if(menu == 5) {	//회원목록
					allProfileList();
				}else if(menu == 6) {	//회원삭제
					delProfile(); 
				}else if(menu == 7) {	//회원정보 수정
					profileUpdate();
				}else if(menu == 8) {	//책 정보 수정
					bookUpdate();
				}else if(menu == 9) {	//로그아웃
					logout();
				}else if(menu == 10) {	//종료
					programExit();
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println("잘못입력하셨습니다. 1~8중에서 선택해주세요.");
			}
		}while(session.equals("admin"));
	}
	//책 추가===========================================================
	public void addBook() {
		allBookList();
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
				System.out.println("잘못입력 하셨습니다. 숫자로 입력하세요");
			}
			if(flag) break;
		}while(true);
		BookDataSet.bookList.put(vo.getBookName(), vo);
		allBookList(); 
	}
	
	//책 삭제============================================================
	public void delBook() {
		allBookList();
		BookDataSet.bookList.remove(inData("삭제할 책제목"));
		allBookList();
	}
	
	//회원 목록====================================================
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
		System.out.println(delName+" 삭제됨");
		allProfileList();
	}
	
	//로그아웃 & 종료 & 입력받기===============================================
	public void logout() {//로그아웃
		session = "logout";
		System.out.println("로그아웃 되었습니다..");
	}
	public void programExit() {	//종료
		System.out.println("프로그램이 종료되었습니다..");
		System.exit(0);
	}
	
	public String inData(String msg) {	//입력
		System.out.print(msg+"->");
		return scan.nextLine();
	}
	//책목록 출력=============================================
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
		if(menu == 1) { // 대여
			BookVO vo = BookDataSet.bookList.get(pic);
			vo.setBookStatus(memberName);
		}else if(menu == 2) { //반납
			BookVO vo = BookDataSet.rentalBookList.get(pic);
			vo.setBookStatus("보유중");
		}
	}
	
	//회원정보 수정
	public void profileUpdate() {
		String profileUpdateTitle = "[1.비밀번호, 2.이름, 3.전화번호, 4.가입일, 5.대여권수, 6.선불금액, 7.완료]";
		boolean flag = true;
		do {
			allProfileList();
			String pic = inData("수정할 회원 아이디");
			if(ProfileDataSet.profileList.containsKey(pic)) {
				ProfileVO vo = ProfileDataSet.profileList.get(pic);
				do {
					try {
						int menu = Integer.parseInt(inData(profileUpdateTitle));
						if(menu == 1) {//비밀번호 수정
							vo.setMemberPwd(inData("수정할 비밀번호"));
						}else if(menu == 2) {//이름 수정
							vo.setName(inData("수정할 이름"));					
						}else if(menu == 3) {//전화번호 수정
							vo.setTel(inData("수정할 전화번호"));
						}else if(menu == 4) { //가입날짜 수정
							vo.setSince(inData("수정할 가입일"));
						}else if(menu == 5) {//대여권수 수정
							vo.setRentalCnt(Integer.parseInt(inData("수정할 대여권수")));
						}else if(menu == 6) {//선금 수정
							vo.setMoney(Integer.parseInt(inData("수정할 선불금액")));
						}else if(menu == 7) {
							System.out.println("수정완료");
							flag = false;
						}	
						allProfileList();
					}catch(NumberFormatException nfe) {
						System.out.println("잘못입력하셨습니다. 숫자로 입력해주세요.");
					}
				}while(flag);
			}else {
				System.out.println("없는 아이디 입니다. 다시 입력하세요");
			}
		}while(flag);
	}
	
	//책정보 수정
	public void bookUpdate() {
		String bookUpdateTitle = "[1.상태, 2.대여비, 3.대여일, 4.수정완료]";
		boolean flag = true;
		do {
			allBookList();
			String pic = inData("수정할 책 제목");
			if(BookDataSet.bookList.containsKey(pic)) {
				BookVO vo = BookDataSet.bookList.get(pic);
				do {
					try {
						int menu = Integer.parseInt(inData(bookUpdateTitle));
						if(menu == 1) {//상태
							vo.setBookStatus(inData("수정할 책 상태"));
						}else if(menu == 2) {//대여비
							vo.setRentalFee(Integer.parseInt(inData("수정할 책 대여비")));					
						}else if(menu == 3) {//대여일
							vo.setRentalDate(Integer.parseInt(inData("수정할 책 대여일")));
						}else if(menu == 4) {//수정완료
							System.out.println("수정완료");
							flag = false;
						}	
						allBookList();
					}catch(NumberFormatException nfe) {
						System.out.println("잘못입력하셨습니다. 숫자로 입력해주세요.");
					}
				}while(flag);
			}else {
				System.out.println("목록에 없는 책입니다. 다시 입력하세요");
			}
		}while(flag);
	}
}
