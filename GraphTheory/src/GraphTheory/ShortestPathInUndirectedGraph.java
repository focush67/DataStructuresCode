package GraphTheory;
import java.util.*;
public class ShortestPathInUndirectedGraph 
{
	static ArrayList<Integer> graph[];
	@SuppressWarnings("unchecked")
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<>();
		}
	}
	
	public static void addEdge(int src , int dest) // Undirected Unweighed Graph
	{
		graph[src].add(dest);
	}
	
	public static void display()
	{
		System.out.println("\n");
		for(int i=1;i<graph.length;i++)
		{
			ArrayList<Integer> temp = graph[i];
			if(temp.size() == 0) {
				System.out.println(i + "--> {EMPTY}");
				continue;
			}
			else
			{
				System.out.print(i+" --> {");
			}
			for(int j=0;j<temp.size();j++)
			{
				if(j == temp.size()-1)
				System.out.print(temp.get(j));
				else
				System.out.print(temp.get(j)+",");
			}
			System.out.print("}");
			System.out.println(/*"\n"*/);
		}
	}
	
	public static void shortestPathUtil(int src , int dest , int vis[] , int par)
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		vis[src] = 0;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int el : graph[temp])
			{
				if(vis[temp]+1 < vis[el])
				{
					vis[el] = vis[temp] + 1;
					  q.offer(el);
				}
			}
		}
		
		for(int i=0;i<vis.length;i++)
			System.out.print(vis[i]+" ");
	}
	
	public static void shortestPath(int src , int dest)
	{
		int visited[] = new int[graph.length];
		Arrays.fill(visited, Integer.MAX_VALUE);
		shortestPathUtil(src , dest , visited , -1);
	}
	
	//@SuppressWarnings("unchecked")//
	@SuppressWarnings("resource")
	public static void main(String h[])
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			int src = sc.nextInt();
			int des = sc.nextInt();
			addEdge(src,des);
			--e;
		}
		
		display();
		System.out.println("ENTER SOURCE AND DESTINATION");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		shortestPath(source , destination);
	}
}
