package GraphTheory;
import java.util.*;
public class CycleDetectionInDirectedGraph
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
	
	public static void addEdge(int src , int dest) // Undirected Unweighed Graph
	{
		graph[src].add(dest);
	}
	
	public static void display()
	{
		System.out.println("\n");
		for(int i=1;i<graph.length;i++)
		{
			ArrayList<Integer> temp = graph[i];
			if(temp.size() == 0) {
				System.out.println(i + "--> {EMPTY}");
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
			System.out.println(/*"\n"*/);
		}
	}
	
	public static boolean hasCycle()
	{
		boolean vis[] = new boolean[graph.length];
		boolean dfsvis[] = new boolean[graph.length];
		for(int i=1;i<graph.length;i++)
		{
			if(!graph[i].isEmpty() && !vis[i])
			{
				if(hasCycleUtil(i,vis,dfsvis))
					return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasCycleUtil(int src , boolean vis[] , boolean dfsvis[])
	{
		vis[src] = true;
		dfsvis[src] = true;
		for(int el : graph[src])
		{
			if(!vis[el])
			{
				if(hasCycleUtil(el,vis,dfsvis))
					return true;
			}
			
			else if(dfsvis[el])
				return true;
		}
		
		dfsvis[src] = false;
		return false;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES AND EDGES");
		int v = sc.nextInt();
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			int src = sc.nextInt();
			int des = sc.nextInt();
			addEdge(src,des);
			--e;
		}
		
		display();
		boolean f = hasCycle();
		if(f)
			System.out.println("GRAPH HAS A CYCLE");
		else
			System.out.println("GRAPH DOES NOT HAVE A CYCLE");
	}
}
