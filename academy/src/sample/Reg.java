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

public class Reg{
    Pattern numeric = Pattern.compile("(\\d+\\d*)?");
    Pattern letter = Pattern.compile("[а-яёА-ЯЁ]+");
    Pattern log = Pattern.compile("([\\S]+|[^а-яёА-ЯЁ]+)");
    @FXML
    private TextField surName;
    @FXML
    private TextField name;
    @FXML
    private TextField patronymic;
    @FXML
    private TextField passSeries;
    @FXML
    private TextField passNum;
    @FXML
    private TextField login;
    @FXML
    private TextField pass;
    @FXML
    private Button btnRegister;
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
    void registration() {
            if ((getPassSeries().length() < 4 || getPassNum().length() < 6  || getSurName().isEmpty() || getName().isEmpty() || getPatronymic().isEmpty() || getPassSeries().isEmpty() || getPassNum().isEmpty() || getLogin().isEmpty() || getPass().isEmpty())) {
                dialogWindow("Ошибка!","Не все поля заполнены!");
                System.out.println(getPass());
            }
            else{
                Customer cust = new Customer(name.getText(), surName.getText(), patronymic.getText(), Integer.parseInt(passSeries.getText()), Integer.parseInt(passNum.getText()), login.getText(), pass.getText());
                Gson gson = new Gson();
                try {
                    String response = Request.addRequest(gson.toJson(cust));
                    if (response.equals("success")){
                        System.out.println("Оп-оп-оп Живём живём");
                    }
                    else{
                        System.out.println("Веселая сова сдохла");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dialogWindow("Информационное сообщение","Запрос на регистрацию отправлен.");
                System.out.println(getPass());
            }
    }
    @FXML
    void backToLogIn() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
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
    void checkNum(){
        passNum.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) passNum.setText(oldValue);
            if (passNum.getLength()>6) passNum.setText(oldValue);
        });
    }
    @FXML
    void checkSeries(){
        passSeries.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) passSeries.setText(oldValue);
            if (passSeries.getLength()>4) passSeries.setText(oldValue);
        });
    }

    @FXML
    void checkName(){
        name.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!letter.matcher(newValue).matches()) name.setText(oldValue);
        });
    }
    @FXML
    void checkSurName(){
        surName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!letter.matcher(newValue).matches()) surName.setText(oldValue);
        });
    }
    @FXML
    void checkPatr(){
        patronymic.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!letter.matcher(newValue).matches()) patronymic.setText(oldValue);
        });
    }
    @FXML
    void checkLogin(){
        login.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!log.matcher(newValue).matches()) login.setText(oldValue);
            login.setText(newValue.replaceAll(" ", ""));
            login.setText(newValue.replaceAll("[а-яёА-ЯЁ]+", ""));
        });
    }
    @FXML
    void checkPass(){
        pass.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!log.matcher(newValue).matches()) pass.setText(oldValue);
            pass.setText(newValue.replaceAll(" ", ""));
            pass.setText(newValue.replaceAll("[а-яёА-ЯЁ]+", ""));
        });
    }


    public String getSurName() {
        return surName.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getPatronymic() {
        return patronymic.getText();
    }

    public String getPassSeries() {
        return passSeries.getText();
    }

    public String getPassNum() {
        return passNum.getText();
    }

    public String getLogin() {
        return login.getText();
    }

    public String getPass() {
        return pass.getText();
    }

}
