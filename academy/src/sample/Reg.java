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

public class Reg {
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
    void registration() {
        btnRegister.setOnAction(event -> {
            if ((getSurName().isEmpty() == true || getName().isEmpty() == true || getPatronymic().isEmpty() == true || getPassSeries().isEmpty() == true || getPassNum().isEmpty() == true || getLogin().isEmpty() == true || getPass().isEmpty()) == true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warring");
                alert.setHeaderText(null);
                alert.setContentText("Не все поля заполнены!");
                alert.showAndWait();
            }
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
