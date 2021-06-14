package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Office {
    @FXML
    public TextField balanceSum = new TextField();
    @FXML
    public TextField balanceBill = new TextField();;
    @FXML
    private TextField balanceCard;
    @FXML
    private TextField balanceCredit;
    @FXML
    private TextField balanceSaving;
    @FXML
    private TextField creditNum;
    @FXML
    private TextField creditCard;
    @FXML
    private Label person;
    @FXML
    private Button btnCreateCredit;
    @FXML
    private Button btnCountCredit;
    @FXML
    private Button butTrans;
    @FXML
    private Button btnHistory;
    @FXML
    private Button butnAutomats;
    @FXML
    private Label numBill;
    @FXML
    private Label numCard;
    String str = null;

    @FXML
    void initialize(){
        write();
    }

    @FXML
    void transactoin() {
            Stage stage = (Stage) butTrans.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/transaction.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Перевод");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    void history() {
            Stage stage = (Stage) btnHistory.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/history.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("История операций");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    void exit() {
        Stage stage = (Stage) btnHistory.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/sample.fxml"));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("LogIn");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    void maps() {
            Stage stage = (Stage) butnAutomats.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/maps.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Карты");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    @FXML
    void countCredit() {
            Stage stage = (Stage) btnCountCredit.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/countCredit.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Рассчёт кредита");
            stage.setScene(new Scene(root1));
            stage.show();
    }

    void write(){
        //Ещё надо ФИО добавить
        try {
            //System.out.println(Controller.cust.getName());
            String response = Request.getAccounts(Controller.getLogIn(), Controller.getPassword());
            ArrayList<Account> yourArray = new Gson().fromJson(response, new TypeToken<List<Account>>(){}.getType());
            if(!response.equals("Access denied") || !response.equals("Connection error")){
                System.out.println(response);
                for(Account account:yourArray){
                    System.out.println(account.getType());
                    if(account.getType().equals("debit")){
                        balanceSum.setText(String.valueOf(account.getSum()));
                        balanceBill.setText(String.valueOf(account.getNumber()));
                        balanceCard.setText("4081 7819 1230 00"+String.valueOf(account.getNumberCard()));
                    }
                    else if(account.getType().equals("credit")){
                        balanceCredit.setText(String.valueOf(account.getSum()));
                        creditNum.setText(String.valueOf(account.getNumber()));
                        creditCard.setText("4081 7819 1230 00"+String.valueOf(account.getNumberCard()));
                        //Карта
                    }
                    else if(account.getType().equals("save")){
                        balanceSaving.setText(String.valueOf(account.getSum()));
                    }
                }
            }
            else{
                System.out.println("Веселая сова сдохла");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
