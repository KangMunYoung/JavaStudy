/*
[3-2] �Ʒ��� �ڵ�� ����� ��µ� �ʿ��� �ٱ���(����)�� ���� ���ϴ� �ڵ��̴�. ���� ����� ���� 123���̰�
�ϳ��� �ٱ��Ͽ��� 10���� ����� ���� �� �ִٸ�, 13���� �ٱ��ϰ� �ʿ��� ���̴�. (1)�� �˸��� �ڵ带 �����ÿ�.
*/
class Exercise3_2 
{
	public static void main(String[] args) 
	{
		int numOfApples = 123;	// ����� ����
		int sizeOfBucket = 10;	// �ٱ����� ũ��(�ٱ��Ͽ� ���� �� �ִ� ����� ����)
		int numOfBucket = ((numOfApples % sizeOfBucket == 0 )? numOfApples / sizeOfBucket : (numOfApples / sizeOfBucket) + 1);	// ��� ����� ��µ� �ʿ��� �ٱ����� ��

		System.out.println("�ʿ��� �ٱ����� �� :"+numOfBucket);
	}
}
