package GraphTheory;
import java.util.*;
public class NumberOfPaths
{
	static int paths = 0;
	//static ArrayList<Integer> list = new ArrayList<>();
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
	}
	
	public static void numberOfPaths(int src , int dest , boolean vis[] , List<Integer> local)
	{
		if(src == dest) {
			paths++;
			System.out.println(local);
			return;
		}
		
		vis[src] = true;
		for(int el : graph[src])
		{
			if(!vis[el])
			{
				local.add(el);
				numberOfPaths(el,dest,vis,local);
				local.remove(el);
			}
		}
		
		vis[src] = false;
		
	}
	
	public static void printPaths(int s , int d)
	{
		boolean isVisited[] = new boolean[graph.length];
		ArrayList<Integer> pathList = new ArrayList<>();
		pathList.add(s);
		numberOfPaths(s,d,isVisited,pathList);
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
	
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES IN YOUR GRAPH");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES IN YOUR GRAPH");
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
		
		System.out.println("YOUR GRAPH ");
		display();
		
		System.out.println("ENTER SOURCE OF YOUR PATH");
		int x = sc.nextInt();
		System.out.println("ENTER DESTINATION OF YOUR PATH");
		int y = sc.nextInt();
		printPaths(x,y);
		System.out.println("\n"+"NUMBER OF PATHS : "+paths);
		
	}
}
