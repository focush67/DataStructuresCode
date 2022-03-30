package TemporaryCodes;
import java.util.*;
public class ty 
{
	static class Node
	{
		int num;
		int index;
		public Node(int num,int index)
		{
			this.num = num;
			this.index = index;
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			Deque<Node> pq = (Deque<Node>) new PriorityQueue<Node>();
			ArrayList<Integer> list = new ArrayList<>();
			int n = sc.nextInt();
			int k = sc.nextInt();
			int A[] = new int[n];
			for(int i=0;i<n;i++)
			{
				A[i] = sc.nextInt();
				pq.offer(new Node(A[i],i));
			}
			
			int index = -1;
			int num = -1;
			while(!pq.isEmpty() && k!=0)
			{
				Node temp = pq.getLast();
				num = temp.num;
				index = temp.index;
				
			}
			
		}
		
	}

}
