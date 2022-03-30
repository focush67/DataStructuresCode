package TemporaryCodes;
import java.util.*;
public class CodeChef
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int A[] = new int[n];
			int sa = 0;
			for(int i=0;i<n;i++)
			{
				A[i] = sc.nextInt();
				sa+=A[i];
			}
			
			int B[] = new int[n-1];
			int sb=0;
			for(int i=0;i<n-1;i++)
			{
				B[i] = sc.nextInt();
				sb+=B[i];
			}
			
			int diff = sb-sa;
			int x = Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				int temp = diff-A[i];
				if(temp>=(n-1) && temp%(n-1)== 0)
				{
					x = Math.min(x, temp/(n-1));
				}
			}
			
			System.out.println(x);
		}
	}
}
