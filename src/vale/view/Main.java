package vale.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public Main()
    {
        this.main = this;
    }

    static Main main;

    static public Main getInstance()
    {
        return main;
    }

    public Stage stage;

    void replaceSceneContent(String fxml){
//        System.out.println(getClass().getResource("fxml/menu.fxml"));

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/" + fxml));
        Parent root = null;
        try {
            root = loader.load();
            if (root == null)
                System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(false);

    }


    @Override
    public void start(Stage stage) {
        this.stage = stage;
        try {
            replaceSceneContent("menu.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.stage.setTitle("NotFarmVerdura");
        this.stage.show();
    }

    public static void main(String[] args) {


        launch();
    }
}
