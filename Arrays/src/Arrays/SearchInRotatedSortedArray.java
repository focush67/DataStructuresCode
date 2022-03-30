package Arrays;
import java.util.*;
public class SearchInRotatedSortedArray 
{
	public static int search(int nums[] , int target)
	{
		int n = nums.length;
		int last = nums[n-1];
		int first = nums[0];
		int idx = -1;
		for(int i=0;i<nums.length-1;i++)
		{
			if(nums[i] > nums[i+1])
			{
				idx = i;
				break;
			}
		}
		
		int y = (idx != -1)?nums[idx]:-1;
		if(y == -1)
			return -1;
		
		if(target == first) return 0;
		if(target == last) return n-1;
		if(target == y) return idx;
		
		if(first < target && target < y)
			return search(nums,0,idx,target);
		else 
			return search(nums,idx+1,n-1,target);
		
	}
	
	public static int search(int nums[] , int l , int u , int val)
	{
		if(l > u)
			return -1;
		
		while(l <= u)
		{
			int mid = l + (u-l)/2;
			int el = nums[mid];
			if(el < val)
				return search(nums,mid+1,u,val);
			else if(el > val)
				return search(nums,l,mid-1,val);
			else 
				return mid;
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
		
		int d = search(arr,v);
		System.out.println("REQUIRED INDEX : "+d);
	}

}
