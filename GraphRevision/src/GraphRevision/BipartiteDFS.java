package GraphRevision;
import java.util.*;
public class BipartiteDFS
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
	
	public static boolean bipartite(int st,int color[])
	{
		if(color[st] == -1)
			color[st] = 1;
		
		for(int el : graph[st])
		{
			if(color[el] == -1)
			{
				color[el] = 1-color[st];
				if(!bipartite(el,color))
					return false;
			}
			
			else if(color[el] == color[st])
				return false;
		}
		
		return true;
	}

}
