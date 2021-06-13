package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class Transaction {
    Pattern numeric = Pattern.compile("(\\d+\\d*)?");
    Pattern sum = Pattern.compile("(\\d+\\.?\\d{0,2})?");
    @FXML
    private Button btnBack;
    @FXML
    private TextField numOwnCard;
    @FXML
    private TextField numCard;
    @FXML
    private TextField sumTransaction;
    @FXML
    void backToOffice() {
        btnBack.setOnAction(event -> {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/office.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Личный кабинет");
            stage.setScene(new Scene(root1));
            stage.show();
        });
    }
    @FXML
    void checkOwnNum(){
        numOwnCard.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) numOwnCard.setText(oldValue);
            if (numOwnCard.getLength()>16) numOwnCard.setText(oldValue);
        });
    }
    @FXML
    void checkNum(){
        numCard.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) numCard.setText(oldValue);
            if (numCard.getLength()>16) numCard.setText(oldValue);
        });
    }
    @FXML
    void checkSum(){
        sumTransaction.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!sum.matcher(newValue).matches()) sumTransaction.setText(oldValue);
        });
    }
}
