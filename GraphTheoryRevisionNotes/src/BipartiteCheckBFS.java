package GraphTheoryRevision;
import java.util.*;
public class BipartiteCheckBFS 
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
	
	public static void addEdge(int src , int dest) // Undirected unweighed graph
	{
		graph[src].add(dest);
		graph[dest].add(src);
	}
	
	public static void display()
	{
		System.out.println("\n");
		for(int i=1;i<graph.length;i++)
		{
			ArrayList<Integer> temp = graph[i];
			if(temp.size() == 0) {
				System.out.println(i + "--> {EMPTY}"+"\n");
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
			System.out.print("}"+"\n");
			System.out.println(/*"\n"*/);
		}
	}
	
	public static boolean bipartite(int node , int color[])
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(node);
		color[node] = 1;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int element : graph[temp])
			{
				if(color[element] == -1) {
					color[element] = 1-color[temp];
					q.offer(element);
				}
				else if(color[element] == color[temp])
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean bipartiteUtil()
	{
		int n = graph.length;
		int color[] = new int[n];
		for(int i=1;i<n;i++)
		{
			color[i] = -1;
		}
		
		for(int i=1;i<n;i++)
		{
			if(color[i] == -1)
			{
				if(!bipartite(i,color))
					return false;
			}
		}
		
		return true;
	}
}
}
