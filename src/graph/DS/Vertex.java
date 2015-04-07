package graph.DS;

import java.util.LinkedList;

public class Vertex {
	int idx;
	char label;
	public boolean visited;
	public LinkedList<Vertex> adjVer;

	public Vertex(int idx) {
		this.idx = idx;
		this.adjVer = new LinkedList<Vertex>();
	}

	public Vertex(char label) {
		this.label = label;
		this.visited = false;
		this.adjVer = new LinkedList<Vertex>();
	}

	@Override
	public String toString() {
		return "Vertex: " + label;
	}
}
