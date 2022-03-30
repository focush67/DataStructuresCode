package Arrays;
import java.util.*;
public class removeElement 
{
	public static int remove(int nums[] , int val)
	{
		int i=0;
		for(int j=1;j<nums.length;j++)
		{
			if(nums[j] != val)
			{
				nums[i] = nums[j];
				++i;
			}
		}
		
		for(int x=0;x<=i;x++)
		{
			System.out.print(nums[x]+" ");
		}
		System.out.println();
		
		return i;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("EMTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("ORIGINAL ARRAY");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("ENTER VALUE YOU WANT DELETED");
		int v = sc.nextInt();
		int z = remove(arr,v);
		System.out.println("NUMBER OF UNIQUE ELEMENTS : "+z);
	}

}
