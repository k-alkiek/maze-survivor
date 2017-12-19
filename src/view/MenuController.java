package view;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * GUI controller for menu.
 * @author H
 *
 */
public class MenuController {

	@FXML
	private AnchorPane pane;

	@FXML
	public void launchMainMenu(KeyEvent ke) {
		System.out.println("Key event captured.");
		throw new RuntimeException("Exception Ahooo");
	}

}
