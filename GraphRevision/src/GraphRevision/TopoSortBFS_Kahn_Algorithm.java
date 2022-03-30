package GraphRevision;
import java.util.*;
public class TopoSortBFS_Kahn_Algorithm 
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
	
	public static void toposort(int v)
	{
		int in[] = new int[v+1];
		for(int i=1;i<=v;i++)
		{
			for(int el : graph[i])
			{
				in[el]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=v;i++)
		{
			if(in[i] == 0)
				q.offer(i);
		}
		
		int ind = 0;
		while(!q.isEmpty())
		{
			int node = q.poll();
			System.out.print(node+" ");
			for(int el : graph[node])
			{
				in[el]--;
				if(in[el] == 0)
					q.offer(el);
			}
		}
	}

}
