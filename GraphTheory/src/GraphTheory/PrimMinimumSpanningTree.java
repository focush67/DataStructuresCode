package GraphTheory;
import java.util.*;
public class PrimMinimumSpanningTree
{
	public static class Node 
	{
		 int des;
		 int w;
		public Node(int des,int w)
		{
			this.des = des;
			this.w = w;
		}
		
		int getDest()
		{
			return des;
		}
		
		int getWeight()
		{
			return w;
		}
	}

	static ArrayList<Node> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			graph[i] = new ArrayList<Node>();
		}
	}
	
	public static void addEdge(int src , int des , int wt) {
		graph[src].add(new Node(des,wt));
		graph[des].add(new Node(src,wt));
	}
	
	public static void display()
	{
		for(int i=1;i<graph.length;i++)
		{
			if(graph[i].isEmpty()) {
				System.out.println("EMPTY");
			continue;
			}
			
			for(Node wrt : graph[i])
			{
				System.out.println(i+" --("+wrt.getWeight()+")--> "+wrt.getDest()+"\n");
			}
		}	
	}
	
	/*public static int minKey(boolean mst[] , int key[])
	{
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i=1;i<key.length;i++)
		{
			if(mst[i] == false && key[i] < min)
			{
				min = key[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}*/
	
	public static void minSpnTree()
	{
		int n = graph.length;
		int par[] = new int[n];
		int key[] = new int[n];
		boolean mst[] = new boolean[n];
		for(int i=1;i<n;i++)
		{
			mst[i] = false;
			key[i] = Integer.MAX_VALUE;
			par[i] = -1;
		}
		
		key[1] = 0;
		par[1] = -1;
		for(int c=1;c<=n-1;c++)
		{
			int min = Integer.MAX_VALUE;
			int u = 0;
			for(int i=1;i<key.length;i++)
			{
				if(mst[i] == false && key[i] < min)
				{
					min = key[i];
					u = i;
				}
			}
			
			mst[u] = true;
			for(Node ne : graph[u])
			{
				int d = ne.getDest();
				int weight = ne.getWeight();
				if(mst[d] == false && weight < key[d])
				{
					par[d] = u;
					key[d] = weight;
				}
			}
			
			for(int i=2;i<n;i++)
			{
				System.out.println(par[i]+" - - "+i+"  ");
			}
		}
	}
	
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES AND EDGES");
		int v = sc.nextInt();
		int e = sc.nextInt();
		while(e != 0)
		{
			System.out.println("ENTER SOURCE DESTINATION AND EDGE WEIGHT");
			int src = sc.nextInt();
			int des = sc.nextInt();
			int wt = sc.nextInt();
			addEdge(src,des,wt);
			--e;
		}
		
		display();
		System.out.println("\n\n Minimum Spanning Tree :");
		minSpnTree();
		
	}

}
