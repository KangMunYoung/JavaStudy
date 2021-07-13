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
				System.out.println("�����ڷα���");
				adminMenu();
			}else if(session.equals("user")) {
				System.out.println("�α��� �Ǿ����ϴ�.");
				memberName = ProfileDataSet.profileList.get(id).getName();
		
				memberMenu();
			}
		}while(true);
	}
	
	public void firstMenu() {//�α���. ȸ������, ����
		boolean logResult = false;
		Login log = new Login();
		do {
			String menu = inData("�޴�[1.�α���, 2.ȸ������, 3.����]");
			if(menu.equals("1")) {//�α���
				id = inData("���̵�");
				String pwd = inData("��й�ȣ");
				logResult = log.loginCheck(id, pwd);
			}else if(menu.equals("2")) {//ȸ������
				logResult = signUp();
			}else if(menu.equals("3")) {//����
				programExit();
			}else {
				System.out.println("1~3���߿��� ����ּ���");
			}
		}while(!logResult);
	}

	//�޷�==============================================================
	public String nowDate() {	//�޷�
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(now.getTime());
	}
	//ȸ������=======================================================
	public boolean signUp() {	//ȸ������
		allProfileList();
		ProfileVO vo = new ProfileVO();
		vo.setMemberId(inData("���̵�"));
		vo.setMemberPwd(inData("��й�ȣ"));
		vo.setName(inData("�̸�"));
		vo.setTel(inData("��ȭ��ȣ"));
		vo.setSince(nowDate());
		do {
			boolean flag = true;
			try {
				vo.setMoney(Integer.parseInt(inData("����")));
			}catch(NumberFormatException nfe) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. �������� �Է����ּ���");
				flag = false;
			}
			if(flag) break;
		}while(true);
		ProfileDataSet.profileList.put(vo.getMemberId(), vo);
		allProfileList();
		return true;
	}
	
	//ȸ���޴�
	public void memberMenu() {
		String memberTitle = "�޴�[1.å�뿩, 2.å�ݳ�, 3.���ݳֱ�, 4.�α׾ƿ�, 5.����]";
		do {
			try {
				allBookList();
				rentalList();
				int money = ProfileDataSet.profileList.get(id).getMoney();
				int cnt = ProfileDataSet.profileList.get(id).getRentalCnt();
				System.out.println("�̸�: ["+memberName+"] ������->["+money+"] �뿩�Ǽ�->["+cnt+"]");
				int menu = Integer.parseInt(inData(memberTitle));
				if(menu == 1) {		//å �뿩
					rental(menu);
				}else if(menu == 2) {	// å �ݳ� 
					rental(menu);	
				}else if(menu == 3) {	//���� 
					memMoney();
				}else if(menu == 4) {	//�α׾ƿ� 
					logout();
				}else if(menu == 5) {	//���� 
					programExit();
				}
			}catch(NumberFormatException nfe) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}while(session.equals("user"));
	}
	//�����߰�
	public void memMoney() {
		ProfileVO vo = ProfileDataSet.profileList.get(id);
		do {
			boolean flag = true;
			try {
				vo.setMoney(vo.getMoney()+Integer.parseInt(inData("�󸶸� �߰��Ͻðڽ��ϱ�?")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("�ݾ��� ���ڷ� �Է��� �ּ���.");
			}
			if(flag) break;
		}while(true);
	}
	
	//�뿩 & �ݳ�
	public void rental(int menu) { // �뿩 & �ݳ�
		String pick = inData("å ������ �Է����ּ���");
		if(BookDataSet.bookList.containsKey(pick) || BookDataSet.rentalBookList.containsKey(pick)) {
			BookVO vo = BookDataSet.bookList.get(pick);
			ProfileVO pvo = ProfileDataSet.profileList.get(id);
			
			if(menu == 1 && vo.getBookStatus().equals("������")) {	//�뿩
				statusUpdate(pick, menu);
				BookDataSet.rentalBookList.put(vo.getBookName(), vo);
				pvo.setMoney(pvo.getMoney() - vo.getRentalFee());
				pvo.setRentalCnt(pvo.getRentalCnt()+1);
			}else if(menu == 2) {	//�ݳ�
				statusUpdate(pick, menu);
				BookDataSet.bookList.put(vo.getBookName(), vo);
				BookDataSet.rentalBookList.remove(pick);
			}else {
				System.out.println("�뿩�Ҽ� ���� å�Դϴ�.");
			}
		}else {
			System.out.println("��Ͽ� ���� å�Դϴ�.");
		}
	}
	//�뿩�� ���
	public void rentalList() {
		Collection<BookVO> rentalList = BookDataSet.rentalBookList.values();
		Iterator<BookVO> ii = rentalList.iterator();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("�Ʒ��� �뿩���� �׸��Դϴ�.-----------------------------------------------------");
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
	
	//������ �޴�==================================================================
	public void adminMenu() {
		String adminTitle = "������ �޴�[1.å���, 2.å����, 3.å���, 4.ȸ�����, 5.ȸ�����, 6.ȸ������, 7.ȸ������ ���� 8.å���� ���� 9.�α׾ƿ�, 10.����]";
		
		do {
			try {
				int menu = Integer.parseInt(inData(adminTitle));
				if(menu == 1) {	//å���
					addBook(); 
				}else if(menu == 2) {	//å����
					delBook(); 
				}else if(menu == 3) {	//å���
					allBookList(); rentalList();
				}else if(menu == 4) {	//ȸ�����
					signUp(); 
				}else if(menu == 5) {	//ȸ�����
					allProfileList();
				}else if(menu == 6) {	//ȸ������
					delProfile(); 
				}else if(menu == 7) {	//ȸ������ ����
					profileUpdate();
				}else if(menu == 8) {	//å ���� ����
					bookUpdate();
				}else if(menu == 9) {	//�α׾ƿ�
					logout();
				}else if(menu == 10) {	//����
					programExit();
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println("�߸��Է��ϼ̽��ϴ�. 1~8�߿��� �������ּ���.");
			}
		}while(session.equals("admin"));
	}
	//å �߰�===========================================================
	public void addBook() {
		allBookList();
		BookVO vo = new BookVO();
		vo.setBookName(inData("����"));
		vo.setGenre(inData("�帣"));
		do {
			boolean flag = true;
			try {
				vo.setRentalFee(Integer.parseInt(inData("�뿩��")));
				vo.setRentalDate(Integer.parseInt(inData("�뿩��")));
			}catch(NumberFormatException nfe) {
				flag = false;
				System.out.println("�߸��Է� �ϼ̽��ϴ�. ���ڷ� �Է��ϼ���");
			}
			if(flag) break;
		}while(true);
		BookDataSet.bookList.put(vo.getBookName(), vo);
		allBookList(); 
	}
	
	//å ����============================================================
	public void delBook() {
		allBookList();
		BookDataSet.bookList.remove(inData("������ å����"));
		allBookList();
	}
	
	//ȸ�� ���====================================================
	public void allProfileList() {
		Collection<ProfileVO> list = ProfileDataSet.profileList.values();
		Iterator<ProfileVO> ii = list.iterator();
		ProfileVO.profileTitlePrint();
		while(ii.hasNext()) {
			ProfileVO vo = ii.next();
			vo.profilePrint();
		}
	}
	//ȸ������=============================================================
	public void delProfile() {
		allProfileList();
		String delName = inData("������ ���̵�");
		ProfileDataSet.profileList.remove(delName);
		System.out.println(delName+" ������");
		allProfileList();
	}
	
	//�α׾ƿ� & ���� & �Է¹ޱ�===============================================
	public void logout() {//�α׾ƿ�
		session = "logout";
		System.out.println("�α׾ƿ� �Ǿ����ϴ�..");
	}
	public void programExit() {	//����
		System.out.println("���α׷��� ����Ǿ����ϴ�..");
		System.exit(0);
	}
	
	public String inData(String msg) {	//�Է�
		System.out.print(msg+"->");
		return scan.nextLine();
	}
	//å��� ���=============================================
	public void allBookList() {
		Collection<BookVO> bookList = BookDataSet.bookList.values();
		Iterator<BookVO> ii = bookList.iterator();
		BookVO.bookTitlePrint();
		while(ii.hasNext()) {
			BookVO vo = ii.next();
			vo.bookPrint();
		}
	}
	
	//��������===========================================================
	public void statusUpdate(String pic, int menu) {//���¼���
		if(menu == 1) { // �뿩
			BookVO vo = BookDataSet.bookList.get(pic);
			vo.setBookStatus(memberName);
		}else if(menu == 2) { //�ݳ�
			BookVO vo = BookDataSet.rentalBookList.get(pic);
			vo.setBookStatus("������");
		}
	}
	
	//ȸ������ ����
	public void profileUpdate() {
		String profileUpdateTitle = "[1.��й�ȣ, 2.�̸�, 3.��ȭ��ȣ, 4.������, 5.�뿩�Ǽ�, 6.���ұݾ�, 7.�Ϸ�]";
		boolean flag = true;
		do {
			allProfileList();
			String pic = inData("������ ȸ�� ���̵�");
			if(ProfileDataSet.profileList.containsKey(pic)) {
				ProfileVO vo = ProfileDataSet.profileList.get(pic);
				do {
					try {
						int menu = Integer.parseInt(inData(profileUpdateTitle));
						if(menu == 1) {//��й�ȣ ����
							vo.setMemberPwd(inData("������ ��й�ȣ"));
						}else if(menu == 2) {//�̸� ����
							vo.setName(inData("������ �̸�"));					
						}else if(menu == 3) {//��ȭ��ȣ ����
							vo.setTel(inData("������ ��ȭ��ȣ"));
						}else if(menu == 4) { //���Գ�¥ ����
							vo.setSince(inData("������ ������"));
						}else if(menu == 5) {//�뿩�Ǽ� ����
							vo.setRentalCnt(Integer.parseInt(inData("������ �뿩�Ǽ�")));
						}else if(menu == 6) {//���� ����
							vo.setMoney(Integer.parseInt(inData("������ ���ұݾ�")));
						}else if(menu == 7) {
							System.out.println("�����Ϸ�");
							flag = false;
						}	
						allProfileList();
					}catch(NumberFormatException nfe) {
						System.out.println("�߸��Է��ϼ̽��ϴ�. ���ڷ� �Է����ּ���.");
					}
				}while(flag);
			}else {
				System.out.println("���� ���̵� �Դϴ�. �ٽ� �Է��ϼ���");
			}
		}while(flag);
	}
	
	//å���� ����
	public void bookUpdate() {
		String bookUpdateTitle = "[1.����, 2.�뿩��, 3.�뿩��, 4.�����Ϸ�]";
		boolean flag = true;
		do {
			allBookList();
			String pic = inData("������ å ����");
			if(BookDataSet.bookList.containsKey(pic)) {
				BookVO vo = BookDataSet.bookList.get(pic);
				do {
					try {
						int menu = Integer.parseInt(inData(bookUpdateTitle));
						if(menu == 1) {//����
							vo.setBookStatus(inData("������ å ����"));
						}else if(menu == 2) {//�뿩��
							vo.setRentalFee(Integer.parseInt(inData("������ å �뿩��")));					
						}else if(menu == 3) {//�뿩��
							vo.setRentalDate(Integer.parseInt(inData("������ å �뿩��")));
						}else if(menu == 4) {//�����Ϸ�
							System.out.println("�����Ϸ�");
							flag = false;
						}	
						allBookList();
					}catch(NumberFormatException nfe) {
						System.out.println("�߸��Է��ϼ̽��ϴ�. ���ڷ� �Է����ּ���.");
					}
				}while(flag);
			}else {
				System.out.println("��Ͽ� ���� å�Դϴ�. �ٽ� �Է��ϼ���");
			}
		}while(flag);
	}
}
