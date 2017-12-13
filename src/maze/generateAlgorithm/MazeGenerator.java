package maze.generateAlgorithm;


import java.util.Arrays;
import java.util.Collections;

/**
 * Created by khaledabdelfattah on 12/12/17.
 */
public class MazeGenerator {
    private final int width, height;
    private final int[][] maze;

    public MazeGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new int[this.width][this.height];
        generateMaze(0, 0);
    }

    public String getMaze() {
        StringBuilder printedMaze = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                printedMaze.append((maze[j][i] & 1) == 0 ? "11" : "1 ");
            }
            printedMaze.append("1\n");
            for (int j = 0; j < width; j++) {
                printedMaze.append((maze[j][i] & 8) == 0 ? "1 " : "  ");
            }
            printedMaze.append("1\n");
        }
        for (int j = 0; j < width; j++) {
            printedMaze.append("11");
        }
        printedMaze.append("1\n");
        return printedMaze.toString();
    }

    private void generateMaze(int cx, int cy) {
        MazeGenerator.DIR[] dirs = MazeGenerator.DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (MazeGenerator.DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, width) && between(ny, height)
                    && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private MazeGenerator.DIR opposite;

        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    }

}