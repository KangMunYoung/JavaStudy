class PrintfTest
{
	public static void main(String[] args) 
	{
		//	format : ��������
		//	���� : %10d(Decimal) , �Ǽ� %10.3f , ���ڿ� %8s, %o(Octal:8����) , %x(Hex:16����),	%c(char)
		//	�����	:	\n,\t, \\, \", \'
		int num = 1234;
		System.out.printf("num������ ���� %10d�Դϴ�. \n", num);
		System.out.printf("������ \"����\" \t���\\��...\n\n");

		double num2 = 2548.23576;
		System.out.printf("num2=%10.3f�Դϴ�.\n", num2);

		String nameKor = "ȫ�浿";
		String nameEng = "hong";
		System.out.printf("�̸��� %-10s�̴�.\n", nameKor); // -���ʹ�ġ
		System.out.printf("�̸��� %10s�̴�.\n", nameKor);	//	�����ʹ�ġ

		int num3 = 12;
		System.out.printf("%d, %o, %x\n", num3, num3, num3);

		System.out.println('A'+'B');
	}
}
