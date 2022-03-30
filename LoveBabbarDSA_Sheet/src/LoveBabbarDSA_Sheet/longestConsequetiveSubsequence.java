package LoveBabbarDSA_Sheet;
import java.util.*;
public class longestConsequetiveSubsequence 
{
	/*public static int longestCons(int nums[]) // Brute Force
	{
		Arrays.sort(nums);
		int max = 1;
		int n = nums.length;
		int a = 1;
		for(int i=0;i<n-1;i++)
		{
			if(nums[i+1] - nums[i] == 1)
				a++;
			if(i == n-1)
				max = Math.max(max, a);
			else
			{
				max = Math.max(max, a);
				a = 1;
			}
		}
		
		return max;
	}*/
	
	public static int longestConsOptimised(int nums[])
	{
		boolean hash[] = new boolean[100001];
		Arrays.fill(hash, false);
		for(int i=0;i<nums.length;i++)
		{
			hash[nums[i]] = true;
		}
		
		int max = -1;
		int x = 0;
		for(int i=0;i<hash.length;i++)
		{
			if(hash[i])
				x++;
			else
			{
				max = Math.max(max, x);
				x = 0;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN THE ARRAY : ");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY :");
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[i]+" ");
		}
		System.out.println("\n");
		
		//int m = longestCons(nums);
		int p = longestConsOptimised(nums);
		/*System.out.println("LENGTH OF LONGEST CONSEQUITIVE SUBSEQUENCE :" +m);*/
		System.out.println("OPTIMISED LENGTH OF LONGEST CONSEQUETIVE SUBSEQUENCE :" +p);

	}

}
