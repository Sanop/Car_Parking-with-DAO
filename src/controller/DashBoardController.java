package controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

public class DashBoardController {
    public JFXHamburger jfxHamburger;
    public JFXDrawer jfxDrawer;
    public Pane paneHandleCarPark;
    public Pane paneHandlePackages;
    public Pane paneManageCustomers;
    public Pane paneManagePackages;
    public Pane paneManageCarCells;
    public Pane paneRegisterNewUser;
    public Pane paneSettings;

    public void initialize() throws IOException {


            AnchorPane box = FXMLLoader.load(getClass().getResource("/view/SidePane.fxml"));
            jfxDrawer.setSidePane(box);


        HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(jfxHamburger);
        burger.setRate(-1);
        jfxHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (t) -> {
            burger.setRate(burger.getRate() * -1);
            burger.play();

            if (jfxDrawer.isOpened()) {
                jfxDrawer.close();
            } else {
                jfxDrawer.open();
            }

        });

        for (Node node : box.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "Handle Car Park":
                            load_Handle_Car_Park();
                            break;
                        case "Handle Packages":
                            load_Handle_Packages();
                            break;
                        case "Manage Customers":
                            load_Manage_Customer();
                            break;
                        case "Manage Packages":
                            load_Manage_Packages();
                            break;
                        case "Manage Car Cells":
                            load_Manage_Car_Cells();
                            break;
                        case "Register New User":
                            load_Register_new_User();
                            break;
                        case "Settings":
                            load_Settings();
                            break;
                        case "Log Out":

                            break;
                    }
                });
            }
        }
    }

    private void load_Settings() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(true);
    }

    private void load_Register_new_User() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(true);
        paneSettings.setVisible(false);
    }

    private void load_Manage_Car_Cells() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(true);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);
    }

    private void load_Manage_Packages() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(true);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);
    }

    private void load_Manage_Customer() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(true);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);
    }

    private void load_Handle_Packages() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(true);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);
    }

    private void load_Handle_Car_Park() {
        paneHandleCarPark.setVisible(true);
        paneHandlePackages.setVisible(false);
        paneManageCarCells.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneManagePackages.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);
    }
}
