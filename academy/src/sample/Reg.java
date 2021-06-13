package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private TextField pin;
    @FXML
    private Button btnRegister;

    @FXML
    void registration() {
        btnRegister.setOnAction(event -> {
            if ((getPassSeries().length() < 4 || getPassNum().length() < 6 || getPin().length() < 4 || getPin().isEmpty() == true || getSurName().isEmpty() == true || getName().isEmpty() == true || getPatronymic().isEmpty() == true || getPassSeries().isEmpty() == true || getPassNum().isEmpty() == true || getLogin().isEmpty() == true || getPass().isEmpty()) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warring");
                alert.setHeaderText(null);
                alert.setContentText("Не все поля заполнены!");
                alert.showAndWait();
                System.out.println(getPass());

            }
        });
    }

    @FXML
    void checkPin(){
                pin.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (!numeric.matcher(newValue).matches()) pin.setText(oldValue);
                    if (pin.getLength()>4) pin.setText(oldValue);
                });
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

    public String getPin() {return pin.getText();}
}
