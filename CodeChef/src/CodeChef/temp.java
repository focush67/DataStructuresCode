package CodeChef;
import java.util.*;
public class temp {
	public static int numberOfMultiples(int low , int high , int rem , int k)
	{
		int c = 0;
		// Calculating first such number.
		while(low % k != rem) {
			low++;
		}
		// Now low has the first multiple of k that gives remainder rem
		
		// Calculating last such number
		while(high % k != rem) {
			high--;
		}
		
		int m = ((high-low)<k)?high-low+1:high-low;
		c = (m/k)+1;
		return c; 
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF TESTCASES");
		int t = sc.nextInt();
		while(t-->=0)
		{
			int n = sc.nextInt();
			int p = sc.nextInt();
			int k = sc.nextInt();
			
			if(p%k == 0)
			{
				System.out.println(p/k + 1+"\n");
				continue;
			}
			
			int rem = p%k;
			int c = 0;
			int x = 0;
			while(x < rem)
			{
				c = c + numberOfMultiples(0,n-1,p,k);
				x++;
			}
			
			int low = 0;
			while(low % k != rem)
			{
				low++;
			}
			
			if(low == p)
			{
				System.out.println(c+1 +"\n");
				continue;
			}
			
			while(low != p)
			{
				low+=k;
				continue;
			}
			
			System.out.println(c+1 +"\n");
		}
	}

}
