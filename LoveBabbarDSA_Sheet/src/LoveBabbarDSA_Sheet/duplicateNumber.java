package LoveBabbarDSA_Sheet;
import java.util.*;
public class duplicateNumber {
	public static int repeatedNumber(int nums[])
	{
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		slow = nums[0];
		while(slow != fast)
		{
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
	}

	public static void main(String[] args)
	{
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
		
		int m = repeatedNumber(arr);
		System.out.println("ONLY DUPLICATE NUMBER : "+m);

	}

}
