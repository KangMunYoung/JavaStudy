class  Mytest
{
	public static void main(String[] args) 
	{
		int kor1 = 10;
		int kor2 = 20;
		int kor3 = 30;
		int kor4 = 40;
		System.out.println("hahahahahaha");
		
		if (kor1 > kor2)
		{
			int kor34 = kor3 + kor4;
			System.out.println(kor34);
		}
		else
		{
			int kor23 = kor2 + kor3;
			System.out.println(kor23);
		}
	
		
		String str1 = new String("aaa");
		String str2 = str1;
		String str3 = new String("aaa");
		String str4 = "aaa";
		String str5 = "aaa";

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
		System.out.println(str4 == str5);

	}
}
