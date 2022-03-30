package GraphTheory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
// A directed graph using
// adjacency list representation
public class temporary {
 
    // No. of vertices in graph
    private int v;
 
    // adjacency list
    private ArrayList<Integer>[] adjList;
 
    // Constructor
    public temporary(int vertices)
    {
 
        // initialise vertex count
        this.v = vertices;
 
        // initialise adjacency list
        initAdjList();
    }
 
    // utility method to initialise
    // adjacency list
    @SuppressWarnings("unchecked")
    private void initAdjList()
    {
        adjList = new ArrayList[v+1];
 
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
 
    // add edge from u to v
    public void addEdge(int u, int v)
    {
        // Add v to u's list.
        adjList[u].add(v);
    }
 
    // Prints all paths from
    // 's' to 'd'
    public void printAllPaths(int s, int d)
    {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
 
        // add source to path[]
        pathList.add(s);
 
        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList);
    }
 
    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList)
    {
 
        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            return;
        }
 
        // Mark the current node
        isVisited[u] = true;
 
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
 
                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }
 
        // Mark the current node
        isVisited[u] = false;
    }
    
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	int v = sc.nextInt();
    	int e = sc.nextInt();
    	temporary ob = new temporary(v);
    	ob.initAdjList();
    	while(e != 0)
    	{
    		int u = sc.nextInt();
    		int ve = sc.nextInt();
    		ob.addEdge(u,ve);
    		--e;
    	}
    	int s = sc.nextInt();
    	int d = sc.nextInt();
    	ob.printAllPaths(s, d);
    }
}
    
    
 