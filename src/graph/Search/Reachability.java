package graph.Search;

import graph.DataStructure.Digraph;
import graph.DataStructure.Vertex;

public class Reachability {
	boolean reachable[];

	public Reachability(Digraph graph, int start) {
		reachable = new boolean[graph.getSize()];
		dfs(graph, start);
	}

	private void dfs(Digraph graph, int vertex) {
		reachable[vertex] = true;
		Vertex cur = graph.getVertex(vertex);
		for (int i = 0; i < cur.getAdjList().size(); i++) {
			if (!reachable[cur.getAdjList().get(i).getIdx()])
				dfs(graph, cur.getAdjList().get(i).getIdx());
		}
	}
	
	public boolean[] getReachable() {
		return reachable;
	}
}
