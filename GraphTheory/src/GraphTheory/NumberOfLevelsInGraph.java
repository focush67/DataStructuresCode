package GraphTheory;
import java.util.*;
public class NumberOfLevelsInGraph 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<Integer>();
		}
	}
	
	public static void addEdge(int src , int dest)
	{
		graph[src].add(dest);
		graph[dest].add(src);
	}
	
	public static void display()
	{
		for(int i=1;i<graph.length;i++)
		{
			System.out.print(i+" { ");
			if(graph[i].isEmpty())
			{
				System.out.println("EMPTY }");
				continue;
			}
			
			for(int element : graph[i])
			{
				System.out.print(element+" " +", ");
				
			}
			
			System.out.println(" }");
			System.out.println("\n");
		}
	}
	
	public static int numberOfNodes(int src , int level)
	{
		boolean vis[] = new boolean[graph.length];
		vis[src] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		int curr = 1;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int neigh : graph[temp])
			{
				if(!vis[neigh])
				{
					vis[neigh] = true;
					q.offer(neigh);
				}
			}
			
			if(curr == level)
				return q.size();
			else
				++curr;
		}
		
		return -1;
		
	}
	
	public static void main(String h[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		while(e!=0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			addEdge(src,dest);
			--e;
		}
		
		display();
		System.out.println("ENTER LEVEL YOU WANT NUMBER OF NODES OF");
		int l = sc.nextInt();
		System.out.println("ENTER SOURCE");
		int s = sc.nextInt();
		int ans = numberOfNodes(s,l);
		System.out.println("\n"+ans);
	}

}
