package com.marcelo.lotteryfx.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CustomExceptions {

//    public static void showExceptionDialog(Throwable throwable) {
    public static void showExceptionDialog() {
//        throwable.printStackTrace();/*w ww. j a  va2s.  c  o m*/

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("No value as set into the amount box");
        alert.setHeaderText("Thrown Exception");
        alert.setContentText("No value as set into the amount box.");

//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        throwable.printStackTrace(pw);
//        String exceptionText = sw.toString();
        String exceptionText = "It is mandatory to choose a number higher than 0 to proceed!";
        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }


}
