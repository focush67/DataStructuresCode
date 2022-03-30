package LoveBabbarDSA_Sheet;
import java.util.*;
public class subarrayWithZeroSum 
{
	public static boolean zeroSum(int nums[] , int n)
	{
		int s = 0;
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i=0;i<n;i++)
		{
			s = s + nums[i];
			if(nums[i] == 0 || s == 0 || hset.contains(s))
				return true;
			hset.add(s);
		}
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY :");
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
		
		boolean f = zeroSum(nums,n);
		if(f)
			System.out.println("ZERO SUM SUBARRAY EXISTS");
		else
			System.out.println("NO ZERO SUM SUBARRAY EXISTS");

	}

}
