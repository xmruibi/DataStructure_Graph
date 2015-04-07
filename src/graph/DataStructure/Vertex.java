package graph.DataStructure;

import java.util.LinkedList;

public class Vertex {
	final int idx;
	final char label;
	final LinkedList<Vertex> adjList;

	public Vertex(int idx, char label) {
		this.idx = idx;
		this.label = label;
		adjList = new LinkedList<Vertex>();
	}

	public LinkedList<Vertex> getAdjList() {
		return adjList;
	}

	public int getIdx() {
		return idx;
	}

	public char getLabel() {
		return label;
	}

	public boolean addNeighbor(Vertex neighbor) {
		return adjList.add(neighbor);
	}
}
