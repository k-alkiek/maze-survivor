package wall;

import java.util.HashMap;

import javafx.scene.image.ImageView;

public class wallFactory {

	   public static Wall getWall(String wall) {

	      if(wall.equals(NDWall.NOT_DESTRUCTABLE_WALL)) {

	      } else if (wall.equals(DestructibleWall.DESTRUCTABLE_WALL)) {

	      }
	      return null;
	   }
}
