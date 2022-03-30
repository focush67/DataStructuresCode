package Arrays; // still to be solved correctly
import java.util.*;
public class FirstAndLastPositionInSortedArray 
{
	public static int [] search(int nums[] , int target)
	{
		int idx1 = search(nums,0,nums.length-1,target);
		int n = nums.length;
		int idx2 = -1;
		int l=0;
		int h=n-1;
		if(l <= h)
		{
			int m = l + (h-l)/2;
			if((m == n-1 || target < nums[m+1]) && nums[m] == target)
			{
				idx2 = m;
				break;
			}
			
			else if(target < nums[m])
				h = m-1;
			else
				l = m+1;
		}
		
		return new int[] {idx1,idx2};
		
	}
	
	public static int search(int nums[] , int l , int u , int val)
	{
		if(l > u)
			return -1;
		
		if(l <= u)
		{
			int mid = l + (u-l)/2;
			if((mid == 0 || val > nums[mid-1]) && nums[mid] == val)
				return mid;
			else if(nums[mid] > val)
				return search(nums,mid+1,u,val);
			else
				return search(nums,l,mid-1,val);
			
		}
		
		return -1;
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
		
		int z[] = new int[2];
		z = search(arr,v);
		System.out.println("\nREQUIRED INDICES");
		for(int i=0;i<z.length;i++)
		{
			System.out.print(z[i]+" ");
		}
		
	}
}
