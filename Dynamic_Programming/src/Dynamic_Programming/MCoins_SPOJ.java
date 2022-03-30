package Dynamic_Programming;
import java.util.*;
public class MCoins_SPOJ 
{
	static boolean dp[] = new boolean[1000005];
	public static void winningState( int l , int k)
	{
		dp[1] = true;
		dp[k] = true;
		dp[l] = true;
		for(int i=2;i<1000005;i++)
		{
			dp[i] = dp[i-1] && (i-k>=0 ? dp[i-k]:true) && (i-l>=0 ?dp[i-l]:true);
			dp[i] = !dp[i];
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF TESTCASES");
		int t = sc.nextInt();
		List<String> list = new ArrayList<>();
		int w = 1;
		System.out.println("ENTER VALUES OF k and l");
		int k = sc.nextInt();
		int l = sc.nextInt();
		winningState(l,k);
		while(t-->0)
		{
			System.out.println("ENTER NUMBER "+(w++)+" :");
			int x = sc.nextInt();
			if(dp[x])
				list.add("Alice");
			else
				list.add("Bob");
		}
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}

}
