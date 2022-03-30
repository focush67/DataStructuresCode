package GraphTheory;
import java.util.*;
public class OptimisedPrim
{
   public static class Node implements Comparator<Node> 
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
		
		@Override
		
		public int compare(Node n1 , Node n2)
		{
			if(n1.w > n2.w)
				return 1;
			if(n1.w < n2.w)
				return -1;
			return 0;
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
		Node x = new Node(des,wt);
		Node y = new Node(src,wt);
		graph[src].add(x);
		graph[des].add(y);
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
	
	public static void minSpnTree()
	{
		int n = graph.length;
		int key[] = new int[n];
		int parent[] = new int[n];
		boolean mst[] = new boolean[n];
		Arrays.fill(parent, -1);
		Arrays.fill(key , Integer.MAX_VALUE);
		key[1] = 0;
		parent[1] = 1;
		PriorityQueue<Node> q = new PriorityQueue<>();
		Node z = new Node(1,key[1]);
		q.offer(z);
		for(int c=1;c<=n;c++)
		{
			int u = q.poll().getDest();
			mst[u] = true;
			
			for(Node ni : graph[u])
			{
				int d = ni.getDest();
				int weig = ni.getWeight();
				if(mst[d] == false && weig < key[d])
				{
					parent[d] = u;
					key[d] = weig;
					q.offer(new Node(d , key[d]));
				}
			}
			
		}
		
		for(int i=2;i<parent.length;i++)
		{
			System.out.println(parent[i]+" - - " +i);
		
		}
	}
	
	public static void main()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES AND EDGES");
		int v = sc.nextInt();
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			System.out.println("ENTER SOURCE DESTINATION AND EDGE WEIGHT");
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			addEdge(s,d,w);
			--e;
		}
		
		display();
		System.out.println("\n\n Minimum Spanning Tree :");
		minSpnTree();
	}

}
