package LoveBabbarDSA_Sheet;
import java.util.*;
public class mergeIntevalss 
{
	public static int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int interval[] : intervals)
        {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0])
            {
                merged.add(interval);
            }
            
            else
            {
                merged.getLast()[1] = Math.max(merged.getLast()[1] , interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
        
    }
	
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF INTERVALS IN THE ARRAY ");
		int n = sc.nextInt();
		int nums[][] = new int[1][n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER INTERVAL :");
			nums[0][i] = sc.nextInt();
		}
		
		System.out.println("INTERVALS BEFORE MERGING :");
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[0][i]+" ");
		}
		
		System.out.println("\n");
		System.out.println("AFTER MERGING INTERVALS ARE");
		System.out.println("\n");
		nums = merge(nums);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[0][i]+" ");
		}
		System.out.println("\n");

		
	}

}
