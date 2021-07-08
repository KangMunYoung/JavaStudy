import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		//���ϴ� ��ġ�� �����͸� �а� ���Ⱑ �����ϴ�.
		File f = new File("c://mypro/testFile/access.txt");
		try {
			//�������� w, �б����� r, �ϱ⾲�� rw
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java input ouput test programing";
			
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//������ ��ġ �̵�
			raf.seek(10);
			raf.writeBytes("hong");
			
			raf.seek(raf.length());
			byte[] data = {65,66,67,68};
			raf.write(data);
			
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();
	}

}