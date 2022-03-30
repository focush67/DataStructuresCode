package GraphTheory;
import java.util.*;
public class IterativeDFS {
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
		graph[dest].add(src);
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
	
	public static void iterativeDFS(int source , int v)
	{
		boolean visited[] = new boolean[v+1];
		Stack<Integer> stack = new Stack<Integer>(); // Queue gives wrong answer , so avoid using it
		stack.push(source);
		while(!stack.isEmpty())
		{
			int temp = stack.peek();
			stack.pop();
			if(!visited[temp])
			{
				System.out.print(temp+"-->");
				visited[temp] = true;
			}
			
			Iterator<Integer> it = graph[temp].iterator();
			while(it.hasNext())
			{
				int j = it.next();
				if(!visited[j])
				{
					stack.push(j);
				}
			}
		}
		System.out.println("end");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES");
		int e = sc.nextInt();
		initialize(v);
		int x = 0;
		while(e!=0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int src = sc.nextInt();
			x = src;
			int des = sc.nextInt();
			addEdge(src,des);
			--e;
		}
		display();
		System.out.println("\n\n"+"ITERAIVE DFT");
		iterativeDFS(x,v);
		// TODO Auto-generated method stub

	}

}
