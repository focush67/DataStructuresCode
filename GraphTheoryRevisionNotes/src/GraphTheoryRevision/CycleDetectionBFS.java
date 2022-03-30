package GraphTheoryRevision;
import java.util.*;
class Node
{
	int f;
	int s;
	public Node(int f , int s)
	{
		this.f = f;
		this.s = s;
	}
}
public class CycleDetectionBFS 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
			graph[i] = new ArrayList<>();
	}
	
	public static void addEdge(int u , int v)
	{
		graph[u].add(v);
		graph[v].add(u);
	}
	
	public static void display()
	{
		for(int i=1;i<graph.length;i++)
		{
			ArrayList<Integer> temp = graph[i];
			if(temp.size() == 0) {
				//System.out.println("EMPTY }");
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
			System.out.println("\n");
		}
	}
	
	public static boolean hasCycle(int start , boolean vis[])
	{
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(start,-1));
		vis[start] = true;
		while(!q.isEmpty())
		{
			int node = q.peek().f;
			int par = q.peek().s;
			q.remove();
			for(int x : graph[node])
			{
				if(!vis[x])
				{
					vis[x] = true;
					q.offer(new Node(x,node));
				}
				
				else if(par != x)
					return true;
			}
		}
		
		return false;
	}
	
	
}
