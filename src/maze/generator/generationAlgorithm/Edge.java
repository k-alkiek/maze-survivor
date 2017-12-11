package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */
class Edge {
    private int _x;
    private int _y;
    private int _direction;

    public Edge(int x, int y, int direction) {
        _x = x;
        _y = y;
        _direction = direction;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public int getDirection() {
        return _direction;
    }
}
