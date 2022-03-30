package Dynamic_Programming;
import java.util.*;
public class RobberLoot
{
	public static int loot(int nums[])
	{
		int n = nums.length;
		int dp[] = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<n;i++)
		{
			dp[i] = Math.max(dp[i-1] , nums[i] + dp[i-2]);
		}
		return dp[n-1];
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
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
		System.out.println();
		
		int max = loot(arr);
		System.out.println("MAXIMUM PROFIT : "+max);
	}
}
