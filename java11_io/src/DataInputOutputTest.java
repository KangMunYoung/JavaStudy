import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {

	public DataInputOutputTest() {
		try {
			//기본데이터형의 값을 파일로 저장하기
			File file = new File("C://mypro/testFile", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			int num = 1234;
			double data2 = 5628.34;
			boolean boo = true;
			char lastName = '홍';
			
			dos.writeInt(num);//4byte
			dos.writeDouble(data2);//8byte
			dos.writeBoolean(boo);//1byte
			dos.writeChar(lastName);//2byte
			
			dos.close();
			fos.close();
			
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일이 없어요...");
		}catch(IOException ie) {
			System.out.println("파일쓰기에러.....");
		}
	}

	public static void main(String[] args) {
		new DataInputOutputTest();
	}

}
