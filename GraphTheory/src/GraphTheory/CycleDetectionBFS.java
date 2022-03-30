package GraphTheory;
import java.util.*;
class Node
{
	int f;
	int s;
	public Node(int f,int s)
	{
		this.f=f;
		this.s=s;
	}
}

public class CycleDetectionBFS // Using BFS 
{
	static ArrayList<Integer> graph[];
	public static void initialize(int vertices)
	{
		graph = new ArrayList[vertices+1];
		for(int i=1;i<=vertices;i++)
		{
			graph[i] = new ArrayList<>();
		}
	}
	
	public static void addEdge(int src , int des , boolean bi) // Directed Graph
	{
		graph[src].add(des);
		if(bi) {
		graph[des].add(src);
		}
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
	
	public static boolean isCyclicUtil(int s , boolean vis[])
	{
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s,-1));
		vis[s] = true;
		
		while(!q.isEmpty())
		{
			int node = q.peek().f;
			int parent = q.peek().s;
			q.remove();
			
			for(int x : graph[node])
			{
				if(!vis[x])
				{
					vis[x] = true;
					q.add(new Node(x,node));
				}
				
				else if(parent != x)
					return true;
			}
		}
		
		return false;
	}
	
	 public static boolean isCyclic(int v)
	 {
		 boolean vis[] = new boolean[v+1];
		 for(int i=1;i<=v;i++)
		 {
				 if(!vis[i])
				 {
					 if(isCyclicUtil(i,vis))
						 return true;
				 }
		 }
		 
		 return false;
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
			 System.out.println("ENTER SOURCE AND DESTINATION");
			 int src = sc.nextInt();
			 int dest = sc.nextInt();
			 addEdge(src,dest,false);
			 --e;
		 }
		 
		 display();
		 boolean f = isCyclic(v);
		 if(f)
			 System.out.println("GRAPH IS CYCLIC");
		 else
			 System.out.println("GRAPH IS ACYCLIC");
	 }

}
