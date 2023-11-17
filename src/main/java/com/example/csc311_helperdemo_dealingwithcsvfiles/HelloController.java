package com.example.csc311_helperdemo_dealingwithcsvfiles;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextArea areaText;
    @FXML
    protected void onButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onOpenButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        File f=fileChooser.showOpenDialog(welcomeText.getScene().getWindow());

        if (f != null) {


            try {
                areaText.setText(Arrays.toString(readFile(f.getAbsolutePath())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    protected void onSaveButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        File f = fileChooser.showSaveDialog(welcomeText.getScene().getWindow());

        if (f != null) {
            try {
                writeFile(f.getAbsolutePath(), getData());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    //This method write into a file using String absolutePath, String[] data
    // it is called writeFile
    public void writeFile(String file, String[] data) throws IOException {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(Arrays.toString(data));
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + file + "'");
        }

    }



    //This method reads a file and returns a string array of the lines
    public  String[] readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line +"\n");
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    //ths method return the data to be written in a file
    public String[] getData(){
        return areaText.getText().split(",");
    }

}