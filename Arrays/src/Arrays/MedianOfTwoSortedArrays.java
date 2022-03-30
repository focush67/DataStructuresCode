package Arrays;
import java.util.*;
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY 1");
		int m = sc.nextInt();
		int arr1[] = new int[m];
		for(int i=0;i<m;i++)
		{
			System.out.println("enter element in array 1 in sorted manner");
			arr1[i] = sc.nextInt();
		}
		
		System.out.println("ENTER SIZE OF ARRAY 2");
		int n = sc.nextInt();
		int arr2[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter element in array 2 in sorted manner");
			arr2[i] = sc.nextInt();
		}
		
		double ans = findMedian(arr1,arr2);
		System.out.println("ARRAY 1 \n:");
		display(arr1);
		System.out.println("ARRAY 2 \n:");
		display(arr2);
		System.out.println("REQUIRED MEDIAN :");
		System.out.println(ans);
	}
	
	public static void display(int nums[])
	{
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("\n");
	}
	
	public static double findMedian(int x[] , int y[])
	{
		int temp[] = new int[x.length + y.length];
		int l1=0,l2=0;
		int count=0;
		while(l1 < x.length && l2 < y.length)
		{
			if(x[l1] < y[l2])
			{
				temp[count++] = x[l1++];
			}
			
			else
			{
				temp[count++] = y[l2++];
			}
		}
		
		while(l1 < x.length)
			temp[count++] = x[l1++];
		while(l2 < y.length)
			temp[count++] = y[l2++];
		
		int size = x.length + y.length;
		if(size % 2 != 0)
		{
			int idx = (size-1)/2;
			double ans = (double)temp[idx];
			return ans;
		}
		
		else
		{
			double ans = temp[size/2] + temp[size/2 + 1];
			return ans/2.0;
		}
		
		
	}

}
