package com.marcelo.lotteryfx;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilesUtils {

    private static final FileChooser fileChooser = new FileChooser();
    public static File getFile(String type){
        fileChooser.setTitle("Choose " + type);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV file", "*.csv"),
                new FileChooser.ExtensionFilter("Text file", "*.txt"),
                new FileChooser.ExtensionFilter("DIC file", "*.dic"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        return fileChooser.showOpenDialog(new Stage());
    }

}
