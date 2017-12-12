package mazeDrawer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @web java-buddy.blogspot.com
 */
public class Sample extends Application {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {
		Application.launch(args);
	}

	public void drawCells(final int[][] maze) {

	}

	@Override
	public void start(final Stage primaryStage) {
		final Group root = new Group();
		final Scene scene = new Scene(root, 1024, 650, Color.WHITE);

		primaryStage.setTitle("testMaze");
		primaryStage.setScene(scene);
		primaryStage.show();

		// =============================
		Image image = null;
		try {
			image = new Image(new FileInputStream("wall.png"));
		} catch (final FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final int[][] maze = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				// Setting the image view
				if (maze[i][j] == 1) {
					final ImageView imageView = new ImageView(image);

					// Setting the position of the image
					imageView.setX(5 + j * 50);
					imageView.setY(5 + i * 50);

					// setting the fit height and width of the image view
					imageView.setFitHeight(50);
					imageView.setFitWidth(50);

					// Setting the preserve ratio of the image view
					imageView.setPreserveRatio(true);

					root.getChildren().addAll(imageView);
				}
			}
		}
	}

}