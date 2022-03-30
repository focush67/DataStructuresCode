package LoveBabbarDSA_Sheet;
import java.util.*;
public class largestSumContinguousSubarray 
{
	public static int operate(int nums[])
	{
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		int dp[] = new int[n];
		dp[0] = Math.max(nums[0], 0);
		for(int i=1;i<n;i++)
		{
			if(nums[i] < 0) {
				dp[i] = 0;
				continue;
			}
				
			dp[i] = Math.max(dp[i-1]+nums[i], dp[i-1]);
		}
		
		for(int i=0;i<n;i++)
		{
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN ARRAY : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		int x = operate(arr);
		System.out.println("MAXIMUM SUM CONTIGUOUS SUBARRAY SUM : "+x);
	}

}
