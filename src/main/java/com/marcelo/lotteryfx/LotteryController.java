package com.marcelo.lotteryfx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.*;

public class LotteryController implements Initializable{

    @FXML
    private ProgressBar pb;

    @FXML
    private ListView<String> lstViewResults;

    @FXML
    private ListView<String> lstViewBets;

    @FXML
    private ListView<String> lstViewCheck;

    @FXML
    private Button btnLoadResults;

    @FXML
    private Button btnLoadBets;

    @FXML
    private Button btnCheckBets;

    @FXML
    private Label lblResults;

    @FXML
    private Label lblBets;

    @FXML
    private Label lblWins;

    private final FileChooser fileChooser = new FileChooser();

    private final String LOADED = "Loaded";
    private final String RESULTS = "result(s)";
    private final String BETS = "bet(s)";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("G:\\MARCELO\\Programacao\\Cursos_Testes\\Java\\MegaSena"));
    }

    @FXML
    void checkBets(MouseEvent event) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Set<Integer> r : Results.getResultList()){
            for(Set<Integer> b : Bets.getBetList()) {
//                String[] bt = b.split(";");
                for (Integer s : b) {
                    if (r.contains(s)) {
                        stringBuilder.append(s);
                    }
                }
                if(stringBuilder.length()/2 >= 4){
                    lstViewCheck.getItems().add(stringBuilder.toString());
                }
                stringBuilder.delete(0, stringBuilder.length());
            };
        };
        lblWins.setText("Youn win(s) " + " " + lstViewCheck.getItems().size() + " " + BETS);
    }

    @FXML
    void loadBets(MouseEvent event) {
        lstViewBets.getItems().clear();

        File file = FilesUtils.getFile(BETS);

        LoadBets loadBets = new LoadBets(file, lstViewBets);
        loadBets.valueProperty().addListener(new ChangeListener<Long>() {
            @Override
            public void changed(ObservableValue<? extends Long> observableValue, Long aLong, Long t1) {
                lblBets.setText(LOADED + " " + t1 + " " + BETS);
                lstViewBets.scrollTo(lstViewBets.getItems().size()-1);
            }
        });

        pb.progressProperty().bind(loadBets.progressProperty());

        Thread thread = new Thread(loadBets);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    void loadResults(MouseEvent event)  {
        lstViewResults.getItems().clear();

        File file = FilesUtils.getFile(RESULTS);

        LoadResults loadResults = new LoadResults(file, lstViewResults);

        loadResults.valueProperty().addListener(new ChangeListener<Long>() {
            @Override
            public void changed(ObservableValue<? extends Long> observableValue, Long aLong, Long t1) {
                lblResults.setText(LOADED + " " + t1 + " " + RESULTS);
                lstViewResults.scrollTo(lstViewResults.getItems().size()-1);
            }
        });

        pb.progressProperty().bind(loadResults.progressProperty());

        Thread thread = new Thread(loadResults);
        thread.setDaemon(true);
        thread.start();

    }


}

