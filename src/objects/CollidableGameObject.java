package objects;

import java.util.List;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mine.Mine;
import wall.Wall;

/**
 * Represents a game object that may collide with other objects.
 *
 * @author H
 */
public abstract class CollidableGameObject extends GameObject {

    protected ImageView imageView;

    protected Image image;

	public CollidableGameObject(GameEngine gameEngine) {
		super(gameEngine);
		initializeImageView();
	}

	public CollidableGameObject(GameEngine gameEngine, double x, double y) {
		super(gameEngine, x, y);
		initializeImageView();
	}

    private void initializeImageView() {
        this.imageView = new ImageView();
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        gameEngine.getPane().getChildren().add(imageView);
    }

    /**
     * Checks whether this game object collides with another game object.
     *
     * @param other
     * @return
     */
    public boolean collidesWith(final GameObject other) {
    	if (other instanceof CollidableGameObject) {
    		return this.getImageView().getBoundsInParent().intersects(((CollidableGameObject) other).getImageView().getBoundsInParent());
    	} else {
    		return false;
    	}
    }

	public boolean isCloneCollided(final ImageView objectImage) {
		List<GameObject> gameObjects = gameEngine.getGameObjects();
		for (GameObject gameObject : gameObjects) {
			if (gameObject instanceof Wall && this.collides(objectImage, (Wall) gameObject)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean collides(final ImageView objectColne, CollidableGameObject other) {
		return objectColne.getBoundsInLocal().intersects(other.getImageView().getBoundsInLocal());
	}

    /**
     * @return the image view representing the game object
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Render the game object on the screen
     *
     * @param sprite image object to render
     */
    public void draw(Image sprite) {
        imageView.setImage(sprite);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setRotate(angle);
    }

	public void setSprite(Image image) {
		this.image = image;
	}

}
