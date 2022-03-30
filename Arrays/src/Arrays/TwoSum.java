package Arrays;
import java.util.*;
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE OF ARRAY\n");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter element in array\n");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("ENTER REQUIRED SUM \n");
		int target = sc.nextInt();
		System.out.println("YOUR ARRAY\n");
		display(arr);
		int idx[] = new int[2];
		Arrays.fill(idx, -1);
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(map.containsKey(target-arr[i]))
			{
				idx[0] = map.get(target-arr[i]);
				idx[1] = i;
			}
			
			else
				map.put(arr[i], i);
		}
		
		System.out.println("YOUR REQUIRED INDICES\n");
		display(idx);
	}
	
	public static void display(int nums[])
	{
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+"\t");
		}
	}

}
