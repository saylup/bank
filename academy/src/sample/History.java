package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class History {
    @FXML
    private Button btnBack;

    @FXML
    private TableView<Operation> table;

    @FXML
    private TableColumn<Operation, String> colDate;

    @FXML
    private TableColumn<Operation, Float> colSum;

    @FXML
    private TableColumn<Operation, String> colStatus;

    @FXML
    private TableColumn<Operation, String> colTime;

    ObservableList<Operation> operations = FXCollections.observableArrayList();

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
            showStory();

    }
    @FXML
    void initialize(){
        table.setItems(operations);
        colDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDay() +"." +cellData.getValue().getMonth() + "." +cellData.getValue().getYear()));
        colSum.setCellValueFactory(cellData -> (new SimpleFloatProperty(cellData.getValue().getSum())).asObject());
        colStatus.setCellValueFactory(cellData ->  (new SimpleStringProperty( cellData.getValue().getStatus())));
        colTime.setCellValueFactory(cellData -> (new SimpleStringProperty( cellData.getValue().getHour() + ":" + cellData.getValue().getMinute())));
        showStory();
    }

    void showStory(){
            String str = null;
            try {
                str = Request.getOperations(Controller.getLogIn(),Controller.getPassword());
                ArrayList<Operation> yourArray = new Gson().fromJson(str, new TypeToken<List<Operation>>(){}.getType());
                if(!str.equals("Access denied") && !str.equals("Connection error")){
                    System.out.println(str);

                    operations.addAll(yourArray);
                }
            }catch (IOException ioException) {
                ioException.printStackTrace();
            }




    }
}

