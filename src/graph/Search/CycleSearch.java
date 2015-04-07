package graph.Search;

import graph.DataStructure.Digraph;
import graph.DataStructure.Vertex;

import java.util.Stack;

/**
 * Why need cycle check? Because the topological sort can only implemented in
 * DAG ( directed acyclic graph )
 * 
 * @author xmrui_000
 *
 */
public class CycleSearch {

	boolean[] marked;
	boolean[] onstack;
	Stack<Vertex> stack = new Stack<Vertex>();

	public CycleSearch(Digraph graph) {
		marked = new boolean[graph.getSize()];
		onstack = new boolean[graph.getSize()];
		for (int i = 0; i < marked.length; i++) {
			dfs(graph, i);
		}
	}

	private void dfs(Digraph graph, int vertex) {
		marked[vertex] = true;
		Vertex cur = graph.getVertex(vertex);
		for (int i = 0; i < cur.getAdjList().size(); i++) {
			int nextIdx = cur.getAdjList().get(i).getIdx();
			if (marked[nextIdx] && onstack[nextIdx]) {
				hasCycle();
				return;
			} else if (!marked[nextIdx] && !onstack[nextIdx]) {
				stack.push(cur);
				onstack[vertex] = true;
				dfs(graph, cur.getAdjList().get(i).getIdx());
			}
		}
		if (!stack.isEmpty()) {
			stack.pop();
			onstack[vertex] = false;
		}
	}

	private void hasCycle() {
		System.out.println("Not a DAG!");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getLabel() + " ");
		}
	}

	public static void main(String[] args) {
		Digraph graph = new Digraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		CycleSearch checkCycle = new CycleSearch(graph);
	}
}
