/*
[3-9] ������ ������ ���� oh�� ������(�빮�� �Ǵ� �ҹ���)�̰ų� ������ ���� ����b�� ���� true�� �ǵ��� �ϴ� �ڵ��̴�.
(1)�� �˸´� �ڵ带 �����ÿ�
*/
class Exercise3_9
{
	public static void main(String[] args) 
	{
		char ch = 'z';
		boolean b = ('a'<= ch && ch <='z' || 'A'<= ch && ch <='Z' || '0'<= ch && ch <= '9');

		System.out.println(b);
	}
}
