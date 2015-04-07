package graph.Sort;

import java.util.Stack;

import graph.DataStructure.Vertex;
import graph.DataStructure.Digraph;

/**
 * Make sure this is a DAG!
 * 
 * @author xmrui_000
 *
 */
public class TopologicalSort {

	final Digraph graph;
	final Stack<Vertex> order;

	public TopologicalSort(Digraph graph) {
		this.graph = graph;
		order = new Stack<Vertex>();
		topo();
	}

	private void topo() {
		Vertex noSuc = graph.detectNoSuccesorVertex();
		while (noSuc != null) {
			order.push(noSuc);
			graph.deleteVertex(noSuc.getIdx());
			noSuc = graph.detectNoSuccesorVertex();
		}
		if (graph.getSize() > 0) {
			System.out.println("Has Cycle");
			order.clear();
		}
	}

	public void printOrder() {
		while (!order.isEmpty()) {
			System.out.println(order.pop().getLabel()+"  ");
		}
	}

	public static void main(String[] args) {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		TopologicalSort sort = new TopologicalSort(graph);
		sort.printOrder();
	}
}
