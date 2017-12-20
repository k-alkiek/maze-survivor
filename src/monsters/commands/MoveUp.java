package monsters.commands;

import javafx.scene.image.ImageView;
import monsters.Monster;
import objects.ClonedObject;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class MoveUp implements MoveCommand {
    @Override
    public boolean execute(Monster monster) {
        int speed = monster.getSpeed();
        ImageView clone = ClonedObject.getClone();
        clone.setX(monster.getX() + 10);
        clone.setY(monster.getY() + 10 - speed);
        if (!monster.isCloneCollided(clone)) {
            monster.setY(monster.getY() - speed);
            monster.setAngle(270);
            return true;
        }
        return false;
    }
}
