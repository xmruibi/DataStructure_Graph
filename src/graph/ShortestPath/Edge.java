package graph.ShortestPath;

public class Edge {
	private final int distance;
	private final int endVert;

	public Edge(int tar, int dist) {
		this.endVert = tar;
		this.distance = dist;
	}

	public int getDistance() {
		return distance;
	}

	public int getEndVert() {
		return endVert;
	}

}
