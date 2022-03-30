package GraphRevision;
import java.util.*;
public class CycleDFS 
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
	
	public static boolean hasCycle(int st,int par,boolean[] vis)
	{
		vis[st] = true;
		for(int el : graph[st])
		{
			if(!vis[el])
			{
				if(hasCycle(el,st,vis))
					return true;
			}
			
			else if(par != el)
				return true;
		}
		
		return false;
	}
	
	public static boolean check(int v)
	{
		boolean vis[] = new boolean[v+1];
		for(int i=1;i<=v;i++)
		{
			if(!vis[i])
			{
				if(hasCycle(i,-1,vis))
					return true;
			}
		}
		
		return true;
	}

}
