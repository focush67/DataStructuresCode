package Dynamic_Programming;
import java.util.*;
public class BestTimeToBuySellStock 
{
	public static int maxProfit(int prices[])
	{
		int n = prices.length;
        if(n <= 1) return 0;
        int dp[] = new int[n];
        
        dp[0] = 0;
        dp[1] = prices[1] - prices[0];
        int max = Integer.MIN_VALUE;
        for(int i=2;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int temp = prices[i] - prices[j];
                if(temp > max)
                {
                    max = temp;
                }
            }
            
            dp[i] = max;
        }
        
        return max<0?0:max;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER SIZE ");
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("ENTER ELEMENT");
			nums[i] = sc.nextInt();
		}
		
		System.out.println("YOUR ARRAY");
		for(int i=0;i<n;i++)
		{
			System.out.print(nums[i]+" ");
		}
		
		System.out.println();
		
		int j = maxProfit(nums);
		System.out.println("MAXIMUM PROFIT : "+j);
	}

}
