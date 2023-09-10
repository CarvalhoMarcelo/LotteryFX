package com.marcelo.lotteryfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LotteryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LotteryApplication.class.getResource("lottery-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 787, 627);
        stage.setTitle("Lottery!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}