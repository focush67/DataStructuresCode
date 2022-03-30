package Dynamic_Programming;
import java.util.*;
public class Min_Cost_Climbing_Stairs 
{
	public static int minCostClimbingStairs(int nums[] , int n)
	{
		int dp[] = new int[n+1];
		for(int i=2;i<=n;i++)
		{
			int x = nums[i-1] + dp[i-1];
			int y = nums[i-2] + dp[i-2];
			dp[i] = Math.min(x, y);
		}
		
		return dp[n];
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		//Arrays.fill(dp, Integer.MAX_VALUE);
		int x = minCostClimbingStairs(arr,n);
		System.out.println(x);
	}

}
