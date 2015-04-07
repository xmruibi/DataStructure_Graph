package graph.ShortestPath;

import java.util.LinkedList;

public class Vertex {
	final char label;
	boolean inTree;
	LinkedList<Edge> adjList;
	public Vertex(char label) {
		this.label = label;
		adjList = new LinkedList<Edge>();
		inTree = false;
	}
}
