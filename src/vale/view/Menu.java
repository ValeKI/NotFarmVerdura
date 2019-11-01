package vale.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Menu {

    @FXML
    void exitGame(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void newGame(ActionEvent event) {
        Main.getInstance().replaceSceneContent("game.fxml");
    }
}
