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
    private Button butTransaction;
    void dialogWindow(String name, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void backToOffice() {
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
    }
    @FXML
    void checkOwnNum(){
        numOwnCard.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) numOwnCard.setText(oldValue);
            if (numOwnCard.getLength()>20) numOwnCard.setText(oldValue);
        });
    }
    @FXML
    void checkNum(){
        numCard.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) numCard.setText(oldValue);
            if (numCard.getLength()>20) numCard.setText(oldValue);
        });
    }
    @FXML
    void checkSum(){
        sumTransaction.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!sum.matcher(newValue).matches()) sumTransaction.setText(oldValue);
        });
    }

    @FXML
    void translate(){
        try {
            String response, step;
            if(numCard.getText().length()<20 || numOwnCard.getText().length()<20 || sumTransaction.getText().length()==0){
                dialogWindow("Ошибка!", "Введены некоректные данные!");
            }
            else {
                response = Request.internalTransfer(Controller.getLogIn(), Controller.getPassword(), Integer.parseInt(numOwnCard.getText().substring(18)),  //Между своими счетам
                        Integer.parseInt(numCard.getText().substring(18)), Float.parseFloat(sumTransaction.getText()));

                step = Request.externalTransfer(Controller.getLogIn(), Controller.getPassword(), Integer.parseInt(numOwnCard.getText().substring(18)),  //Другому пиплу
                        Integer.parseInt(numCard.getText().substring(18)), Float.parseFloat(sumTransaction.getText()));

                if (step.equals("success")) {
                    System.out.println("Перевод done");
                    dialogWindow("Информационное сообщение", "Заявка на перевод отправлена.");
                    System.out.println("Сова очень Богатая");
                } else if (response.equals("success")) {
                    dialogWindow("Информационное сообщение", "Перевод выполнен.");
                    System.out.println("Сова Богатая");
                }
                else {
                    dialogWindow("Ошибка!", "Введены некоректные данные!");
                }
            }
        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}

