package graph.MinimalSpaningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is undirected graph
 * 
 * @author xmrui_000
 */
public class Graph {
	private Vertex[] vertArr;
	private EdgeHeap heap;
	private final static int DEFAULT_SIZE = 10;
	private int SIZE = DEFAULT_SIZE;
	private int index = 0;
	private final List<String> res;
	
	public Graph(int size) {
		vertArr = new Vertex[size];
		heap = new EdgeHeap();
		res = new ArrayList<String>();
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
		Edge edge = new Edge(start, end, dist);
		heap.addEdge(edge);
	}
	
	private void minimalSpanningTree() {
		while(!heap.isEmpty()){
			Edge edge = heap.popMin();
			if(vertArr[edge.getStartVert()].inTree&&vertArr[edge.getEndVert()].inTree)
				continue;
			else{
				vertArr[edge.getStartVert()].inTree = true;
				vertArr[edge.getEndVert()].inTree = true;
				res.add(vertArr[edge.getStartVert()].label+" "+vertArr[edge.getEndVert()].label+" "+edge.getDistance());
			}
		}
	}
	
	public void mstResult() {
		minimalSpanningTree();
		System.out.println(res);
	}
	
	
	public static void main(String[] args) {
		Graph graph = new Graph(DEFAULT_SIZE);
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
		graph.mstResult();
	}
}
