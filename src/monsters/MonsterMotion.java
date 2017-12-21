package monsters;

import javafx.geometry.Point2D;

import java.util.*;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class MonsterMotion {
    private char[][] maze;
    private Node[][] grid;
    private boolean[][] visited;

    public MonsterMotion(char[][] maze) {
        this.maze = maze;
        initialize();
    }


    private void initialize() {
        grid = new Node[maze.length][maze.length];
        visited = new boolean[maze.length][maze.length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                grid[i][j] = new Node(new Point2D(j, i), null);
                visited[i][j] = false;
            }
        }
    }


    public List<Point2D> getPath(Node start, Node end) {
        Queue<Node> queue = new ArrayDeque<>(),
                pathQueue = new ArrayDeque<>();
        queue.add(start);
        int xCoordinate = start.getX(),
                yCoordinate = start.getY();
        visited[yCoordinate][xCoordinate] = true;
        Node currentPoint = null;
        while (!queue.isEmpty()) {
            currentPoint = queue.remove();

            if (currentPoint.getX() == end.getX() && currentPoint.getY() == end.getY())
                break;

            xCoordinate = currentPoint.getX();
            yCoordinate = currentPoint.getY();
            visited[yCoordinate][xCoordinate] = true;

            if (isValid(yCoordinate, xCoordinate - 1)) {
                queue.add(grid[yCoordinate][xCoordinate - 1]);
                grid[yCoordinate][xCoordinate - 1].setParent(currentPoint);
            }

            if (isValid(yCoordinate - 1, xCoordinate)) {
                queue.add(grid[yCoordinate - 1][xCoordinate]);
                grid[yCoordinate - 1][xCoordinate].setParent(currentPoint);
            }

            if (isValid(yCoordinate, xCoordinate + 1)) {
                queue.add(grid[yCoordinate][xCoordinate + 1]);
                grid[yCoordinate][xCoordinate + 1].setParent(currentPoint);
            }

            if (isValid(yCoordinate + 1, xCoordinate)) {
                queue.add(grid[yCoordinate + 1][xCoordinate]);
                grid[yCoordinate + 1][xCoordinate].setParent(currentPoint);
            }
        }
        List<Point2D> path = new ArrayList<>();
        while (currentPoint.getParent() != null) {
            pathQueue.add(currentPoint);
            currentPoint = currentPoint.getParent();
        }
        pathQueue.add(start);
        for (int i = pathQueue.size() - 1; i >= 0; i--) {
            currentPoint = pathQueue.remove();
            path.add(new Point2D(currentPoint.getY(), currentPoint.getX()));
        }
        return path;
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || j >= grid[0].length || j < 0 || i >= grid.length) {
            return false;
        } else if (maze[i][j] != '1') {
            return false;
        } else if (visited[i][j])
            return false;
        return true;
    }

    public static class Node {
        private Point2D point;
        private Node parent;

        public Node(Point2D point, Node parent) {
            this.point = point;
            this.parent = parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }


        public int getX() {
            return (int) this.point.getX();
        }

        public int getY() {
            return (int) this.point.getY();
        }
    }

    public static void main(String[] args) {
        char[][] maze = {{'0', '1', '1', '0', '1'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'}
        };
        MonsterMotion m = new MonsterMotion(maze);
        List<Point2D> path = m.getPath(new Node(new Point2D(4, 4), null),
                new Node(new Point2D(0, 0), null));
        for (Point2D i : path) {
            System.out.println(i.getX() + " " + i.getY());
        }
    }
}
