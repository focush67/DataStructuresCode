package GraphRevision;
import java.util.*;
public class ConnectedComponents 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
			graph[i] = new ArrayList<>();
	}
	
	public static void addEdge(int u , int v , boolean f)
	{
		graph[u].add(v);
		if(f)
			graph[v].add(u);
	}
	
	public static void BFS(int st , boolean vis[])
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		vis[st] = true;
		while(!q.isEmpty())
		{
			int t = q.poll();
			for(int el : graph[t])
			{
				if(!vis[el])
				{
					vis[el] = true;
					q.offer(el);
				}
			}
		}
	}
	
	public static void connComp(int v)
	{
		int c=0;
		boolean vis[] = new boolean[v+1];
		for(int i=1;i<=v;i++)
		{
			if(!vis[i])
			{
				c++;
				BFS(i,vis);
			}
		}
		
		System.out.println("NUMBER OF CONNECTED COMPONENTS : "+c);
	}

}
