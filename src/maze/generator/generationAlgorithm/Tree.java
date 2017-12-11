package maze.generator.generationAlgorithm;

/**
 * Created by khaledabdelfattah on 12/11/17.
 */
class Tree {

    private Tree _parent = null;

    public Tree() {

    }

    public Tree root() {
        return _parent != null ? _parent.root() : this;
    }

    public boolean connected(Tree tree) {
        return this.root() == tree.root();
    }

    public void connect(Tree tree) {
        tree.root().setParent(this);
    }

    public void setParent(Tree parent) {
        this._parent = parent;
    }
}
