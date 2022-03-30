package GraphRevision;
import java.util.*;
public class TopologicalDFS 
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
	
	public static void DFS(int node , boolean vis[] , Stack<Integer> st)
	{
		vis[node] = true;
		for(int el : graph[node])
		{
			if(!vis[el])
				DFS(el,vis,st);
		}
		
		st.push(node);
	}
	
	public static void toposort(int v)
	{
		Stack<Integer> st = new Stack<>();
		boolean vis[] = new boolean[v+1];
		for(int i=1;i<=v;i++)
		{
			if(!vis[i])
			{
				DFS(i,vis,st);
			}
		}
		
		while(!st.isEmpty())
			System.out.print(st.pop()+" ");
	}
	
	

}
