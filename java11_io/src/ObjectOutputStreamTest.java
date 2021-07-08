import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

	public ObjectOutputStreamTest() {
		try {
			File f = new File("C://mypro/testFile/object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Memo memo = new Memo();
			
			oos.writeObject(memo);
			
			oos.close();
			fos.close();
			System.out.println("객체쓰기완료");
			
			
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		new ObjectOutputStreamTest();
	}

}
