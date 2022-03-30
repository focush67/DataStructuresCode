package LoveBabbarDSA_Sheet;
import java.util.*;
public class kadaneAlgorithm 
{
	public static int maxSubarraySum(int nums[])
	{
		int sum = Integer.MIN_VALUE;
		int a = 0;
		for(int i=0;i<nums.length;i++)
		{
			a = a + nums[i];
			sum = Math.max(sum, a);
			a = Math.max(a, 0);
		}
		
		return sum;
	}

	public static void main(String[] args)
	{
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
		int ans = maxSubarraySum(arr);
		System.out.println("MAXIMUM CONTIGUOUS SUBARRAY SUM : "+ans);
	}

}
