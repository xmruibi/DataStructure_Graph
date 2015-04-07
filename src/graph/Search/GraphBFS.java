package graph.Search;

import java.util.LinkedList;
import java.util.Queue;

import graph.DS.GraphAdjList;
import graph.DS.Vertex;

public class GraphBFS {
	public static void bfsAdj(GraphAdjList graph) {
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(graph.getStart(0));
		queue.peek().visited=true;
		while (!queue.isEmpty()) {
			Vertex cur = queue.remove();

			for (int i = 0; i < cur.adjVer.size(); i++) {
				if (!cur.adjVer.get(i).visited) {
					cur.adjVer.get(i).visited = true;
					queue.add(cur.adjVer.get(i));
				}
			}
			System.out.print(cur.toString() + " ");
		}

	}
}
