package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */

import java.util.Random;

public class VirtualMaze {
	// Define class variables
	public static final int N = 1;
	public static final int S = 2;
	public static final int E = 4;
	public static final int W = 8;

	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 10;

	// Define class methods
	public static int DX(final int direction) {
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

	public static int DY(final int direction) {
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

	public static int OPPOSITE(final int direction) {
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

	protected Random _random = null;
	protected Long _seed = null;
	protected int _w = 0;
	protected int _h = 0;

	protected int[][] _grid = null;

	protected boolean[][] maze;

	/**
	 * Initialize a new 2D maze with, optionally supply the width, height and
	 * seed.
	 * <p>
	 * Default seed will give "random" behavior. User-supplied seed value will
	 * give "deterministic" behavior.
	 */
	public VirtualMaze() {
		this(VirtualMaze.DEFAULT_WIDTH, VirtualMaze.DEFAULT_HEIGHT);
	}

	public VirtualMaze(final int w, final int h) {
		initialize(w, h);
		_random = new Random();
	}

	public VirtualMaze(final int w, final int h, final long seed) {
		initialize(w, h);
		_random = new Random(seed);
		_seed = new Long(seed);
	}

	/**
	 * Draw the grid, starting in the upper-left hand corner.
	 */
	public void draw() {
		// draw the "top" line

		System.out.print(" ");
		for (int i = 0; i < _w * 2 - 1; ++i) {
			System.out.print("_");
		}
		System.out.println("");

		// draw each row
		for (int j = 0; j < _h; ++j) {
			System.out.print("|");
			for (int i = 0; i < _w; ++i) {
				// render "bottom" using the "S" switch
				System.out.print((_grid[j][i] & VirtualMaze.S) != 0 ? " " : "=");

				// render "side" using "E" switch
				if ((_grid[j][i] & VirtualMaze.E) != 0) {
					System.out.print(((_grid[j][i] | _grid[j][i + 1]) & VirtualMaze.S) != 0 ? " " : "=");
				} else {
					System.out.print("|");
				}
			}
			System.out.println("");
		}

		// output maze metadata
		outputMetadata();
	}

	private void initialize(final int w, final int h) {
		_w = w;
		_h = h;
		_grid = new int[h][w];
		maze = new boolean[2 * h + 2][2 * w + 2];
		for (int j = 0; j < h; ++j) {
			for (int i = 0; i < w; ++i) {
				_grid[j][i] = 0;
			}
		}
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
}
