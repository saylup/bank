package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.util.ArrayList;
import java.util.List;

public class Office {
    @FXML
    public TextField Balanse;
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnUpBalance;
    @FXML
    private Button btnDownBalance;

    //Добавить ФИО

    @FXML
    void initialize(){
        try {
            //String FIO =Controller.cust.getSurname() + " " + Controller.cust.getName() + " " + Controller.cust.getPatronymic();
            //person.setText(FIO);
            String response = Request.getAccount(Controller.getNumCard(), Controller.getPin());
            if(!response.equals("Access denied") || !response.equals("Connection error")){
                Account account = new Gson().fromJson(response, Account.class);
                Balanse.setText(String.valueOf(account.getSum()));
            }
            else{
                System.out.println("Веселая сова сдохла");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void logOut() {
            Stage stage = (Stage) btnLogOut.getScene().getWindow();
            stage.close();
    }

    @FXML
    void upBalance() {
            Stage stage = (Stage) btnUpBalance.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/upBalance.fxml"));
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

    @FXML
    void downBalance() {
        Stage stage = (Stage) btnDownBalance.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/downBalance.fxml"));
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
