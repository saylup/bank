package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Office {

    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnUpBalance;
    @FXML
    private Button btnDownBalance;

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
