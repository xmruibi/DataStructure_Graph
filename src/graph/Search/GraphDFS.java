package graph.Search;

import java.util.Stack;

import graph.DS.*;

public class GraphDFS {
	public static void dfsAdj(GraphAdjList graph) {
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(graph.getStart(0));
		// display first element
		System.out.print(stack.peek()+ " " );
		
		while (!stack.isEmpty()) {
			Vertex cur = stack.peek();
			cur.visited = true;
			
			// search next unvisited vertex
			for (int i = 0; i < cur.adjVer.size(); i++) {
				if (!cur.adjVer.get(i).visited) {
					// found and push
					System.out.print(cur.adjVer.get(i).toString()+ " " );
					stack.push(cur.adjVer.get(i));
					break;
				}
			}
			// pop elemetn when there is no unvisited neighbor found
			if (stack.peek() == cur) {
				stack.pop();
			}
		}
	}
}
