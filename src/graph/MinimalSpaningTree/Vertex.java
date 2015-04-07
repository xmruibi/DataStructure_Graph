package graph.MinimalSpaningTree;

public class Vertex {
	final char label;
	boolean inTree;

	public Vertex(char label) {
		this.label = label;
		inTree = false;
	}
}
