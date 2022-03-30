package AtCoderDP;
import java.util.*;
public class Frog_1
{
	public static int[] input(int nums[],int n)
	{
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<nums.length;i++)
		{
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}
		
		return nums;
	}
	
	public static void display(int nums[])
	{
		System.out.println("YOUR ARRAY");
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		System.out.println();
	}
	
	public static int frog1(int nums[])
	{
		if(nums.length == 1)
			return nums[0];
		
		int dp[] = new int[nums.length];
		dp[0] = 0;
		dp[1] = nums[1]-nums[0];
		if(dp[1] < 0)
			dp[1] = 1-dp[1];
		
		for(int i=2;i<nums.length-1;i++)
		{
			int one = (int)Math.abs(nums[i]-nums[i-1])+dp[i-1];
			int two = (int)Math.abs(nums[i]-nums[i-2])+dp[i-2];
			dp[i] = Math.min(one,two);
		}
		
		return dp[nums.length-1];
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE");
		int n = sc.nextInt();
		int nums[] = new int[n];
		input(nums,n);
		display(nums);
		int c = frog1(nums);
		System.out.println("MINIMUM COST : "+c);
	}

}
