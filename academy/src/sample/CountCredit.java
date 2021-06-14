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

public class CountCredit {
    Pattern numeric = Pattern.compile("(\\d+\\d*)?");
    @FXML
    private TextField salary;

    @FXML
    private TextField limit;

    @FXML
    private Button btnCoint;

    @FXML
    private Button btnBack;

    @FXML
    private Button butMake;

    @FXML
    private TextField month;

    @FXML
    void counting(){
        if(month.getText().length()!=0 && salary.getText().length()!=0) {
            double percent = 0.1;
            String str = salary.getText();
            double digit = 0.3 * Integer.parseInt(str);
            str = month.getText();
            int months = Integer.parseInt(String.valueOf(str));
            int kol = -1;
            double sumper, returnDebt, bodyDebtStart = digit * 12, bodyDebt = bodyDebtStart;
            while (true) {
                kol++;
                sumper = bodyDebt * percent / 12;
                if (bodyDebtStart <= digit) returnDebt = bodyDebt;
                else returnDebt = digit - sumper;
                bodyDebt = bodyDebt - returnDebt;
                if (kol == months) {
                    if (bodyDebt < 500 && bodyDebt > -500) break;
                    else {
                        if (bodyDebt > 0) bodyDebtStart = bodyDebtStart - 100;
                        else bodyDebtStart = bodyDebtStart + 100;
                        bodyDebt = bodyDebtStart;
                        kol = 0;
                    }
                }
            }
            limit.setText(String.valueOf(bodyDebtStart));
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Не все поля заполнены!");
            alert.showAndWait();
        }
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
    void makeBill(){
        if(limit.getText().length()==0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Не все поля заполнены!");
            alert.showAndWait();
        }
        else
        try {
            String responde = Request.addAccount(Controller.getLogIn(), Controller.getPassword(), "credit", Float.parseFloat(limit.getText()));
            if(responde.equals("success")){
                System.out.println("Done");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Информационное сообщение");
                alert.setHeaderText(null);
                alert.setContentText("Заявка на кредит отправлена.");
                alert.showAndWait();
            }
            else {
                System.out.println("Веселая сова сдохла");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Информационное сообщение");
                alert.setHeaderText(null);
                alert.setContentText("Кредит уже оформлен.");
                alert.showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void checkMonth(){
        month.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) month.setText(oldValue);
        });
    }
    @FXML
    void checkSalary(){
        salary.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) salary.setText(oldValue);
        });
    }
}
