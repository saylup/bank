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
    Pattern log = Pattern.compile("([\\S]+|[^а-яёА-ЯЁ]+)");
    static String login;
    static String pass;
    static Customer cust;
    @FXML
    private Button btnLog;
    @FXML
    private Button btnReg;
    @FXML
    private TextField logIn;
    @FXML
    private TextField password;



    @FXML
    void login() {
        login = logIn.getText();
        pass = password.getText();
            if (getLogIn().isEmpty()==true || getPassword().isEmpty()==true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warring");
                alert.setHeaderText(null);
                alert.setContentText("Не все поля заполнены!");
                alert.showAndWait();
            }
            else
            {
                try {
                    String str = Request.checkCustomer(logIn.getText(), password.getText());
                    if(!str.equals("Access denied") && !str.equals("Server Error")){
                        cust = new Gson().fromJson(str, Customer.class);
                        System.out.println("Произошла авторизаиця");
                        //Close current
                        Stage stage = (Stage) btnLog.getScene().getWindow();
                        // do what you have to do
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
                    else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Ошибка!");
                        alert.setHeaderText(null);
                        alert.setContentText("Логин и/или пароль введён неверно!");
                        alert.showAndWait();
                        System.out.println("Веселая сова сдохла");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Веселая сова сдохла");
                }
            }
    }

    @FXML
    void registration() {
            Stage stage = (Stage) btnLog.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/reg.fxml"));
            Parent root1 = null;
            try {
                root1 = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Регистрация");
            stage.setScene(new Scene(root1));
            stage.show();


    }
    @FXML
    void checkLogin(){
            logIn.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!log.matcher(newValue).matches()) logIn.setText(oldValue);
            logIn.setText(newValue.replaceAll("[а-яёА-ЯЁ]+", ""));
            logIn.setText(newValue.replaceAll(" ", ""));
        });
    }
    @FXML
    void checkPass(){
        password.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!log.matcher(newValue).matches()) password.setText(oldValue);
            password.setText(newValue.replaceAll(" ", ""));
            password.setText(newValue.replaceAll("[а-яёА-ЯЁ]+", ""));
        });
    }

    public static String getLogIn() {
        return login;
    }

    public static String getPassword() {
        return pass;
    }
}
