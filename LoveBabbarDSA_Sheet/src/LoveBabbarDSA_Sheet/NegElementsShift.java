package LoveBabbarDSA_Sheet;
import java.util.*;
public class NegElementsShift 
{
	public static int[] shift(int nums[])
	{
		int n = nums.length;
		int l = 0;
		int h = n-1;
		while(l <= h)
		{
				
			if(nums[l] < 0 && nums[h] < 0)
				l++;
			else if(nums[l] > 0 && nums[h] > 0)
				h--;
			else if(nums[l] > 0 && nums[h] < 0)
			{
				int t = nums[l];
				nums[l] = nums[h];
				nums[h] = t;
				l++;
				h--;
			}
			
			else
			{
				l++;
				h--;
			}
		}
		
		return nums;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY :");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i] = sc.nextInt();
		}
		System.out.println("\n");
		
		for(int i=0;i<n;i++)
			System.out.print(nums[i]+" ");
		System.out.println("\n");
		
		shift(nums);
		for(int i=0;i<n;i++)
			System.out.print(nums[i]+" ");

	}

}
