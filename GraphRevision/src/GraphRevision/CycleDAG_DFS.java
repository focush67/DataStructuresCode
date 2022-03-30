package GraphRevision;
import java.util.*;
public class CycleDAG_DFS 
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
	
	public static boolean cycleDAG(int st , boolean vis[] , boolean dfs[])
	{
		vis[st] = true;
		dfs[st] = true;
		for(int el : graph[st])
		{
			if(!vis[el])
			{
				if(cycleDAG(el,vis,dfs))
					return true;
			}
			
			else if(dfs[el])
				return true;
		}
		
		dfs[st] = false;
		return false;
	}
	
	public static boolean check(int v)
	{
		boolean vis[] = new boolean[v+1];
		boolean dfsvis[] = new boolean[v+1];
		for(int i=1;i<=v;i++)
		{
			if(!vis[i])
			{
				if(cycleDAG(i,vis,dfsvis))
					return true;
			}
		}
		
		return false;
	}

}
