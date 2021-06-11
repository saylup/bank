package sample;

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

public class Office {
    @FXML
    private TextField balanceSum;
    @FXML
    private TextField balanceBill;
    @FXML
    private TextField balanceCard;
    @FXML
    private TextField balanceCredit;
    @FXML
    private TextField balanceSaving;
    @FXML
    private TextField balanceBrokerage;
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
    @FXML
    void transactoin() {
        butTrans.setOnAction(event -> {
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
        });
    }

    @FXML
    void history() {
        btnHistory.setOnAction(event -> {
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
        });
    }

    @FXML
    void maps() {
        butnAutomats.setOnAction(event -> {
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
        });
    }
}
