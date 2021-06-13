package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class Controller {
    Pattern numeric = Pattern.compile("(\\d+\\d*)?");
    @FXML
    private TextField numCard;
    @FXML
    private TextField pin;
    @FXML
    private Button btnLogIn;
    @FXML
    void checkPin(){
        pin.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) pin.setText(oldValue);
            if (pin.getLength()>4) pin.setText(oldValue);
        });
    }
    @FXML
    void checkNumCard(){
        numCard.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) numCard.setText(oldValue);
            if (numCard.getLength()>16) numCard.setText(oldValue);
        });
    }
    @FXML
    void logIn() {
            if (getNumCard().isEmpty() == true || getPin().isEmpty()==true || getNumCard().length()<16 || getPin().length()<4) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warring");
                alert.setHeaderText(null);
                alert.setContentText("Не все поля заполнены!");
                alert.showAndWait();
            }
            else {
                Stage stage = (Stage) btnLogIn.getScene().getWindow();
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
                stage.setTitle("Банкомат");
                stage.setScene(new Scene(root1));
                stage.show();
            }
    }
    public String getNumCard() {
        return numCard.getText();
    }

    public String getPin() {
        return pin.getText();
    }
}
