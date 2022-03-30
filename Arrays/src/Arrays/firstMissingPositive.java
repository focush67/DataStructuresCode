package Arrays;
import java.util.*;
public class firstMissingPositive // To be optimized
{
	public static int find(int nums[])
	{
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<nums.length;i++)
		{
			list.add(nums[i]);
		}
		
		int c = 1;
		while(c < nums.length)
		{
			if(list.contains(c))
				c++;
			else
				break;
		}
		
		return c;
	}
	
	public static int seperate(int nums[])
	{
		int n = nums.length;
		int j = 0;
		for(int i=0;i<n;i++)
		{
			if(nums[i] < 0)
			{
				int temp;
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
		
		return j;
	}
	
	public static int findMissingPositive(int nums[] , int n)
	{
		for(int i=0;i<n;i++)
		{
			int x = (int)Math.abs(nums[i]);
			if(x-1 < n && nums[x-1] > 0)
				nums[x-1] = -nums[x-1];
		}
		
		for(int i=0;i<n;i++)
		{
			if(nums[i] > 0)
				return i+1;
		}
		
		return n+1;
	}
	
	public static int findMissing(int nums[] , int size)
	{
		int s = seperate(nums);
		int arr2[] = new int[size-s];
		int j = 0;
		for(int i=s ; i<size ; i++)
		{
			arr2[j] = nums[i];
			j++;
		}
		
		return findMissingPositive(nums,j);
	}
	
	public static void main(String ags[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}

		System.out.println("\nYOUR ARRAY");
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		int x = find(nums);
		System.out.println("FIRST MISSING POSITIVE NUMBER : "+x);
		
		int a = findMissing(nums,n);
		System.out.println("FIRST MISSING POSITIVE NUMBER : "+a);
	}

}
