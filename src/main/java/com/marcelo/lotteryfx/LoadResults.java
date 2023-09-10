package com.marcelo.lotteryfx;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoadResults extends Task<Long> {

    @FXML
    private final ListView<String> lstViewResults;

    File file;

    public LoadResults(File file, ListView<String> lstViewResults){
        this.file = file;
        this.lstViewResults = lstViewResults;
    }

    @Override
    protected Long call() throws Exception {
        long i = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String r = scanner.nextLine();
                String[] rr = r.split(";");
                String[] xx = new String[rr.length];
                for(int y = 0; y < rr.length; y++) {
                    xx[y] = rr[y].replaceAll("[^0-9]", "");
                }
                lstViewResults.getItems().add(r);

                Results.setResultList(Arrays.stream(xx).map(Integer::valueOf).collect(Collectors.toSet()));

                updateProgress(i, 2549);
                updateValue(i);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

}
