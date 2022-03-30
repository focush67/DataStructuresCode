package GraphRevision;
import java.util.*;
class Node
{
	int dest;
	int wt;
	public Node(int dest,int wt)
	{
		this.dest=dest;
		this.wt=wt;
	}
}
public class ShortestPath_DWG
{
	static ArrayList<Node> graph[];
	public static void initialize(int v)
	{
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++)
			graph[i]=new ArrayList<Node>();
	}
	
	public static void BFS(int v , int st)
	{
		
	}

}
