package monsters;

import game.GameEngine;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import maze.drawer.MazeDrawer;
import monsters.states.MonsterIdleState;
import monsters.states.MonsterState;
import monsters.states.MonsterWalkingState;
import objects.CollidableGameObject;

import java.util.List;

/**
 * Created by khaledabdelfattah on 12/17/17.
 */
public class Monster extends CollidableGameObject {
    // monster have an instance of Monster State -> currentState
    private MonsterState currentState;
    // and have a sprite image

    private int speed = 3;


    private int idx = 0, perFrame = 0;
    private List<Point2D> path;

    public Monster(GameEngine gameEngine, int x, int y) {
        super(gameEngine, x, y);
        currentState = new MonsterWalkingState();
        imageView.setFitWidth(70);
//        MonsterMotion m = new MonsterMotion(MazeDrawer.maze);
//        path = m.getPath(new MonsterMotion.Node(new Point2D(1, 1), null),
//                new MonsterMotion.Node(new Point2D(MazeDrawer.maze.length - 3, MazeDrawer.maze.length - 3), null));
    }

    @Override
    public void update() {
        angle = Math.toDegrees(Math.atan2(-1 * imageView.getY(), -1 * imageView.getX()));
        imageView.setRotate(angle);
        currentState.update(this);
        draw(image);
        if (collidedWithPlayer())
            System.out.println("Die");
//        perFrame++;
//        if (idx < path.size() && perFrame > 20) {
//            this.setY(5 + path.get(idx).getX() * 70);
//            this.setX(5 + path.get(idx).getY() * 70);
//            idx++;
//            perFrame = 0;
//        }
    }

    // method to set current sprite
    public void setCurrentState(MonsterState currentState) {
        this.currentState = currentState;
    }

    // method to set current state

    public int getSpeed() {
        return speed;
    }

    private boolean collidedWithPlayer() {
        ImageView player = gameEngine.getPlayer().getImageView();
        return player.getBoundsInLocal().intersects(this.getImageView().getBoundsInLocal());
    }
}
