package monsters.commands;

import javafx.scene.image.ImageView;
import monsters.Monster;
import objects.ClonedObject;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public class MoveDown implements MoveCommand {
    @Override
    public boolean execute(Monster monster) {
        int speed = monster.getSpeed();
        ImageView clone = ClonedObject.getClone();
        clone.setX(monster.getX() + 10);
        clone.setY(monster.getY() + 10 + speed);
        if (!monster.isCollided(clone)) {
            monster.setY(monster.getY() + speed);
            return true;
        }
        return false;
    }
}
