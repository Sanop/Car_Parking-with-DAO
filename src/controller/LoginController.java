package controller;

import business.BOFactory;
import business.BOType;
import business.custom.UsersBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.DAOFactory;
import entity.Users;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public JFXButton btnLogin;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;
    public JFXComboBox<String> cmbUserRole;

    public static String userRole;
    UsersBO usersBO = BOFactory.getInstance().getBO(BOType.USERS);

    public void initialize(){
        ObservableList items = cmbUserRole.getItems();
        items.add("Admin");
        items.add("Reception");
    }
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {


        try {
            int i = usersBO.searchUserRole(new Users(txtPassword.getText(), txtUserName.getText(), cmbUserRole.getSelectionModel().getSelectedItem()));
            userRole = cmbUserRole.getSelectionModel().getSelectedItem();
            if(i == 1){
                Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/DashBoard.fxml")));
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(scene);
                primaryStage.setTitle("Dash Board");
                primaryStage.centerOnScreen();
            }else{
                new Alert(Alert.AlertType.ERROR,"Please Enter Correct Details").showAndWait();
                cmbUserRole.getSelectionModel().select(null);
                txtUserName.clear();
                txtPassword.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
