package Trees;
import java.util.*;
public class BinaryTree // It is basically a directed graph where each node can have maximum of 2 neighbors
{
	static ArrayList<Integer> tree[];
	public static void initialize(int nodes)
	{
		tree = new ArrayList[nodes+1];
		for(int i=1;i<=nodes;i++)
			tree[i] = new ArrayList<>();
	}
	
	public static void addTree(int src , int dest)
	{
		if(tree[src].size() < 2)
		tree[src].add(dest);
		else
		return;
	}
	
	public static void display()
	{
		System.out.println("\n");
		for(int i=1;i<tree.length;i++)
		{
			ArrayList<Integer> temp = tree[i];
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
		
		for(int i=1;i<tree.length;i++)
		{
			if(tree[i].size() == 0)
			{
				tree[i].add(-1);
				tree[i].add(-1);
			}
			
			else if(tree[i].size() == 1)
			{
				tree[i].add(-1);
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER NUMBER OF NODES IN BINARY TREE");
		int nodes = sc.nextInt();
		System.out.println("ENTER NUMBER OF EDGES IN BINARY TREE");
		int edges = sc.nextInt();
		initialize(nodes);
		while(edges != 0)
		{
			System.out.println("ENTER SOURCE AND DESTINATION");
			int src = sc.nextInt();
			int des = sc.nextInt();
			addTree(src, des);
			--edges;
		}
		
		System.out.println("\n");
		display();
	}

}
