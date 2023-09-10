package com.marcelo.lotteryfx;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoadBets extends Task<Long> {

    @FXML
    private final ListView<String> lstViewBets;

    File file;

    public LoadBets(File file, ListView<String> lstViewBets){
        this.file = file;
        this.lstViewBets = lstViewBets;
    }

    @Override
    protected Long call() throws Exception {
        long i = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String r = scanner.nextLine();

//                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(12), new EventHandler<ActionEvent>() {
//                        private long i = 1;
//                        @Override
//                        public void handle(ActionEvent event) {

                lstViewBets.getItems().add(r);
//                betSetList.add(Arrays.stream(r.split(";")).map(Integer::parseInt).collect(Collectors.toSet()));
                Bets.setBetList(Arrays.stream(r.split(";")).map(Integer::parseInt).collect(Collectors.toSet()));

                updateProgress(i, 6);
                updateValue(i);

//                        }
//                    }));
//                    timeline.play();
//                    Thread.sleep(150);
//                    lstBets.getItems().add(r);
//                    updateProgress(i, 3);
//                    updateValue(i);
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

}



