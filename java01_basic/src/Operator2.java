class Operator2 
{
	public static void main(String[] args) 
	{
		//��Ʈ ������ : &, |, ^(XOR), ~ -> 2���� �����͸� �̿��� ������
		int a = 12;
		int b = 4;

		int result = a & b; //	true : 1, false : 0
		System.out.println("result = "+result);

		int result2 = a | b;
		System.out.println("result2="+result2);

		// XOR	: �ΰ��� �ٸ��� ��

		int result3 = a ^ b;
		System.out.println("result3="+result3);

		//	~ (����)
		//	������ �����͸� ȯ���ϴ� ��� : 2���� -> 1�Ǻ��� +1
		//	1�� ������ 0�� 1���� 1�� 0���� �ٲٴ� ���̴�.

		int result4 = ~a;	// -13
		System.out.println("a= " + a + ", result4=" + result4);


		// ����Ʈ ������ : ��Ʈ�� �̵�
		// << : ��Ʈ�� �������� �̵� *���
		// >>(��ȣ�� ä����), >>>(0���� ä����) : ��Ʈ�� ���������� �̵� /���


		int result5 = a << 2;	// �������� 2bit �̵� ������ 0���� ä�� 48 = 12*4
		System.out.println("result5 = " + result5);

		int result6 = a >> 2;	// ���������� 2bit �̵� ���ʿ� ���� �ڸ��� ��ȣ�� ä������. 3 12/4
		int result7 = result4 >> 2;	// -4
		System.out.println("result6 = " + result6 + ", result7 = " + result7);


		int result8 = result4 >>> 2;
		System.out.println("result4 = " + result4);
		System.out.println("result8=" + result8);
	}
}
