package maze.generator.generationAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */
public class Kruskal extends VirtualMaze {
	// Define instance variables
	private boolean _animate = false;
	private float _delay = 0.0f;

	private List<List<Tree>> _sets;
	private Stack<Edge> _edges;

	//
	// Standard Constructors
	//
	public Kruskal() {
		super();
		initialize();
	}

	public Kruskal(final int w, final int h) {
		super(w, h);
		initialize();
	}

	//
	// Animating Constructor(s)
	//
	public Kruskal(final int w, final int h, final boolean animate, final float delay) {
		super(w, h);
		_animate = animate;
		_delay = delay;
		initialize();
	}

	public Kruskal(final int w, final int h, final boolean animate, final float delay, final long seed) {
		super(w, h, seed);
		_animate = animate;
		_delay = delay;
		initialize();
	}

	public Kruskal(final int w, final int h, final long seed) {
		super(w, h, seed);
		initialize();
	}

	/*************************************************
	 * Implement Kruskal's algorithm.
	 *
	 * (1) Randomly select an edge. (2) If the sets are not already connected,
	 * then (3) Connect the sets, and (4) Knock down the wall between the sets.
	 * (5) Repeat at Step 1.
	 *************************************************/
	private void carvePassages() {
		while (_edges.size() > 0) {
			// Select the next edge, and decide which direction we are going in.
			final Edge tmp = _edges.pop();
			final int x = tmp.getX();
			final int y = tmp.getY();
			final int direction = tmp.getDirection();
			final int dx = x + VirtualMaze.DX(direction), dy = y + VirtualMaze.DY(direction);

			// Pluck out the corresponding sets
			final Tree set1 = _sets.get(y).get(x);
			final Tree set2 = _sets.get(dy).get(dx);

			if (!set1.connected(set2)) {
				// If we are animating, display the VirtualMaze and pause
				if (_animate) {
					display();
					try {
						Thread.sleep((long) (_delay * 1000));
					} catch (final Exception ex) {
						ex.printStackTrace();
					}
				}

				// Connect the two sets and "knock down" the wall between them.
				set1.connect(set2);
				_grid[y][x] |= direction;
				_grid[dy][dx] |= VirtualMaze.OPPOSITE(direction);
			}
		}

		if (_animate) {
			// Display the final iteration
			display();

			// Output VirtualMaze metadata
			outputMetadata();
		}
	}

	/*****************************************************************
	 * Very similar, in terms of implementation, to the draw() method in the
	 * superclass, the main difference being that here we will color a cell gray
	 * if it remains unconnected.
	 *****************************************************************/
	public void display() {
		// Draw the "top row" of the VirtualMaze
		System.out.print((char) 27 + "[H");
		System.out.print(" ");
		for (int i = 0; i < _w * 2 - 1; ++i) {
			System.out.print("_");
		}
		System.out.println("");

		// Step through the grid/VirtualMaze, cell-by-cell
		for (final int[] element : _grid) {
			System.out.print("|");
			for (int x = 0; x < _grid[0].length; ++x) {
				// Start coloring, if unconnected
				if (element[x] == 0) {
					System.out.print((char) 27 + "[47m");
				}

				System.out.print((element[x] & VirtualMaze.S) != 0 ? " " : "_");
				if ((element[x] & VirtualMaze.E) != 0) {
					System.out.print(((element[x] | element[x + 1]) & VirtualMaze.S) != 0 ? " " : "_");
				} else {
					System.out.print("|");
				}

				// Stop coloring, if unconnected
				if (element[x] == 0) {
					System.out.print((char) 27 + "[m");
				}
			}
			System.out.println("");
		}
	}

	/*******************************************************************
	 * Method only need to be overridden if we are animating.
	 *
	 * If we are drawing the VirtualMaze statically, defer to the superclass.
	 ******************************************************************/
	@Override
	public void draw() {
		// Clear the screen
		System.out.print((char) 27 + "[2J");

		if (!_animate) {
			// Move to the upper left and defer to superclass.
			System.out.print((char) 27 + "[H");
			super.draw();
		} else {
			// Carve the passages and animate as we go
			carvePassages();
		}
	}

	private void initialize() {

		// Initialize the sets to the same dimension as the VirtualMaze.
		// We use Tree objects to represent the sets to be joined.
		_sets = new ArrayList<>();
		for (int y = 0; y < _h; ++y) {
			final List<Tree> tmp = new ArrayList<>();
			for (int x = 0; x < _w; ++x) {
				tmp.add(new Tree());
			}
			_sets.add(tmp);
		}

		// Build the collection of edges and randomize.
		// Edges are "north" and "west" sides of cell,
		// if index is greater than 0.
		_edges = new Stack<>();
		for (int y = 0; y < _h; ++y) {
			for (int x = 0; x < _w; ++x) {
				if (y > 0) {
					_edges.add(new Edge(x, y, VirtualMaze.N));
				}
				if (x > 0) {
					_edges.add(new Edge(x, y, VirtualMaze.W));
				}
			}
		}
		shuffle(_edges);

		if (!_animate) {
			carvePassages();
		}
	}

	/**
	 * Randomly shuffle a List.
	 *
	 * @param args
	 *            List (of Edges) to be randomly shuffled.
	 */
	private void shuffle(final List<Edge> args) {
		for (int i = 0; i < args.size(); ++i) {
			final int pos = _random.nextInt(args.size());
			final Edge tmp1 = args.get(i);
			final Edge tmp2 = args.get(pos);
			args.set(i, tmp2);
			args.set(pos, tmp1);
		}
	}
}
