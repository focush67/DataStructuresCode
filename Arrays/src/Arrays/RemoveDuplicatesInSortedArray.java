package Arrays;
import java.util.*;
public class RemoveDuplicatesInSortedArray 
{
	public static int remove(int nums[])
	{
		int i = 0;
		for(int j=1;j<nums.length;j++)
		{
			if(nums[i] != nums[j])
			{
				i++;
				nums[i] = nums[j];
			}
		}
		
		int x = i+1;
		System.out.println("\nAFTER REMOVING DUPLICATES");
		for(int m=0;m<x;m++)
			System.out.print(nums[m]+" ");
		System.out.println();
		return x;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF THE ARRAY");
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
		
		int z = remove(arr);
		System.out.println("NUMBER OF UNIQUE ELEMENTS");
		System.out.println(z);
	}

}
