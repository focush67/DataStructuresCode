package TemporaryCodes;
import java.util.*;
public class DP 
{
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			String str = sc.next();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dp[] = new int[n];
			char q='\u0000';
			if(str.charAt(0) == 'N' || str.charAt(0) == 'S') {
				dp[0] = Math.min(x, y);
				q = str.charAt(0);
			}
			
			String ans="";
			char chars[] = str.toCharArray();
			if((dp[0] == x && q == 'S') || (dp[0] == y && q == 'N'))
				ans+='E';
			else if((dp[0] == y && q == 'S') || (dp[0] == x && q == 'N'))
				ans+='W';
			for(int i=1;i<chars.length;i++)
			{
				char ch = chars[i];
				char ch1 = chars[i-1];
				if(ch == 'E' || ch == 'W') {
					dp[i] = dp[i-1];
				}
				
				else
				{
					if(ch1 != 'W')
					{
						dp[i] = dp[i-1] + Math.min(x, y);
					}
				}
				
					
					
			}
		}
	}

}
