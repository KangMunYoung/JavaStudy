import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInputStreamTest {

	public FileInputStreamTest() {
		try {
		//파일의 내용을 읽어 파일로 출력하기
		File srcFile = new File("c://mypro/testFile/createJava/Calendar.java");
		File tarFile = new File("c://mypro/testFile/CalendarTest.java");
		
		FileReader fr = new FileReader(srcFile);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(tarFile);
		
		while(true) {
			String str = br.readLine();
			// 읽은값이 없을떄 null
			if(str == null)break;
			fw.write(str+"\n");
			System.out.println(str);
		}
		fw.close();
		br.close();
		fr.close();
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileInputStreamTest();
	}

}
