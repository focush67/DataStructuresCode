package Temporary;
import java.util.*;

public class DirectedWeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source-1, destination-1, weight);
            adjacencylist[source-1].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println(i + " -----> " +
                            list.get(j).destination + " (" +  list.get(j).weight+")");
                }
            }
        }
    }
      public static void main(String[] args) {
    	    Scanner sc = new Scanner(System.in);
    	    System.out.println("ENTER NUMBER OF VERTICES");
            int vertices = sc.nextInt();
            Graph graph = new Graph(vertices); //Error is rising here
            System.out.println("ENTER NUMBER OF EDGES");
            int edges = sc.nextInt();
            while(edges != 0)
            {
            	int src = sc.nextInt();
            	int des = sc.nextInt();
            	int wt = sc.nextInt();
            	graph.addEgde(src,des,wt);
            }
            
            graph.printGraph();
            /*graph.addEgde(0, 1, 4);
            graph.addEgde(0, 2, 3);
            graph.addEgde(1, 3, 2);
            graph.addEgde(1, 2, 5);
            graph.addEgde(2, 3, 7);
            graph.addEgde(3, 4, 2);
            graph.addEgde(4, 0, 4);
            graph.addEgde(4, 1, 4);
            graph.addEgde(4, 5, 6);
            graph.printGraph();*/
        }
}












