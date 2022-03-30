package GraphTheory;
import java.util.*;
public class MotherVetrtex 
{
	static ArrayList<Integer> graph[];
	static int reach[];
	@SuppressWarnings("unchecked")
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		reach = new int[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<Integer>();
		}
	}
	
	public static void addEdge(int src , int des , boolean bi)
	{
		graph[src].add(des);
		if(bi) {
		graph[des].add(src);
		}
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
	
	public static void DFTUtil(int n,boolean vis[])
	{
		vis[n] = true;
		//System.out.print(n+"-->");
		Iterator<Integer> i = graph[n].listIterator();
		while(i.hasNext())
		{
			int x = i.next();
			if(!vis[x])
				DFTUtil(x,vis);
		}
	}
	public static int connectedComponents(int src , int v)
	{
		int comp = 0;
		boolean vis[] = new boolean[v+1];
		vis[src] = true;
		for(int i=1;i<=v;i++)
		{
			if(!vis[i]) {
				comp++;
				DFTUtil(i,vis);
			}
		}
		return comp;
	}
	
	public static void DFSforDirectedGraphUtil(int source , boolean visited[])
	{
		visited[source] = true;
		reach[source]++;
		Iterator<Integer> it = graph[source].iterator();
		while(it.hasNext())
		{
			int c = it.next();
			if(!visited[c])
				DFSforDirectedGraphUtil(c,visited);
		}
	}
	public static void DFSforDirectedGraph(int src , int v)
	{
		boolean [] vis = new boolean[v+1];
		DFSforDirectedGraphUtil(src,vis);
		if(reach[src] == v)
			System.out.println(src);
	}
	
	public static void motherVertex(int v) // Works Only for Undirected Graphs
	{
		int x = connectedComponents(v,v);
		if(x > 1)
			System.out.println("NO MOTHER VERTEX");
		else
			System.out.println("ALL VERTICES ARE MOTHER VERTICES");
	}
	
	public static int countMotherVertices(int src , int v) // For Directed Graphs
	{
		int c = 0; // This variable gets updated if we can complete DFS of all nodes from src.
		
		return c;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		while(e!=0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int s = sc.nextInt();
			int d = sc.nextInt();
			if(s == d) {
				System.out.println("INVALID INPUT");
			}
			boolean conn = true;
			addEdge(s,d,conn);
			--e;
		}
		
		display();
		motherVertex(v);
	}
}
