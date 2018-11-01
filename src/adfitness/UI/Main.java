/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adfitness.UI;

import ADfitnessDb.service.Service;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author pc-dell
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
     File css = new File("ad.css");
        Parent root = FXMLLoader.load(getClass().getResource("afficherEquipements.fxml"));
        root.getStylesheets().clear();
      root.getStylesheets().add(getClass().getResource("ad.css").toString());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Gestion d'equipements");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
