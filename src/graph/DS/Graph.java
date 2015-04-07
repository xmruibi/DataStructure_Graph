package graph.DS;

public abstract class Graph {

	public abstract void addVertex(char label);

	public abstract void addUndirEdge(int x, int y);

	public abstract void addDirEdge(int x, int y);
	
	public abstract void print();
}
