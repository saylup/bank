package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
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
        btnLog.setOnAction(event -> {
            if (getLogIn().isEmpty()==true || getPassword().isEmpty()==true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warring");
                alert.setHeaderText(null);
                alert.setContentText("Не все поля заполнены!");
                alert.showAndWait();
            }
            else
            {
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
        });
    }

    @FXML
    void registration() {
        btnReg.setOnAction(event -> {
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
        });
    }
    public String getLogIn() {
        return logIn.getText();
    }

    public String getPassword() {
        return password.getText();
    }
}
