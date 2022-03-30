package LoveBabbarDSA_Sheet;
import java.util.*;
public class minimiseHeights2 
{
	public static int minimum(int nums[] , int k)
	{
		Arrays.sort(nums);
		int n = nums.length;
		int x = nums[nums.length-1] - nums[0]; 
		int sm = nums[0]+k;
		int la = nums[nums.length-1]-k;
		int mi,ma;
		for(int i=1;i<n-1;i++)
		{
			mi = Math.min(sm, nums[i+1]-k);
			ma = Math.max(la, nums[i]+k);
			if(mi < 0)
				continue;
			x = Math.min(x, ma-mi);
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN ARRAY : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			arr[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("ENTER VALUE OF K");
		int k = sc.nextInt();
		int x = minimum(arr,k);
		System.out.println(x);

	}

}
