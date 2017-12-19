package objects;

import game.GameEngine;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents any game object that requires being updated every frame.
 *
 * @author H
 */
public abstract class GameObject {

    protected double x;

    protected double y;

    protected double angle;

    protected ImageView imageView;

    protected GameEngine gameEngine;

    protected Image image;

    public void setSprite(Image image) {
        this.image = image;
    }

    /**
     * @return the gameEngine
     */
    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public GameObject(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.x = 0;
        this.y = 0;
        this.angle = 0;

        initializeImageView();
    }

    public GameObject(GameEngine gameEngine, double x, double y) {
        this.gameEngine = gameEngine;
        this.x = x;
        this.y = y;
        this.angle = 0;

        initializeImageView();
    }


    public GameObject(GameEngine gameEngine, double x, double y, double angle) {
        this.gameEngine = gameEngine;
        this.x = x;
        this.y = y;
        this.angle = angle;

        initializeImageView();
    }

    private void initializeImageView() {
        this.imageView = new ImageView();
        imageView.setFitHeight(70);
        imageView.setFitWidth(70);
        imageView.setPreserveRatio(true);
        gameEngine.addGameObject(this);
        gameEngine.getPane().getChildren().add(imageView);
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @param angle the angle to set
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * Updates the game object.
     */
    public abstract void update();

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
}
