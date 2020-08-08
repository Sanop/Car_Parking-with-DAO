package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class SidePaneController {
    public AnchorPane pane;
    public JFXButton btnMangeCustomers;
    public JFXButton btnHandleCarPark;
    public JFXButton btnRegisterNewUser;
    public JFXButton btnSettings;
    public JFXButton btnLogout;
    public JFXButton btnHandlePackages;

    public void initialize(){
        String userRole = LoginController.userRole;

        if(userRole.equals("Reception")){
            btnSettings.setDisable(true);
            btnRegisterNewUser.setDisable(true);
        }
    }
    public void btnMangeCustomersOnAction(ActionEvent actionEvent) {
    }

    public void btnHandleCarParkOnAction(ActionEvent actionEvent) {
    }

    public void btnRegisterNewUserOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }

    public void btnHandlePackagesOnAction(ActionEvent actionEvent) {
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) {

    }
}
