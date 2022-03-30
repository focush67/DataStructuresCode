package GraphTheory;
import java.util.*;
public class DirectedWeightedGraph
{
	public static class Weighted
	{
		int dest;
		int weight;
		public Weighted(int dest,int weight)
		{
			this.dest = dest;
			this.weight = weight;
		}
		
		
	}
	
	static ArrayList<Weighted> graph[];
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
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		while(e!=0)
		{
			System.out.println("ENTER SOURCE , DESTINATION AND WEIGHT");
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			addEdge(s,d,w,true);
			--e;
		}
		System.out.println("YOUR GRAPH"+"\n\n");
		display();
	}
}
