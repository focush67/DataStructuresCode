package LoveBabbarDSA_Sheet;
import java.util.*;
public class DutchNationalFlag 
{
	public static int [] sort(int nums[])
	{
		int l = 0;
		int m = 0;
		int h = nums.length-1;
		while(m <= h)
		{
			if(nums[m] == 1)
			{
				m++;
			}
			
			if(nums[m] == 0)
			{
				int t = nums[l];
				nums[l] = nums[m];
				nums[m] = t;
				l++;
				m++;
			}
			
			else
			{
				int t = nums[m];
				nums[m] = nums[h];
				nums[h] = t;
				h--;
				
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS : ");
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
		
		sort(nums);
		for(int i=0;i<n;i++)
			System.out.print(nums[i]+" ");

	}

}
