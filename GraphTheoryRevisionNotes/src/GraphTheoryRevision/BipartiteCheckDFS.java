package GraphTheoryRevision;
import java.util.*;
public class BipartiteCheckDFS 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
			graph[i] = new ArrayList<Integer>();
	}
	
	public static void addEdge(int u,int v)
	{
		graph[u].add(v);
		graph[v].add(u);
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
	
	public static boolean bipartiteUtil(int start,int v)
	{
		int color[] = new int[v+1];
		Arrays.fill(color, -1);
		for(int i=1;i<=v;i++)
		{
			if(color[i] == -1)
			{
				if(!bipartite(color,i,0))
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean bipartite(int color[] , int node , int par)
	{
		if(color[node] == -1)
			color[node] = 1;
		Iterator<Integer> it = graph[node].iterator();
		while(it.hasNext())
		{
			int temp = it.next();
			if(color[temp] == -1)
			{
				color[temp] = 1-color[node];
				if(!bipartite(color,temp,node))
					return false;
			}
			else if(color[temp] == color[node])
				return false;
		}
		
		return true;
	}
	

}
