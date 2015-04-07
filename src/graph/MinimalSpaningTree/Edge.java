package graph.MinimalSpaningTree;

public class Edge {
	private final int distance;
	private final int startVert;
	private final int endVert;

	public Edge(int start, int end, int dist) {
		this.startVert = start;
		this.endVert = end;
		this.distance = dist;
	}

	public int getDistance() {
		return distance;
	}

	public int getEndVert() {
		return endVert;
	}

	public int getStartVert() {
		return startVert;
	}
}
