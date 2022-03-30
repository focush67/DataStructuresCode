package GraphTheory;
import java.util.*;
public class UnweightedDirectedGraph // This is actually an undirected unweighed graph , implemented using adjacency list
{
	//static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> graph[];
	@SuppressWarnings("unchecked")
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
	
	public static void BFT(int src) // IF GRAPH CONTAINS MULTIPLE COMPONENTS , THIS APPROACH WILL FAIL
	{
		boolean vis[] = new boolean[graph.length];
		vis[src] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(src);
		while(!q.isEmpty())
		{
			int temp = q.poll();
			System.out.print(temp+"-->");
			for(int element : graph[temp])
			{
				if(!vis[element])
				{
					vis[element] = true;
					q.offer(element);
				}
			}
		}
	}
	
	public static void DFTUtil(int n,boolean vis[])
	{
		vis[n] = true;
		System.out.print(n+"-->");
		Iterator<Integer> i = graph[n].listIterator();
		while(i.hasNext())
		{
			int x = i.next();
			if(!vis[x])
				DFTUtil(x,vis);
		}
	}
	
	public static void DFT(int src)
	{
		boolean visited[] = new boolean[graph.length];
		DFTUtil(src,visited);
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
	
	public static void SingleSourceShortestPath(int src,int des,int n)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		boolean [] vis = new boolean[n+1];
		int parent [] = new int[n+1];
		Arrays.fill(parent, -1);
		int dis [] = new int[n+1];
		q.offer(src);
		vis[src]=true;
		while(!q.isEmpty())
		{
			int x = q.poll();
			for(int neig : graph[x])
			{
				if(!vis[neig])
				{
					q.offer(neig);
					vis[neig]=true;
					parent[neig]=x;
					dis[neig]=dis[x]+1;
				}
			}
		}
		ArrayList<Integer> lis = new ArrayList<Integer>();
		int t = des;
		while(t!=-1)
		{
			lis.add(t);
			t = parent[t];
		}
		
		for(int i=lis.size()-1;i>=0;i--)
		{
			System.out.print(lis.get(i)+" ---> ");
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
		while(e-->0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int sr = sc.nextInt();
			int de = sc.nextInt();
			addEdge(sr,de);
		}
		System.out.println("\n Your Graph");
		display();
		System.out.println("ENTER VALID STARTING POINT FOR BFT");
		int s = sc.nextInt();
		BFT(s);
		System.out.println("\nENTER STARTING POINT FOR DFT");
		int s2 = sc.nextInt();
		DFT(s2);
		System.out.println("\n");
		System.out.println("ENTER SOURCE AND DESTINATION");
		int src = sc.nextInt();
		int dest= sc.nextInt();
		System.out.println("SHORTEST PATH ");
		SingleSourceShortestPath(src,dest,v);
		
		int c = connectedComponents(src,v);
		System.out.println("NUMBER OF CONNECTED COMPONENTS :"+c);
	}

}
