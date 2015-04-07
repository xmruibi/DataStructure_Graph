package graph.Test;

import graph.DS.*;
import graph.Search.GraphBFS;
import graph.Search.GraphDFS;

public class GraphClient {
	public static void main(String[] args) {
		GraphAdjList graph = new GraphAdjList(8);
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('H');
		graph.addUndirEdge(0, 1);
		graph.addUndirEdge(0, 2);
		graph.addUndirEdge(1, 3);
		graph.addUndirEdge(2, 3);
		graph.addUndirEdge(2, 4);
		graph.addUndirEdge(3, 4);
		graph.addUndirEdge(3, 5);
		graph.addUndirEdge(5, 6);
		graph.addUndirEdge(6, 7);
		//GraphDFS.dfsAdj(graph);
		GraphBFS.bfsAdj(graph);
	}


}
