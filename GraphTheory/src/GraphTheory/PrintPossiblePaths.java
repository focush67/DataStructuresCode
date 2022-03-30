package GraphTheory;
import java.util.*;
public class PrintPossiblePaths 
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
		//graph[dest].add(src);
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
	
	public static void possiblePathsUtil(int source , int destination , List<Integer> path , boolean vis[])
	{
		if(source == destination)
		{
			System.out.println(path);
			return;
		}
		
		else
		{
			vis[source] = true;
			for(int neigh : graph[source])
			{
				if(!vis[neigh]) {
					path.add(neigh);
					possiblePathsUtil(neigh , destination , path , vis);
					path.remove(neigh);
				}
			}
			vis[source] = false;
		}
	}
	
	public static void possiblePaths(int src , int des)
	{
		boolean vis[] = new boolean[graph.length];
		ArrayList<Integer> path = new ArrayList<>();
		path.add(src);
		possiblePathsUtil(src,des,path,vis);
	}
	
	public static void main(String at[])
	{
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		initialize(v);
		while(e != 0)
		{
			int s = sc.nextInt();
			int d = sc.nextInt();
			addEdge(s,d);
			--e;
		}
		
		display();
		System.out.println("ENTER SOURCE AND DESTINATION");
		int src = sc.nextInt();
		int des = sc.nextInt();
		possiblePaths(src,des);
	}
}
