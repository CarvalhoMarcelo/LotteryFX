package com.marcelo.lotteryfx.tasks;

import com.marcelo.lotteryfx.models.Bets;
import com.marcelo.lotteryfx.models.Results;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LoadFile extends Task<Long> {

    @FXML
    private ListView<String> lstViewResults;

    @FXML
    private ListView<String> lstViewBets;

    File file;

    private final String type;

    public LoadFile(File file, ListView<String> lstView, String type){
        this.file = file;
        this.type = type;
        if(isResult(type)) {
            this.lstViewResults = lstView;
        } else {
            this.lstViewBets = lstView;
        }
    }

    @Override
    protected Long call() throws Exception {

        long i = 0;

        try {
            Scanner scanner = new Scanner(file);
            Path path = Paths.get(file.getPath());
            long lines = Files.lines(path).count();

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] list = line.split(";");
                String[] newList = new String[list.length];
                for(int x = 0; x < list.length; x++) {
                    newList[x] = list[x].replaceAll("[^0-9]", "");
                }
                if(isResult(type)){
                    lstViewResults.getItems().add(line);
                    Results.setResultList(getList(newList));
                } else {
                    lstViewBets.getItems().add(line);
                    Bets.setBetList(getList(newList));

                }

                updateProgress(i, lines);
                updateValue(i);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    private boolean isResult(String type){
        return type.contains("result");
    }

    private Set<Integer> getList(String[] list) {
        return Arrays.stream(list).map(Integer::valueOf).collect(Collectors.toSet());
    }


}
