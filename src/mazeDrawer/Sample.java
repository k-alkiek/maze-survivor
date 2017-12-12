package mazeDrawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import maze.generator.generationAlgorithm.Kruskal;

/**
 * @web java-buddy.blogspot.com
 */
public class Sample extends Application {

    public void drawCells(int[][] maze) {

    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 650, Color.WHITE);

        primaryStage.setTitle("testMaze");
        primaryStage.setScene(scene);
        primaryStage.show();


        //=============================
        Image image = null;
        try {
            image = new Image(new FileInputStream("wall.png"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int[][] maze;
        Kruskal tmp = new Kruskal(5, 5);
        tmp.draw();
        MazeGenerator m = new MazeGenerator(10, 10);
        m.display();
        maze = m.grid;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                //Setting the image view
                if (maze[i][j] == 1) {
                    ImageView imageView = new ImageView(image);

                    //Setting the position of the image
                    imageView.setX(5 + j * 50);
                    imageView.setY(5 + i * 50);

                    //setting the fit height and width of the image view
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);

                    //Setting the preserve ratio of the image view
                    imageView.setPreserveRatio(true);

                    root.getChildren().addAll(imageView);
                }
            }
        }
    }

    public static class MazeGenerator {
        private final int x;
        private final int y;
        public final int[][] maze;
        public int[][] grid;

        public MazeGenerator(int x, int y) {
            this.x = x;
            this.y = y;
            maze = new int[this.x][this.y];
            grid = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    grid[i][j] = 0;
                }
            }
            generateMaze(0, 0);
        }

        public void display() {
            for (int i = 0; i < y; i++) {
                // draw the north edge
                for (int j = 0; j < x; j++) {
                    System.out.print((maze[j][i] & 1) == 0 ? "+-" : "+ ");
                    if ((maze[j][i] & 1) == 0)
                        grid[j][i] = 1;
                }
                System.out.println("+");
                // draw the west edge
                for (int j = 0; j < x; j++) {
                    System.out.print((maze[j][i] & 8) == 0 ? "| " : "  ");
                    if ((maze[j][i] & 8) == 0)
                        grid[j][i] = 1;
                }
                System.out.println("|");
            }
            // draw the bottom line
            for (int j = 0; j < x; j++) {
                System.out.print("+-");
            }
            System.out.println("+");
        }

        private void generateMaze(int cx, int cy) {
            DIR[] dirs = DIR.values();
            Collections.shuffle(Arrays.asList(dirs));
            for (DIR dir : dirs) {
                int nx = cx + dir.dx;
                int ny = cy + dir.dy;
                if (between(nx, x) && between(ny, y)
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
            private DIR opposite;

            // use the static initializer to resolve forward references
            static {
                N.opposite = S;
                S.opposite = N;
                E.opposite = W;
                W.opposite = E;
            }

            private DIR(int bit, int dx, int dy) {
                this.bit = bit;
                this.dx = dx;
                this.dy = dy;
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}