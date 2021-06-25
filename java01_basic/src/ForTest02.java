class ForTest02 
{
	public static void main(String[] args) 
	{
		int sum=0;
		
		for(int i=1; i<=100; i++){
			sum+=i;
			if(i%10 == 0) //10의 배수
				System.out.println("1~"+i+"까지의 합은 "+sum);
		}
//		System.out.printf("%d\n",sum);
	}
}
