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
				//���̵� , �����κи� ���
				emailPrint(email);
			}else {
				errorMailMessage(email);
			}
			
		}while(true);
	}
	//�̸��� ������ �и��Ͽ� ����ϱ�
	public void emailPrint(String email) {
		/*
		String emailSplit[] = email.split("@");
		System.out.println("���̵�="+emailSplit[0]);
		System.out.println("������="+emailSplit[1]);
		*/
		int atMark = email.indexOf("@");
		String id = email.substring(0,atMark);
		String domain = email.substring(atMark+1);
		System.out.println("���̵�="+id);
		System.out.println("������="+domain);
	}
	//�̸����Է�
	public String inputEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸����Է�= ");
		return scan.nextLine();
	}
	//�̸��� ���� �߸� Ȯ��
	public boolean emailCheck(String email) {
		//���� trun, �߸� false
		//@: atmark
		int atMark = email.indexOf("@");
		int point = email.indexOf(".");
		
		if(atMark == -1 || point == -1 || atMark>point || point-atMark<=2) {
			return false;
		}else {
			return true;
		}
		
		
	}
	
	//�߸��� ���� �޼���
	public void errorMailMessage(String email) {
		System.out.println(email+"�� �߸��� �̸��� �ּ��Դϴ�.");
	}
	
	
	public static void main(String[] args) {
		new EmailCheckEx_Ans().start();
	}

}
/*
����
�̸����Է� = goguma@nate
�̸����� �߸��Է��Ͽ����ϴ�.

�̸����Է� = goguma777.com
�̸����� �߸��Է��Ͽ����ϴ�.

�̸����Է�=goguama777@nate.com
���̵� = goguma777
������ = nate.com

�̸����Է�
*/
