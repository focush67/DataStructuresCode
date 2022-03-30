package Dynamic_Programming;
import java.util.*;
public class RollingDice
{
	public static int roll(int num)
	{
		int n = num;
		int dp[] = new int[n+1];
		dp[n] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<=n;i++)
		{
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		return dp[n];
	}
	
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		/*System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("ORIGINAL ARRAY");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();*/
		System.out.println("ENTER NUMBER OF STAIRS");
		int num = sc.nextInt();
		int m = roll(num);
		System.out.println("POSSIBLE NUMBER OF WAYS : "+m);
	}

}
