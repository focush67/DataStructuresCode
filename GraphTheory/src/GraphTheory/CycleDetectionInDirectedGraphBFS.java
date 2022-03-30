package GraphTheory;
import java.util.*;
public class CycleDetectionInDirectedGraphBFS // Using Kahn's Algorithm
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
	
	public static boolean isCyclic(int n)
	{
		Queue<Integer> q = new LinkedList<>();
		int indegree[] = new int[n+1];
		for(int i=1;i<=n;i++)
		{
			for(int el : graph[i])
			{
				indegree[i]++;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		int cnt = 0;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			cnt++;
			for(int el : graph[temp])
			{
				indegree[el]--;
				if(indegree[el] == 0)
					q.offer(el);
			}
		}
		
		if(cnt == n)
			return false;
		return true;
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
			addEdge(src,des);
			--e;
		}
		
		display();
		boolean f = isCyclic(v);
		if(f) {
			System.out.println("GRAPH IS CYCLIC");
			return;
		}
		
	}
	
}
