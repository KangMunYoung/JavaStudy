import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		
		//File : ���ϰ�ο� ���ϸ����� ��ü�� �����Ͽ� ��ü�� ������ ������ �ִ�.
		File f1 = new File("C://mypro/testFile");
		File f2 = new File("C:\\mypro");
		File f3 = new File("C:\\mypro/testFile/MultiplicationTable.java");
		File f4 = new File("C:\\mypro/testFile","multiplicationTable.java");
		File f5 = new File(f1,"MultiplicationTable.java");
		
		File f6 = new File("C://mypro/testFile/createJava");
		//���������ϱ�
		if(!f6.exists()){//������������Ȯ�� ������(true), ������(false)
			if(f6.mkdir()) { //���������ϱ� ������(true) ��������(false)
				System.out.println("������ �����Ǿ����ϴ�");
			}else{
				System.out.println("�������� �����Ͽ����ϴ�..");
			}
		}
		
		try {
			//���� �����ϱ�
			File f7 = new File(f6,"abcd.txt");
			
			if(!f7.exists()) {
				if(f7.createNewFile()) {
					System.out.println("�����̻����Ǿ����ϴ�.");
				}else {
					System.out.println("���ϻ�������");
				}
			}
			//������������
			long lastDate = f3.lastModified();
			System.out.println("lastDate->"+lastDate);
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(lastDate);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			System.out.println("lastDate="+now);
			String modifiedDate = sdf.format(now.getTime());
			System.out.println("������ ������"+modifiedDate);
			
			
			boolean exe = f5.canExecute();//������ ��������Ȯ��
			boolean read = f5.canRead();//�бⰡ��
			boolean write = f5.canWrite();//���Ⱑ��
			System.out.println(exe+":"+read+":"+write);
			
			/*
			 * getPath() : ������ + ���ϸ�
			 * getName() : ���ϸ�
			 * getAbsolutePath(): ������+���ϸ�
			 * getParent() : ������
			 * 
			 */
			//Ư������̺� Ȥ�� ������ �ִ� ���� �� �������� ������
			File f8 = new File("C://");
			File[] fileList = f8.listFiles();
			for(File f :fileList) {
				if(f.isDirectory()){//�������� Ȯ��
					System.out.print(f.getPath());
					if(f.isHidden()) {
						System.out.println("[��������]");
					}else {
						System.out.println("[����]");
					}
					
				}else if(f.isFile()) {
					System.out.print(f.getPath());
					if(f.isHidden()) {
						System.out.println("[��������]");
					}else {
						System.out.println("[����]");
					}
				}
			}
			
			//���� �ý����� ����̺긦 ���Ѵ�
			File[] root = File.listRoots();
			for(File ff: root) {
				System.out.println(ff.getPath());
			}
			
			
			//����ũ��: byte
			long size = f3.length();
			System.out.println("siz="+size);
			
			//���ϻ���
			boolean result= f3.delete();
			if(result) {
				System.out.println("�����̻���");
			}else {
				System.out.println("���� ���� ����");
			}
		}catch(IOException i) {
			i.printStackTrace();
		}
		System.out.println("~~~~");
	}

	public static void main(String[] args) {
		new FileTest();
	}

}
