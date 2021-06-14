package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class History {
    @FXML
    private Button btnBack;
    @FXML
    private TreeTableView table;
    @FXML
    private TreeTableColumn colDate;
    @FXML
    private TreeTableColumn colOperation;
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
}
