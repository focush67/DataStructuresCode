package GraphTheory;
import java.util.*;
public class CycleDetection // Using DFS 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int vertices)
	{
		graph = new ArrayList[vertices+1];
		for(int i=1;i<=vertices;i++)
		{
			graph[i] = new ArrayList<>();
		}
	}
	
	public static void addEdge(int src , int des)
	{
		graph[src].add(des);
		graph[des].add(src);
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
	
	public static boolean hasCycleUtil(int v , boolean vis[] , int par)
	{
		vis[v] = true;
		int i;
		Iterator<Integer> it = graph[v].iterator();
		while(it.hasNext())
		{
			i = it.next();
			if(!vis[i])
			{
				if(hasCycleUtil(i,vis,v))
					return true;
			}
			
			else if(i!=par)
				return true;
		}
		
		return false;
	}
	
	public static boolean hasCycle(int v)
	{
		boolean vis[] = new boolean[v+1];
		for(int i=1;i<vis.length;i++)
			vis[i]=false;
		
		for(int u=1;u<vis.length;u++)
		{
			if(!vis[u] && !graph[u].isEmpty())
			{
				if(hasCycleUtil(u,vis,-1))
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int vertices = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int edges = sc.nextInt();
		initialize(vertices);
		while(edges != 0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int s = sc.nextInt();
			int d = sc.nextInt();
			addEdge(s,d);
			--edges;
		}
		
		display();
		boolean x = hasCycle(vertices);
		if(x == true)
			System.out.println("GRAPH HAS A CYCLE");
		else
			System.out.println("GRAPH HAS NO CYCLE");
	}

}
