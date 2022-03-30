package GraphRevision;
import java.util.*;
public class ShortestPath_UndirectedGraph 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<>();
		}
	}
	
	public static void addEdge(int u,int v)
	{
		graph[u].add(v);
	}
	
	public static void BFS(int src , int v)
	{
		int dis[] = new int[v+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<Integer>();
		dis[src] = 0;
		q.offer(src);
		while(!q.isEmpty())
		{
			int node = q.poll();
			for(int el : graph[node])
			{
				if(dis[node]+1 < dis[el])
				{
					dis[el] = dis[node]+1;
					q.offer(el);
				}
			}
		}
		
		for(int i=1;i<=v;i++)
			System.out.print(dis[i]+" ");
	}

}
