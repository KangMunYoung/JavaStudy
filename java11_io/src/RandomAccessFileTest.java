import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		//원하는 위치의 데이터를 읽고 쓰기가 가능하다.
		File f = new File("c://mypro/testFile/access.txt");
		try {
			//쓰기전용 w, 읽기전용 r, 일기쓰기 rw
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java input ouput test programing";
			
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//쓰기할 위치 이동
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
