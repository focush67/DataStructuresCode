package LoveBabbarDSA_Sheet;
import java.util.*;
public class UnionIntersection 
{
	public static void union(int a[] , int b[])
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p1 = 0;
		int p2 = 0;
		while(p1 < a.length && p2 < b.length)
		{
			if(a[p1] == b[p2])
			{
				list.add(a[p1]);
				
			}
			
			else
			{
				list.add(a[p1]);
				list.add(b[p2]);
			}
			
			p1++;
			p2++;
		}
		
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void intersection(int a[] , int b[])
	{
		int p1 = 0;
		int p2 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(p1 < a.length && p2 < b.length)
		{
			if(a[p1] == b[p2])
				list.add(a[p1]);
			p1++;
			p2++;
		}
		
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF ELEMENTS IN FIRST ARRAY : ");
		int m = sc.nextInt();
		int a[] = new int[m];
		System.out.println("ENTER NUMBER OF ELEMENTS IN SECOND ARRAY : ");
		int n = sc.nextInt();
		int b[] = new int[n];
		System.out.println("ENTER ELEMENTS IN FIRST ARRAY : ");
		for(int i=0;i<m;i++)
		{
			a[i] = sc.nextInt();
		}
		//System.out.println("\n");
		System.out.println("ENTER ELEMENTS IN SECOND ARRAY");
		for(int i=0;i<n;i++)
		{
			b[i] = sc.nextInt();
		}
		System.out.println("\n");
		for(int i=0;i<m;i++)
		{
			System.out.println(a[i]+" ");
		}
		System.out.print("\n");
		
		for(int i=0;i<n;i++)
		{
			System.out.println(b[i]+" ");
		}
		System.out.print("\n");
		
		union(a,b);
		intersection(a,b);
		
	}

}
