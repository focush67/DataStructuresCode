package Arrays;

import java.util.*;

public class searchInsertPosition 
{
	public static int insert(int nums[] , int val)
	{
		int n = nums.length;
		if(val >= nums[n-1])
			return n;
		if(val <= nums[0])
			return 0;
		
		int l = 0;
		int u = n-1;
		while(l <= u)
		{
			int mid = l + (u-l)/2;
			if(nums[mid] < val)
			{
				l = mid+1;
			}
			
			else if(nums[mid] > val)
			{
				u = mid-1;
			}
			
			else
				break;
		}
		
		return l;
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
		System.out.println("YOUR ARRAY");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println("\nENTER TARGET ELEMENT");
		int v = sc.nextInt();
		
		int ans = insert(arr,v);
		System.out.println("\nINSERT POSITION : "+ans);
	}

}
