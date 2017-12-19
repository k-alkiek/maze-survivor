package monsters.commands;

import monsters.Monster;

/**
 * Created by khaledabdelfattah on 12/19/17.
 */
public interface MoveCommand {
    boolean execute(Monster monster);
}
