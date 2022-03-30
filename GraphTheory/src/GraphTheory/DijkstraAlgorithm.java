package GraphTheory;
import java.util.*;
 class Pair implements Comparator<Pair>
{
	int d;
	int w;
	public Pair(int destination , int weight)
	{
		d = destination;
		w = weight;
	}
	
	public int getWeight()
	{
		return w;
	}
	
	public int getDest()
	{
		return d;
	}
	
	@Override
	public int compare(Pair p1 , Pair p2)
	{
		if(p1.getWeight() < p2.getWeight())
			return -1;
		if(p1.getWeight() > p2.getWeight())
			return 1;
		return 0;
	}
}

public class DijkstraAlgorithm 
{
	static ArrayList<Pair> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<Pair>();
		}
	}
	
	public static void addEdge(int src , int dest , int weight)
	{
		Pair x = new Pair(dest,weight);
		graph[src].add(x);
		Pair y = new Pair(src,weight);
		graph[dest].add(y);
	}
	
	public static void display()
	{
		for(int i=1;i<graph.length;i++)
		{
			if(graph[i].isEmpty()) {
				System.out.println(i+" EMPTY"+"\n");
				continue;
			}
			
			System.out.print(i+"  ");
			for(Pair p : graph[i])
			{
				System.out.print(p+"  ,  ");
			}
			System.out.println("\n");
		}
	}
	
	public static void shortestPath(int src)
	{
		int distance[] = new int[graph.length];
		for(int i=1;i<graph.length;i++)
		{
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[src] = 0;
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src,0));
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			for(Pair x : graph[p.getDest()])
			{
				if(distance[p.getDest()] + x.getWeight() < distance[x.getDest()])
				{
					distance[x.getDest()] = distance[p.getDest()]+x.getWeight();
					pq.add(new Pair(x.getDest() , distance[x.getDest()]));
				}
			}
		}
		
		for(int i=0;i<distance.length;i++)
		{
			System.out.print(distance[i]+"  ");
		}
	}
	
	

}
