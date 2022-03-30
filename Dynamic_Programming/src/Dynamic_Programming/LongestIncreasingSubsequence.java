package Dynamic_Programming;
import java.util.*;
public class LongestIncreasingSubsequence 
{
	public static int LIS(int nums[])
	{
		int n = nums.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(nums[i] > nums[j])
				{
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		
		int result = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int nums[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}
		
		System.out.println("ORIGINAL ARRAY");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		System.out.println();
		
		int u = LIS(nums);
		System.out.println("LONGEST INCREASING SUBSEQUENCE IS OF LENGTH : "+u);
	}

}
