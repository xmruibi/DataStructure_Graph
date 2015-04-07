package graph.DS;

import java.util.LinkedList;

public class GraphAdjList extends Graph {
	final Vertex[] adjList;
	int vertexPtr = 0;

	public GraphAdjList(int size) {
		adjList = new Vertex[size];
	}

	public Vertex[] getVset() {
		return this.adjList;
	}

	@Override
	public void addVertex(char label) {
		adjList[vertexPtr++] = new Vertex(label);
	}

	@Override
	public void addUndirEdge(int beAdded, int add) {
		adjList[beAdded].adjVer.add(adjList[add]);
		adjList[add].adjVer.add(adjList[beAdded]);
	}

	@Override
	public void addDirEdge(int main, int target) {
		adjList[main].adjVer.add(adjList[target]);
	}

	public Vertex getStart(int index) {
		return adjList[index];
	}

	@Override
	public void print() {
		for (int i = 0; i < adjList.length; i++) {
			System.out.println(adjList[i] + " connect with: "
					+ adjList[i].adjVer);
		}
	}

}
