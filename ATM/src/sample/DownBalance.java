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

public class DownBalance {
    Pattern numeric = Pattern.compile("(\\d+)?");
    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnDownBalance;
    @FXML
    private TextField sumBill;
    @FXML
    private TextField sum;
    @FXML
    private Button btnBack;
    @FXML
    void checkSum(){
        sum.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!numeric.matcher(newValue).matches()) sum.setText(oldValue);
            if (sum.getLength()>8) sum.setText(oldValue);
        });
    }
    @FXML
    void logOut() {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }
    @FXML
    void minusSum() {
        int s;
        s = Integer.parseInt(sumBill.getText())-Integer.parseInt(sum.getText());
        if (s<0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warring");
            alert.setHeaderText(null);
            alert.setContentText("Невозможно снять данную сумму!");
            alert.showAndWait();
        }
        else
        sumBill.setText(String.valueOf(s));
    }
    @FXML
    void back() {
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
        stage.setTitle("Банкомат");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
