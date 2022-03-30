package GraphTheory;
import java.util.*;
import GraphTheory.DirectedWeightedGraph.Weighted;
public class ShortestPathInDAG 
{
	static Stack<Integer> stack = new Stack<>();
	public static class Weighted
	{
		int dest;
		int weight;
		public Weighted(int dest,int weight)
		{
			this.dest = dest;
			this.weight = weight;
		}
		
		public static int getWeight(Weighted p)
		{
			return p.weight;
		}
		
		public static int getDest(Weighted p)
		{
			return p.dest;
		}
	}
	
	static ArrayList<Weighted> graph[];
	static int inf = Integer.MAX_VALUE;
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<graph.length;i++)
		{
			graph[i] = new ArrayList<Weighted>();
		}
	}
	
	public static void addEdge(int s , int d , int w , boolean bi)
	{
		graph[s].add(new Weighted(d,w));
		if(bi)
		{
			graph[d].add(new Weighted(s,w));
		}
	}
	
	
	public static void display() // Find a way to print a weighted graph properly
	{
		for(int i=1;i<graph.length;i++)
		{
			if(graph[i].isEmpty()) {
				System.out.println("EMPTY");
			continue;
			}
			
			for(Weighted w : graph[i])
			{
				System.out.println(i+" --("+w.weight+")--> "+w.dest);
			}
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
		for(Weighted el : graph[src])
		{
			if(!vis[el.dest])
			{
				if(hasCycleUtil(el.dest,vis,dfsvis))
					return true;
			}
			
			else if(dfsvis[el.dest])
				return true;
		}
		
		dfsvis[src] = false;
		return false;
	}
	
	public static void toposort(boolean vis[] , int node)
	{
		vis[node] = true;
		for(Weighted el : graph[node])
		{
			if(!vis[el.dest])
			{
				toposort(vis , el.dest);
			}
		}
		
		stack.push(node);
	}
	
	public static void findTopoSort(int n)
	{
		boolean vis[] = new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			if(!vis[i])
			{
				toposort(vis,i);
			}
		}
		
	}
	
	public static void shortestPath(int dis[],int s)
	{
		Arrays.fill(dis, inf);
		int el = stack.pop();
		dis[s] = 0;
		
		while(!stack.isEmpty())
		{
			int node = (int)stack.pop();
			if(dis[node] != inf)
			{
				for(Weighted it : graph[node])
				{
					if(dis[node] + it.weight < dis[it.dest])
					{
						dis[it.dest] = dis[node] + it.weight;
					}
				}
			}
		}
		
		for(int i=0;i<dis.length;i++)
		{
			if(dis[i]==inf)
				System.out.print("Unreachable ");
			else
				System.out.print(dis[i]+" ");
		}
	}
	
	public static void main(String h[])
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			int src = sc.nextInt();
			int des = sc.nextInt();
			int w = sc.nextInt();
			addEdge(src,des,w,false);
			--e;
		}
		
		display();
		boolean f = hasCycle();
		if(f) {
			System.out.println("NOT POSSIBLE FOR CYCLIC GRAPH");
			return;
		}
		
		int d[] = new int[v+1];
		findTopoSort(v);
		shortestPath(d,1);
	}
}
