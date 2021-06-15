package sample;


import com.google.gson.Gson;
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
    static Customer cust;
    static int numcard, Pin;
    @FXML
    private TextField numCard;
    @FXML
    private TextField pin;
    @FXML
    private Button btnLogIn;

    void dialogWindow(String name, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
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
        String str = null;
        if (numCard.getText().length()==0 || pin.getText().length()==0){
            dialogWindow("Ошибка!", "Не все поля заполнены!");
        }
        else {
            numcard = Integer.parseInt(numCard.getText());
            Pin = Integer.parseInt(pin.getText());

            try {
                str = Request.getAccount(Integer.parseInt(numCard.getText()), Integer.parseInt(pin.getText()));
                if (!str.equals("Access denied") && !str.equals("Server Error")) {
                    System.out.println("Веселая сова жива");
                    cust = new Gson().fromJson(str, Customer.class);
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
                } else if (numCard.getText().isEmpty() || pin.getText().isEmpty() || numCard.getText().length() < 16 || pin.getText().length() < 4) {
                    dialogWindow("Внимание!", "Не все поля заполнены!");
                    System.out.println("Веселая сова сдохла");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getNumCard() {
        return numcard;
    }

    public static int getPin() {
        return Pin;
    }
}
