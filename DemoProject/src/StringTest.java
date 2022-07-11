
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str1= "Friendfr";
		
		String str2 = "Company";
		
		if (str1.equals(str2)) {
			System.out.println("equals");
		}
		else
			System.out.println("not equals");
			
		int strlen = str1.length();
		
		str1 = str1.toLowerCase();
		
		boolean flag = false;
		
		for (int i=0;i< strlen; i++)
		{
			if (str1.charAt(i) == 'a' )
			{	
				flag = true;
				break;
			}
			if (str1.charAt(i)== 'e')
			{
				flag = true;
				break;
			}
			if (str1.charAt(i)== 'i')
			{
				flag = true;
				break;
			}
			if (str1.charAt(i)== 'o')
			{
				flag = true;
				break;
			}
			if (str1.charAt(i)== 'u')
			{
				flag = true;
				break;
			}
		}
		
		if (flag) System.out.println("It has vowels");
		

		String revstr = "";
		for (int i = strlen-1; i>=0;i--)
		{
			revstr += str1.charAt(i);
		}
		
		System.out.println(revstr);
		
		StringBuilder strbuild = new StringBuilder();
		strbuild.append(str1);
		strbuild.reverse();
		System.out.println(strbuild);
		System.out.println("---------");

		
		String repStr = "Enemy";
		System.out.println(str1);
		String x = str1.replace("fr", repStr);
		System.out.println(x);
		
		if (str1.indexOf("end")==-1)
			System.out.println("Not found");
		else
			System.out.println("found");
		
		String sSplit = "1,2,3,4,5";
		String[] sArr = sSplit.split(",",-2);
		for (String a: sArr)
			System.out.println(a);
		
		
		
	}

}
