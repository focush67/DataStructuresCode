package Dynamc_Programming;
import java.util.*;
public class PossibleDecodings 
{
	public static void topDown(char [] str , int [] dp)
	{
		
	}
	
	public static void bottomUp(char [] str)
	{
		int n = str.length;
		int [] dp = new int[str.length];
		dp[0] = 1;
		dp[1] = 1;
		int a = (int)str[0] * 10;
		int b = (int)str[1];
		if(a+b <=26)
			dp[1]+=1;
		
		for(int i=2;i<str.length;i++)
		{
			int num = (int)str[i-1]*10 + (int)str[i];
			if(num <= 26)
			{
				dp[i] = dp[i-1] + dp[i-2];
			}
			
			else
			{
				dp[i] = dp[i-1] + 0;
			}
		}
		
		int x = dp[n-1];
		System.out.println("POSSIBLE NUMBER OF DECODINGS : "+x);
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER DECODED STRING");
		String str = sc.nextLine();
		System.out.println("YOUR ENTERED STRING : "+str);
		char ch[] = str.toCharArray();
		bottomUp(ch);
	}
	
}
