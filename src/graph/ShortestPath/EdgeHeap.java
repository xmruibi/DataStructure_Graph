package graph.ShortestPath;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class EdgeHeap {
	private Edge[] edges;
	private final static int DEFAULT_SIZE = 10;
	private int curPtr = 0;
	private int SIZE = DEFAULT_SIZE;

	public EdgeHeap() {
		edges = new Edge[DEFAULT_SIZE];
	}

	public boolean isEmpty() {
		return curPtr == 0 ? true : false;
	}

	public void addEdge(Edge edge) {
		if (curPtr >= (SIZE - 1))
			resize();
		edges[++curPtr] = edge;
		swim(curPtr);
	}

	public void addAllEdges(Collection<Edge> edges) {
		for (Edge edge : edges)
			addEdge(edge);
	}

	public Edge popMin() {
		if (isEmpty())
			throw new NoSuchElementException();
		Edge pop = edges[1];
		exch(1, curPtr--);
		sink(1);
		edges[curPtr + 1] = null;
		return pop;
	}

	/**
	 * Input index of element to make it sink when there is any element less
	 * than them but postion is behind them
	 * 
	 * @param idx
	 */
	private void sink(int idx) {
		while (idx * 2 <= curPtr) {
			int child = idx * 2;
			if ((child) < curPtr && less(child + 1, child))
				/*
				 * this is the key!!! to pop the minimal number compare the left
				 * and right child!
				 */
				child++;
			if (less(idx, child))
				break;
			exch(idx, child);
			idx = child;
		}
	}

	/**
	 * When an element is less than its parent, this element need to swim to
	 * less index for its position
	 * 
	 * @param idx
	 */
	private void swim(int idx) {
		while ((idx) > 1 && less(idx, (idx >> 1))) {
			exch(idx, idx >> 1);
			idx = idx >> 1;
		}
	}

	/******************* Utilities Method ***********************/
	/**
	 * Exchange teo element position when if necessary.
	 * 
	 * @param src
	 * @param tar
	 */
	private void exch(int src, int tar) {
		Edge tmp = edges[src];
		edges[src] = edges[tar];
		edges[tar] = tmp;
	}

	/**
	 * If idx1 element is less than idx2 element return true otherwise return
	 * false
	 * 
	 * @param idx1
	 * @param idx2
	 * @return
	 */
	private boolean less(int idx1, int idx2) {
		if (edges[idx1].getDistance() < edges[idx2].getDistance())
			return true;
		else
			return false;
	}

	/**
	 * Resize the edge array when necessary
	 */
	private void resize() {
		edges = Arrays.copyOf(edges, SIZE + (SIZE >> 2));
		SIZE += (SIZE >> 2);
	}

}
