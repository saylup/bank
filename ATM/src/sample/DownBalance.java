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

public class DownBalance {
    Pattern numeric = Pattern.compile("(\\d+)?");
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnDownBalance;
    @FXML
    private TextField sumBill;
    @FXML
    private TextField sum;
    @FXML
    private Button btnBack;
    void dialogWindow(String name, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(name);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void initialize(){
        try {
            //String FIO =Controller.cust.getSurname() + " " + Controller.cust.getName() + " " + Controller.cust.getPatronymic();
            //person.setText(FIO);
            String response = Request.getAccount(Controller.getNumCard(), Controller.getPin());
            if(!response.equals("Access denied") || !response.equals("Connection error")){
                Account account = new Gson().fromJson(response, Account.class);
                sumBill.setText(String.valueOf(account.getSum()));
            }
            else{
                System.out.println("Веселая сова сдохла");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void checkSum(){
        sum.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) sum.setText(oldValue);
            if (sum.getLength()>8) sum.setText(oldValue);
        });
    }
    @FXML
    void logOut() {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }
    @FXML
    void minusSum() {
        try {
            String str = Request.deleteMoney(Controller.getNumCard(), Controller.getPin(), Float.parseFloat(sum.getText()));
            if(str.equals("success")){
                dialogWindow("Внимание!", "Успешно");
                back();
            }
            else if(str.equals("Not enough money")){
                dialogWindow("Внимание!", "Недостаточно средств. Введите другое значение.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void back() {
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
        stage.setTitle("Банкомат");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
