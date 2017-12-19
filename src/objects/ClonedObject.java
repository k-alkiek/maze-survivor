package objects;

import javafx.scene.image.ImageView;

public class ClonedObject {
	private static ImageView clonedObject = new ImageView();
    
	private ClonedObject() {
		//Prevent clients from instantiating this class.
	}
	
	public static ImageView getClone() {
		return clonedObject;
	}
	
	public static void initializeClonedObjectDimentions(int dim) {
		clonedObject.setFitHeight(dim - 40);
		clonedObject.setFitWidth(dim - 40);
		clonedObject.setPreserveRatio(true);
	}
}
