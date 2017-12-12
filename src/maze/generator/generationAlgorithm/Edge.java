package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */
class Edge {
	private final int _x;
	private final int _y;
	private final int _direction;

	public Edge(final int x, final int y, final int direction) {
		_x = x;
		_y = y;
		_direction = direction;
	}

	public int getDirection() {
		return _direction;
	}

	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}
}
