package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */
class Tree {

	private Tree _parent = null;

	public Tree() {

	}

	public void connect(final Tree tree) {
		tree.root().setParent(this);
	}

	public boolean connected(final Tree tree) {
		return this.root() == tree.root();
	}

	public Tree root() {
		return _parent != null ? _parent.root() : this;
	}

	public void setParent(final Tree parent) {
		this._parent = parent;
	}
}
