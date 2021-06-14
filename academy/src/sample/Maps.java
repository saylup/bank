package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Maps {
    @FXML
    private Button btnBack;
    @FXML
    private Button btnLoad;
    @FXML
    void openHtml() throws IOException {
        String url = "file:///C:/Users/Всеволод/Desktop/academyBySeva/src/sample/totalmap.html";
            try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
    }

    @FXML
    void backToOffice() throws IOException {
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
}
