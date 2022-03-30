package LoveBabbarDSA_Sheet;
import java.util.*;
public class tripletWithGivenSum 
{
	public static boolean isTriplet(int nums[] , int k)
	{
		int n = nums.length;
		int idx = -1;
		int x[] = new int[2];
		for(int i=0;i<n-1;i++)
		{
			if(isDoublet(nums,i+1,k-nums[i],x)) {
				idx = i;
				List<Integer> lis = new ArrayList<>();
				lis.add(nums[idx]);
				lis.add(nums[x[0]]);
				lis.add(nums[x[1]]);
				System.out.println(lis);
				return true;
			}
				
		}
		
		return false;
	}
	
	public static boolean isDoublet(int nums[] , int idx , int target , int x[])
	{
		HashMap<Integer,Integer> map = new HashMap();
		for(int i=idx;i<nums.length;i++)
		{
			if(map.containsKey(target-nums[i])) {
				x[0] = i;
				x[1] = map.get(target-nums[i]);
				return true;
			}
			map.put(nums[i], i);
		}
		
		return false;
	}

	public static void main(String[] args) {
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
		System.out.println("ENTER VALUE OF K");
		int k = sc.nextInt();
		boolean f = isTriplet(nums,k);
		if(f)
			System.out.println("TRIPLET WITH SUM "+k+" EXISTS");
		else
			System.out.println("TRIPLET DOES NOT EXIST");

	}

}
