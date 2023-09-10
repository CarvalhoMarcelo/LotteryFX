package com.marcelo.lotteryfx.utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FilesUtils {

    private static final String DIRECTORY = "G:\\MARCELO\\Programacao\\Cursos_Testes\\Java\\MegaSena";
    private static final String USER_HOME = "user.home";

    public static File getFile(String type, FileChooser fileChooser){
        fileChooser.setTitle("Choose " + type);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV file", "*.csv"),
                new FileChooser.ExtensionFilter("Text file", "*.txt"),
                new FileChooser.ExtensionFilter("DIC file", "*.dic"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        return fileChooser.showOpenDialog(new Stage());
    }

    public static File setInitialDirectory(){
        File file = new File(DIRECTORY);
        if(!file.exists()) {
            file = new File(System.getProperty(USER_HOME));
        }
        return file;
    }

}
