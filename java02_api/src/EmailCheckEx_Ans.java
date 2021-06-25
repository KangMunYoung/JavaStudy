import java.util.Scanner;

public class EmailCheckEx_Ans {
	
	String emailId="";
	
	public EmailCheckEx_Ans() {
		start();
	}

	public void start() {
		do {
			String email = inputEmail();
			if(emailCheck(email)) {
				//아이디 , 도메인분리 출력
				emailPrint(email);
			}else {
				errorMailMessage(email);
			}
			
		}while(true);
	}
	//이메일 도메인 분리하여 출력하기
	public void emailPrint(String email) {
		/*
		String emailSplit[] = email.split("@");
		System.out.println("아이디="+emailSplit[0]);
		System.out.println("도메인="+emailSplit[1]);
		*/
		int atMark = email.indexOf("@");
		String id = email.substring(0,atMark);
		String domain = email.substring(atMark+1);
		System.out.println("아이디="+id);
		System.out.println("도메인="+domain);
	}
	//이메일입력
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이메일입력= ");
		return scan.nextLine();
	}
	//이메일 정상 잘못 확인
	public boolean emailCheck(String email) {
		//정상 trun, 잘못 false
		//@: atmark
		int atMark = email.indexOf("@");
		int point = email.indexOf(".");
		
		if(atMark == -1 || point == -1 || atMark>point || point-atMark<=2) {
			return false;
		}else {
			return true;
		}
		
		
	}
	
	//잘못된 메일 메세진
	public void errorMailMessage(String email) {
		System.out.println(email+"은 잘못된 이메일 주소입니다.");
	}
	
	
	public static void main(String[] args) {
		new EmailCheckEx_Ans().start();
	}

}
/*
실행
이메일입력 = goguma@nate
이메일을 잘못입력하였습니다.

이메일입력 = goguma777.com
이메일을 잘못입력하였습니다.

이메일입력=goguama777@nate.com
아이디 = goguma777
도메인 = nate.com

이메일입력
*/
