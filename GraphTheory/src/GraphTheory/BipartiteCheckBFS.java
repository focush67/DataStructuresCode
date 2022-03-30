package GraphTheory;
import java.util.*;
public class BipartiteCheckBFS {
	static ArrayList<Integer> graph[];
	@SuppressWarnings("unchecked")
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
		{
			graph[i] = new ArrayList<>();
		}
	}
	
	public static void addEdge(int src , int dest) // Undirected unweighed graph
	{
		graph[src].add(dest);
		graph[dest].add(src);
	}
	
	public static void display()
	{
		System.out.println("\n");
		for(int i=1;i<graph.length;i++)
		{
			ArrayList<Integer> temp = graph[i];
			if(temp.size() == 0) {
				System.out.println(i + "--> {EMPTY}"+"\n");
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
			System.out.print("}"+"\n");
			System.out.println(/*"\n"*/);
		}
	}
	
	public static boolean checkBipartite(int node , int colour[])
	{
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		colour[node] = 1;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			for(int el : graph[temp]) // visit all neighbors of temp
			{
				if(colour[el] == -1) // color neighbors of temp if not colored
				{
					colour[el] = 1-colour[temp];
					q.offer(el);
				}
				
				else if(colour[el] == colour[temp])
					return false;
			}
		}
		
		return true;
	}
	
	public static boolean check(int v)
	{
		int color[] = new int[v+1];
		Arrays.fill(color, -1);
		for(int i=1;i<=v;i++)
		{
			if(color[i] == -1) // Node has not been colored yet
			{
				if(!checkBipartite(i,color))
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int src = sc.nextInt();
			int dest = sc.nextInt();
			addEdge(src,dest);
			--e;
		}
		
		display();
		boolean f = check(v);
		if(f == true)
			System.out.println("GRAPH IS BIPARTITE");
		else
			System.out.println("GRAPH IS NOT BIPARTITE");
	}

}
