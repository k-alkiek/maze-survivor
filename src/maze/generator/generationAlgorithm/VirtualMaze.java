package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */

import java.util.Arrays;
import java.util.Random;

public class VirtualMaze {
    // Define class variables
    public static final int N = 1;
    public static final int S = 2;
    public static final int E = 4;
    public static final int W = 8;

    public static final int DEFAULT_WIDTH = 10;
    public static final int DEFAULT_HEIGHT = 10;

    protected Random _random = null;
    protected Long _seed = null;
    protected int _w = 0;
    protected int _h = 0;
    protected int[][] _grid = null;
    protected int[][] maze;

    // Define class methods
    public static int DX(int direction) {
        switch (direction) {
            case VirtualMaze.E:
                return +1;
            case VirtualMaze.W:
                return -1;
            case VirtualMaze.N:
            case VirtualMaze.S:
                return 0;
        }
        // error condition, but should never reach here
        return -1;
    }

    public static int DY(int direction) {
        switch (direction) {
            case VirtualMaze.E:
            case VirtualMaze.W:
                return 0;
            case VirtualMaze.N:
                return -1;
            case VirtualMaze.S:
                return 1;
        }
        // error condition, but should never reach here
        return -1;
    }

    public static int OPPOSITE(int direction) {
        switch (direction) {
            case VirtualMaze.E:
                return VirtualMaze.W;
            case VirtualMaze.W:
                return VirtualMaze.E;
            case VirtualMaze.N:
                return VirtualMaze.S;
            case VirtualMaze.S:
                return VirtualMaze.N;
        }
        // error condition, but should never reach here
        return -1;
    }


    /**
     * Initialize a new 2D maze with, optionally supply the width, height and seed.
     * <p>
     * Default seed will give "random" behavior.
     * User-supplied seed value will give "deterministic" behavior.
     */
    public VirtualMaze() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public VirtualMaze(int w, int h) {
        initialize(w, h);
        _random = new Random();
    }

    public VirtualMaze(int w, int h, long seed) {
        initialize(w, h);
        _random = new Random(seed);
        _seed = new Long(seed);
    }

    private void initialize(int w, int h) {
        _w = w;
        _h = h;
        _grid = new int[h][w];
        maze = new int[2 * h + 1][2 * w + 1];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = 0;
            }
        }
        for (int j = 0; j < h; ++j) {
            for (int i = 0; i < w; ++i) {
                _grid[j][i] = 0;
            }
        }
    }

    /**
     * Draw the grid, starting in the upper-left hand corner.
     */
    public void draw() {
        // draw the "top" line
        int idxX = 0, idxY = 0;
        System.out.print(" ");
        for (int i = 0; i < (_w * 2 - 1); ++i) {
            System.out.print("_");
            maze[idxY][idxX++] = 1;
        }
        idxY++;
        idxX = 1;
        System.out.println();

        // draw each row
        for (int j = 0; j < _h; ++j) {
            maze[idxY][idxX++] = 1;
            System.out.print("|");
            for (int i = 0; i < _w; ++i) {
                // render "bottom" using the "S" switch
                System.out.print((_grid[j][i] & VirtualMaze.S) != 0 ? " " : "_");
                if ((_grid[j][i] & VirtualMaze.S) == 0) {
                    maze[idxY + 1][idxX] = 1;
                }
                // render "side" using "E" switch
                if ((_grid[j][i] & VirtualMaze.E) != 0) {
                    System.out.print(((_grid[j][i] | _grid[j][i + 1]) & VirtualMaze.S) != 0 ? " " : "_");
                    if (((_grid[j][i] | _grid[j][i + 1]) & VirtualMaze.S) == 0) {
                        maze[idxY + 1][idxX] = 1;
                    }
                } else {
                    maze[idxY][idxX] = 1;
                    System.out.print("|");
                }
                idxX++;
            }
            idxY += 2;
            idxX = 1;
            System.out.println();
        }

        // output maze metadata
        outputMetadata();
    }

    protected void outputMetadata() {
        String meta = " " + _w + " " + _h;
        if (_seed != null) {
            meta += " " + _seed;
        } else {
            meta += " random";
        }
        System.out.println(meta);
    }

    public static void main(String[] args) {
        Kruskal maze = new Kruskal();
        maze.draw();
    }
}
