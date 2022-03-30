package GraphRevision;
import java.util.*;
class Node
{
	int val;
	int par;
	public Node(int val,int par)
	{
		this.val = val;
		this.par = par;
	}
}

public class CycleBFS 
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
	
	public static boolean hasCycle(int start , boolean vis[])
	{
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start,-1));
		vis[start] = true;
		while(!q.isEmpty())
		{
			int node = q.peek().val;
			int parent = q.peek().par;
			for(int el : graph[node])
			{
				if(!vis[el])
				{
					vis[el] = true;
					q.offer(new Node(el,node));
				}
				
				else if(parent != el)
					return true;
			}
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
				if(hasCycle(i,vis))
					return true;
			}
		}
		
		return false;
	}

}
