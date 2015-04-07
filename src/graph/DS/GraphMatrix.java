package graph.DS;

public class GraphMatrix extends Graph {

	final boolean[][] matrix;

	public GraphMatrix(int size) {
		matrix = new boolean[size][size];
	}

	@Override
	public void addVertex(char label) {

	}

	@Override
	public void addUndirEdge(int x, int y) {
		matrix[x][y] = true;
		matrix[y][x] = true;
	}

	@Override
	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("Vertex " + String.valueOf(i + 1)
					+ " connect with: [ ");
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j])
					System.out.print("Vertex " + String.valueOf(j + 1));
			}
			System.out.print("] \n");
		}

	}

	@Override
	public void addDirEdge(int main, int target) {
		matrix[main][target] = true;
	}

}
