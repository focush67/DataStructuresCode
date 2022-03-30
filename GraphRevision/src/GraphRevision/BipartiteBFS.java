package GraphRevision;
import java.util.*;
public class BipartiteBFS 
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
	
	public static void addEdge(int u,int v,boolean b)
	{
		graph[u].add(v);
		if(b)
			graph[v].add(u);
	}
	
	public static boolean bipartite(int st , int color[])
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		color[st] = 1;
		while(!q.isEmpty())
		{
			int t = q.poll();
			for(int el : graph[t])
			{
				if(color[el] == -1)
				{
					color[el] = 1-color[t];
					q.offer(el);
				}
				
				else if(color[el] == color[t])
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean check(int v)
	{
		int color[] = new int[v+1];
		Arrays.fill(color, -1);
		for(int i=1;i<=v;i++)
		{
			if(color[i] == -1)
			{
				if(bipartite(i,color))
					return true;
			}
		}
		
		return false;
	}

}
