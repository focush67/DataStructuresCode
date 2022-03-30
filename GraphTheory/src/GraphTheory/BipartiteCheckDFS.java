package GraphTheory;
import java.util.*;
public class BipartiteCheckDFS
{
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
    
	public static void addEdge(int src , int dest)
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
	
	public static boolean checkBipartite(int colour[] , int node , int parent)
	{
		if(colour[node] == -1)
			colour[node] = 1;
		Iterator<Integer> it = graph[node].iterator();
		while(it.hasNext())
		{
			int temp = it.next();
			if(colour[temp] == -1)
			{
				colour[temp] = 1 - colour[node];
				if(!checkBipartite(colour,temp,node))
					return false;
			}
			
			else if(colour[node] == colour[temp])
				return false;
		}
		
		return true;
		
	}
	
	public static boolean check(int v)
	{
		int colour[] = new int[v+1];
		Arrays.fill(colour, -1);
		for(int i=1;i<=v;i++)
		{
			if(colour[i] == -1)
			{
				if(!checkBipartite(colour,i,0))
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		//System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			//System.out.println("ENTER SOURCE AND DESTINATION");
			int src = sc.nextInt();
			int des = sc.nextInt();
			addEdge(src,des);
			--e;
		}
		
		display();
		boolean f = check(v);
		if(f)
			System.out.println("GRAPH IS BIPARTITE");
		else
			System.out.println("GRAPH IS NOT BIPARTITE");
	}

}
