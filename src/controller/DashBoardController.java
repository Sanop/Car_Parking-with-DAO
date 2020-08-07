package controller;

import business.BOFactory;
import business.BOType;
import business.SuperBO;
import business.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.Customer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
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
    public AnchorPane root;
    public ListView<Customer> lstCustomers;
    public Label lblCustomerID;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAdress;
    public JFXTextField txtCustomerContactNumber;
    public JFXTextField txtCustomerNIC;
    public JFXTextField txtCarNumber;
    public JFXTextField txtCarModel;
    public JFXButton btnSaveCustomer;
    public JFXButton btnDeleteCustomer;
    public JFXButton btnAddNewCustomer;
    public Label lblCustomerNameCharacters;
    public Label lblCustomerContact;
    public Label lblCustomerNIC;

    CustomerBO customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);

    public void initialize(){


        AnchorPane box = null;
        try {
            box = FXMLLoader.load(getClass().getResource("/view/SidePane.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to log out", ButtonType.YES, ButtonType.NO);
                            Optional<ButtonType> buttonType = alert.showAndWait();
                            if (buttonType.get().equals(ButtonType.YES)) {
                                try {
                                    Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/view/Login_Form.fxml")));
                                    Stage primaryStage = (Stage) this.root.getScene().getWindow();
                                    primaryStage.setScene(scene);
                                    primaryStage.setTitle("Login To Parking_P");
                                    primaryStage.centerOnScreen();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                }
                            }
                            break;
                    }
                });
            }
        }

        lstCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observable, Customer oldValue, Customer newValue) {
                Customer selectedItem = lstCustomers.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    return;
                }

                lblCustomerID.setText(selectedItem.getId());
                txtCustomerName.setText(selectedItem.getName());
                txtCustomerAdress.setText(selectedItem.getAddress());
                txtCustomerContactNumber.setText(selectedItem.getContact());
                txtCustomerNIC.setText(selectedItem.getNic());
                txtCarNumber.setText(selectedItem.getCarNumber());
                txtCarModel.setText(selectedItem.getCarModel());

                txtCustomerName.setDisable(false);
                txtCustomerAdress.setDisable(false);
                txtCustomerContactNumber.setDisable(false);
                txtCustomerNIC.setDisable(false);
                txtCarNumber.setDisable(false);
                txtCarModel.setDisable(false);

                btnDeleteCustomer.setDisable(false);
                btnSaveCustomer.setText("update");
            }
        });

    }

    private void loadCustomerList() {
        ObservableList items = lstCustomers.getItems();
        items.clear();
        try {
            List<Customer> allCustomers = customerBO.getAllCustomers();
            for (Customer customer : allCustomers) {
                items.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        loadCustomerList();
        loadNewCustomerID();
        customerCommon();
    }

    private void loadNewCustomerID() {
        try {
            String newCustomerId = customerBO.getNewCustomerId();
            lblCustomerID.setText(newCustomerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void btnSaveCustomerOnAction(ActionEvent actionEvent) {
        if(txtCustomerName.getText().trim().isEmpty()){
            txtCustomerName.requestFocus();
        }else if(txtCustomerAdress.getText().trim().isEmpty()){
            txtCustomerAdress.requestFocus();
        }else if(txtCustomerContactNumber.getText().trim().isEmpty()){
            txtCustomerContactNumber.requestFocus();
        }else if(txtCustomerNIC.getText().trim().isEmpty()){
            txtCustomerNIC.requestFocus();
        }else if(txtCarNumber.getText().trim().isEmpty()){
            txtCarNumber.requestFocus();
        }else if(txtCarModel.getText().trim().isEmpty()){
            txtCarModel.requestFocus();
        }else if(txtCustomerName.getText().trim().matches("[a-z A-Z]+")){
            lblCustomerNameCharacters.setVisible(false);
            if(txtCustomerContactNumber.getText().trim().matches("\\d{3}[-]\\d{7}")){
                lblCustomerContact.setVisible(false);
                if(txtCustomerNIC.getText().trim().matches("\\d{9}[vV]")){
                    lblCustomerNIC.setVisible(false);

                    if(btnSaveCustomer.getText().equals("save")){
                        saveCustomer();
                    }else{
                        updateCustomer();
                    }
                    loadCustomerList();
                    customerCommon();
                }else{
                    lblCustomerNIC.setVisible(true);
                    txtCustomerNIC.requestFocus();
                }
            }else{
                lblCustomerContact.setVisible(true);
                txtCustomerContactNumber.requestFocus();
            }
        }else{
            lblCustomerNameCharacters.setVisible(true);
            txtCustomerName.requestFocus();
        }
    }

    private void updateCustomer() {
        try {
            boolean result = customerBO.updateCustomer(txtCustomerName.getText(),
                    txtCustomerAdress.getText(), txtCustomerContactNumber.getText(),
                    txtCustomerNIC.getText(), txtCarNumber.getText(),
                    txtCarModel.getText(), lblCustomerID.getText());

            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated").showAndWait();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveCustomer() {
        try {
            boolean result = customerBO.saveCustomer(lblCustomerID.getText(), txtCustomerName.getText(),
                    txtCustomerAdress.getText(), txtCustomerContactNumber.getText(),
                    txtCustomerNIC.getText(), txtCarNumber.getText(),
                    txtCarModel.getText());

            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Addedd").showAndWait();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customerCommon() {
        txtCustomerName.clear();
        txtCustomerName.setDisable(true);

        txtCustomerAdress.clear();
        txtCustomerAdress.setDisable(true);

        txtCustomerContactNumber.clear();
        txtCustomerContactNumber.setDisable(true);

        txtCustomerNIC.clear();
        txtCustomerNIC.setDisable(true);

        txtCarNumber.clear();
        txtCarNumber.setDisable(true);

        txtCarModel.clear();
        txtCarModel.setDisable(true);

        btnSaveCustomer.setText("save");
        btnDeleteCustomer.setDisable(true);
        loadNewCustomerID();

        btnAddNewCustomer.requestFocus();
    }

    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to delete this customer", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if(buttonType.get().equals(ButtonType.YES)){
                customerBO.deleteCustomer(lblCustomerID.getText());
                customerCommon();
                loadCustomerList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddNewCustomerOnAction(ActionEvent actionEvent) {
        txtCustomerName.setDisable(false);
        txtCustomerName.requestFocus();
        txtCustomerAdress.setDisable(false);
        txtCustomerNIC.setDisable(false);
        txtCustomerContactNumber.setDisable(false);
        txtCarNumber.setDisable(false);
        txtCarModel.setDisable(false);

        btnSaveCustomer.setText("save");
        btnDeleteCustomer.setDisable(true);

        loadNewCustomerID();
    }

    public void btnINOnAction(ActionEvent actionEvent) {
    }

    public void btnINOutAction(ActionEvent actionEvent) {

    }
}
