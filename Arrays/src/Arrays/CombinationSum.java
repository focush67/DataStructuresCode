package Arrays;
import java.util.*;
public class CombinationSum 
{
	static List<List<Integer>> list = new ArrayList<>();
	public static void findComb(int nums[] , int target)
	{
		helper(nums,target,0,new ArrayList<>(),list);
	}
	
	public static void helper(int nums[] , int target , int start , ArrayList<Integer> temp , List<List<Integer>> list)
	{
		if(target == 0)
		{
			list.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=start;i<nums.length;i++)
		{
			int x = nums[i];
			if(x <= target)
			{
				temp.add(x);
				helper(nums,target-x,i,temp,list);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String ags[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}
		
		System.out.println("\nYOUR ARRAY");
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		
		System.out.println("ENTER TARGET SUM");
		int tar = sc.nextInt();
		findComb(nums,tar);
		System.out.println("YOUR REQUIRED WAYS");
		for(List<Integer> el : list)
		{
			System.out.println(el);
		}
		
	}
}
