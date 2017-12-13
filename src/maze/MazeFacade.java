package maze;

import maze.generateAlgorithm.MazeGenerator;

/**
 * Created by khaledabdelfattah on 12/12/17.
 */
public class MazeFacade {
    private int width, height;

    public MazeFacade(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String generateMaze() {
        MazeGenerator generator = new MazeGenerator(width, height);
        return generator.getMaze();
    }
}
