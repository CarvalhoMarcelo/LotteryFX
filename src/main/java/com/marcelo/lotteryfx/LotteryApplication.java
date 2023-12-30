package com.marcelo.lotteryfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LotteryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LotteryApplication.class.getResource("lottery-view.fxml"));

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double height = screenBounds.getHeight()/2;
        double width  = screenBounds.getWidth()/2;

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("Lottery!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}