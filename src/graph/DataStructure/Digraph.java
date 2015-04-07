package graph.DataStructure;

import java.util.Arrays;
import java.util.LinkedList;

public class Digraph {

	int size;
	Vertex[] vertexs;

	public Digraph(int size) {
		this.size = size;
		vertexs = new Vertex[size];
		for (int i = 0; i < size; i++) {
			vertexs[i] = new Vertex(i, (char) ('A' + i));
		}
	}

	public Vertex getVertex(int index) {
		return vertexs[index];
	}

	public void addEdge(int from, int to) {
		vertexs[from].adjList.add(vertexs[to]);
	}

	/***************************** topological sort *******************************/
	public void deleteVertex(int index) {
		deleteEdges(index);
		vertexs[index] = null;
		size--;
	}

	private void deleteEdges(int index) {
		for (Vertex v : vertexs)
			if (v!=null&&v.adjList.contains(vertexs[index]))
				v.adjList.remove(vertexs[index]);
	}

	public Vertex detectNoSuccesorVertex() {
		for (Vertex v : vertexs)
			if (v != null && v.adjList.size() == 0)
				return v;
		return null;
	}

	/*******************************************************************************/
	public int getSize() {
		return size;
	}
}
