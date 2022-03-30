package Dynamic_Programming;
import java.util.*;
public class CountingBitsLeetcode 
{
	public static void setBits(int n)
	{
		int dp[] = new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i] = setBits_1(i);
		}
		
		for(int i=0;i<dp.length;i++)
		{
			System.out.print(dp[i]+" ");
		}
		
		System.out.println();
		
	}
	
	public static int setBits_1(int n) // Brian Kenningham Algorithm (O(N log N) Time)
	{
		int c = 0;
		while(n > 0)
		{
			n = n & (n-1);
			c++;
		}
		
		return c;
	}
	
	public static void setBits_2(int n) // (O(N) Time)
	{
		int dp[] = new int[n+1];
		dp[0] = 0;
		for(int i=0;i<=n;i++)
		{
			dp[i] = dp[i/2] + i%2;
		}
		
		for(int i=0;i<dp.length;i++)
		{
			System.out.print(dp[i]+" ");
		}
		
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER A NUMBER ");
		int n = sc.nextInt();
		setBits(n);
		setBits_2(n);
	}

}
