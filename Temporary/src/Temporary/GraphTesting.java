package Temporary;
import java.util.*;
public class GraphTesting 
{
	public class Edge
	{
		int des;
		int wt;
		public Edge(int destination , int weight)
		{
			des = destination;
			wt = weight;
		}
	}	

	public class Graph
	{
		int vertices;
		ArrayList<Edge> graph[];
		public Graph(int vertices)
		{
			this.vertices = vertices;
			graph = new ArrayList[vertices];
		}

		public void initializeGraph()
		{
			for(int i=0;i<vertices;i++)
			{
				graph[i] = new ArrayList<>();
			}
		}
		
		public void addEdge(int src , int des , int wt)
		{
			Edge e = new Edge(des,wt);
			graph[src].add(e);
		}
	}
	
	public void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF VERTICES");
		int v = sc.nextInt();
		Graph g = new Graph(v);
		g.initializeGraph();
		while(v-->0)
		{
			System.out.println("ENTER SOURCE DESTINATION AND WEIGHT");
			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			g.addEdge(s, d, w);
		}
	}
}

