package codePractice;

public class javaCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
//	int x, y , row =5;
//	for (x=0; x<row; x++)
//	{
//		for(y=row-x; y > 1; y--) 
//		{
//			System.out.print(" ");
//		}
//		for(y=0; y<=x ; y++)
//		{
//			System.out.print("* ");
//		}
//		System.out.println();
//	}
//		
		

		int a =1;
		int x = 1;
		int y = 1;
		int count = 10;
		System.out.println(x);
		while (a < 10 )
		{
			int tmp = x+y; 
			System.out.println(tmp);
			x = y;
			y = tmp;
			a++;
		}
				
		
		
	}

}
