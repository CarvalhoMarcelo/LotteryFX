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
import javafx.stage.Stage;

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
//    private List<String> resultsList = new ArrayList<>();
//    private List<String> betsList = new ArrayList<>();

    public static Set<Set<Integer>> betSetList = new HashSet<>();

    private final String LOADED = "Loaded";
    private final String RESULTS = "result(s)";
    private final String BETS = "bet(s)";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser.setInitialDirectory(new File("G:\\MARCELO\\Programacao\\Cursos_Testes\\Java\\MegaSena"));
    }

    @FXML
    void checkBets(MouseEvent event) {
//        pb.setProgress(0);

        StringBuilder stringBuilder = new StringBuilder();

        for (Set<Integer> r : Results.getResultList()){
            for(Set<Integer> b : betSetList) {
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

        File file = getFile(BETS);

        LoadBets loadBets = new LoadBets(file, lstViewBets);
        loadBets.valueProperty().addListener(new ChangeListener<Long>() {
            @Override
            public void changed(ObservableValue<? extends Long> observableValue, Long aLong, Long t1) {
                lblBets.setText(LOADED + " " + t1 + " " + BETS);
                lstViewBets.scrollTo(lstViewBets.getItems().size()-1);
//                betsList = lstBets.getItems();
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

        File file = getFile(RESULTS);

        LoadResults loadResults = new LoadResults(file, lstViewResults);
/*        loadResults.call(getFile(RESULTS));

        lblResults.setText(LOADED + " " + Results.getResultList().size() + " " + RESULTS);
        lstViewResults.scrollTo(lstViewResults.getItems().size()-1);*/

        loadResults.valueProperty().addListener(new ChangeListener<Long>() {
            @Override
            public void changed(ObservableValue<? extends Long> observableValue, Long aLong, Long t1) {
                lblResults.setText(LOADED + " " + t1 + " " + RESULTS);
                lstViewResults.scrollTo(lstViewResults.getItems().size()-1);
//                betsList = lstBets.getItems();
            }
        });

        pb.progressProperty().bind(loadResults.progressProperty());

        Thread thread = new Thread(loadResults);
        thread.setDaemon(true);
        thread.start();


    }

    private File getFile(String type){
        fileChooser.setTitle("Choose " + type);
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV file", "*.csv"),
                new FileChooser.ExtensionFilter("Text file", "*.txt"),
                new FileChooser.ExtensionFilter("DIC file", "*.dic"),
                new FileChooser.ExtensionFilter("All files", "*.*"));
        File file = fileChooser.showOpenDialog(new Stage());
//        String filePath = file.getAbsolutePath();
        return file;
    }

/*
    private class LoadBets extends Task<Long> {

        File file;

        public LoadBets(File file){
            this.file = file;
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
                            betSetList.add(Arrays.stream(r.split(";")).map(Integer::parseInt).collect(Collectors.toSet()));
                            updateProgress(i, 3);
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
*/


}

