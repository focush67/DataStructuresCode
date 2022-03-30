package Arrays;
import java.util.*;
public class Longest_Cycle_In_Array {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE");
		int n = sc.nextInt();
		int nums[] = new int[n+1];
		for(int i=1;i<=n;i++)
			nums[i] = sc.nextInt();
		
		int res = 0;
		for(int i=1;i<=n;i++)
		{
			int start = nums[i];
			int c = 0;
			do {
				start = nums[start];
				c++;
			}while(start != nums[i]);
			res = Math.max(res, c);
		}
		
	System.out.println("MAXIMUM CYCLE LENGTH : "+res);
	
	}

}
