package graph.ShortestPath;

import java.util.Arrays;

/**
 * This is directed graph
 * 
 * @author xmrui_000
 *
 */

public class Graph {

	private Vertex[] vertArr;
	private final static int DEFAULT_SIZE = 10;
	private int SIZE = DEFAULT_SIZE;
	private EdgeHeap heap;
	private int index = 0;

	public Graph() {
		vertArr = new Vertex[DEFAULT_SIZE];
		heap = new EdgeHeap();
	}

	private void resize() {
		vertArr = Arrays.copyOf(vertArr, SIZE + (SIZE >> 1));
		SIZE += (SIZE >> 1);
	}

	public void addVertex(char label) {
		if (index == (vertArr.length - 1))
			resize();
		Vertex vert = new Vertex(label);
		vertArr[index++] = vert;
	}

	public void addEdge(int start, int end, int dist) {
		vertArr[start].adjList.add(new Edge(end, dist));
	}

	public void result(int start) {
		System.out.println("From " + vertArr[start].label + " to:");
		int[] res = dijkstra(start);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0)
				System.out.println(vertArr[i].label + " " + res[i]);
		}
	}

	private int[] dijkstra(int start) {
		int[] res = new int[index];
		vertArr[start].inTree = true;
		heap.addAllEdges(vertArr[start].adjList);
		while (!heap.isEmpty()) {
			Edge cur = heap.popMin();
			Vertex next = vertArr[cur.getEndVert()];
			if (!next.inTree) {
				for (Edge edge : next.adjList) {
					int newEnd = edge.getEndVert();
					int newDist = edge.getDistance() + cur.getDistance();
					heap.addEdge(new Edge(newEnd, newDist));
				}
				next.inTree = true;
				res[cur.getEndVert()] = cur.getDistance();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addEdge(0, 1, 2);
		graph.addEdge(2, 1, 4);
		graph.addEdge(4, 3, 3);
		graph.addEdge(3, 2, 5);
		graph.addEdge(4, 1, 7);
		graph.addEdge(0, 3, 8);
		graph.addEdge(2, 4, 6);
		graph.addEdge(0, 5, 1);
		graph.addEdge(4, 5, 1);
		graph.result(2);
	}
}
