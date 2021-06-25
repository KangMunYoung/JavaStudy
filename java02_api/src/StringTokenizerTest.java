import java.util.StringTokenizer;

public class StringTokenizerTest {

	public StringTokenizerTest() {
		String txt="�����, ������, �ż���. �ű�����, 3��, ��Ʈķ��, ��������";
		
		StringTokenizer st = new StringTokenizer(txt,",.");
		int tokenCount = st.countTokens();
		System.out.println("token count = "+ tokenCount);
		
		while(st.hasMoreElements()){
			String token = st.nextToken();
			System.out.println(token);
		}
	}

	public static void main(String[] args) {
		new StringTokenizerTest();
	}

}
