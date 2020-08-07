package controller;

import business.BOFactory;
import business.BOType;
import business.SuperBO;
import business.custom.CarCellBO;
import business.custom.CustomerBO;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.CarCell;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public Label lblA1;
    public Label lblB1;
    public Label lblC1;
    public Label lblD1;
    public Label lblE1;
    public Label lblF1;
    public Label lblG1;
    public Label lblH1;
    public Label lblI1;
    public Label lblL1;
    public Label lblM1;
    public Label lblN1;
    public Label lblA4;
    public Label lblB4;
    public Label lblC4;
    public Label lblD4;
    public Label lblE4;
    public Label lblF4;
    public Label lblG4;
    public Label lblH4;
    public Label lblI4;
    public Label lblL4;
    public Label lblM4;
    public Label lblN4;
    public Label lblA2;
    public Label lblB2;
    public Label lblC2;
    public Label lblD2;
    public Label lblE2;
    public Label lblF2;
    public Label lblG2;
    public Label lblH2;
    public Label lblI2;
    public Label lblL2;
    public Label lblM2;
    public Label lblN2;
    public Label lblA3;
    public Label lblB3;
    public Label lblC3;
    public Label lblD3;
    public Label lblE3;
    public Label lblF3;
    public Label lblG3;
    public Label lblH3;
    public Label lblI3;
    public Label lblL3;
    public Label lblM3;
    public Label lblN3;
    public Label lblJ1;
    public Label lblK1;
    public Label lblJ4;
    public Label lblK4;
    public Label lblJ2;
    public Label lblK2;
    public Label lblJ3;
    public Label lblK3;
    public JFXComboBox<String> cmbCustomerID;
    public JFXTextField txtVehicalInNumber;
    public JFXComboBox<String> cmdCellID;
    public Label lblInTime;
    public JFXTextField txtOutTime;
    public JFXButton btnIN;
    public Label lblDate;

    CustomerBO customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);
    CarCellBO carCellBO = BOFactory.getInstance().getBO(BOType.CARCELL);

    public void initialize(){

        setDate();
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

        setCellColors();

    }

    private void setCellColors(){
        try {
            List<CarCell> allCells = carCellBO.getAllCells();

            for (CarCell cell : allCells) {
                if(cell.getStatus().equals("not reserved")){
                    String cellId = cell.getCellId();
                    if(lblA1.getId().equals(cellId)){
                        lblA1.setStyle("-fx-background-color:   #006699");
                    }else if(lblA2.getId().equals(cellId)){
                        lblA2.setStyle("-fx-background-color:   #006699");
                    }else if(lblA3.getId().equals(cellId)){
                        lblA3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblA4.getId().equals(cellId)){
                        lblA4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblB1.getId().equals(cellId)){
                        lblB1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblB2.getId().equals(cellId)){
                        lblB2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblB3.getId().equals(cellId)){
                        lblB3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblB4.getId().equals(cellId)){
                        lblB4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblC1.getId().equals(cellId)){
                        lblC1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblC2.getId().equals(cellId)){
                        lblC2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblC3.getId().equals(cellId)){
                        lblC3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblC4.getId().equals(cellId)){
                        lblC4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblD1.getId().equals(cellId)){
                        lblD1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblD2.getId().equals(cellId)){
                        lblD2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblD3.getId().equals(cellId)){
                        lblD3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblD4.getId().equals(cellId)){
                        lblD4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblE1.getId().equals(cellId)){
                        lblE1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblE2.getId().equals(cellId)){
                        lblE2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblE3.getId().equals(cellId)){
                        lblE3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblE4.getId().equals(cellId)){
                        lblE4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblF1.getId().equals(cellId)){
                        lblF1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblF2.getId().equals(cellId)){
                        lblF2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblF3.getId().equals(cellId)){
                        lblF3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblF4.getId().equals(cellId)){
                        lblF4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblG1.getId().equals(cellId)){
                        lblG1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblG2.getId().equals(cellId)){
                        lblG2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblG3.getId().equals(cellId)){
                        lblG3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblG4.getId().equals(cellId)){
                        lblG4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblH1.getId().equals(cellId)){
                        lblH1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblH2.getId().equals(cellId)){
                        lblH2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblH3.getId().equals(cellId)){
                        lblH3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblH4.getId().equals(cellId)){
                        lblH4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblI1.getId().equals(cellId)){
                        lblI1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblI2.getId().equals(cellId)){
                        lblI2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblI3.getId().equals(cellId)){
                        lblI3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblI4.getId().equals(cellId)){
                        lblI4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblJ1.getId().equals(cellId)){
                        lblJ1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblJ2.getId().equals(cellId)){
                        lblJ2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblJ3.getId().equals(cellId)){
                        lblJ3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblJ4.getId().equals(cellId)){
                        lblJ4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblK1.getId().equals(cellId)){
                        lblK1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblK2.getId().equals(cellId)){
                        lblK2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblK3.getId().equals(cellId)){
                        lblK3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblK4.getId().equals(cellId)){
                        lblK4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblL1.getId().equals(cellId)){
                        lblL1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblL2.getId().equals(cellId)){
                        lblL2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblL3.getId().equals(cellId)){
                        lblL3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblL4.getId().equals(cellId)){
                        lblL4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblM1.getId().equals(cellId)){
                        lblM1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblM2.getId().equals(cellId)){
                        lblM2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblM3.getId().equals(cellId)){
                        lblM3.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblM4.getId().equals(cellId)){
                        lblM4.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblN1.getId().equals(cellId)){
                        lblN1.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblN2.getId().equals(cellId)){
                        lblN2.setStyle("-fx-background-color:   #006699");
                    }
                    else if(lblN3.getId().equals(cellId)){
                        lblN3.setStyle("-fx-background-color:   #006699");
                    }else{
                        lblN4.setStyle("-fx-background-color:   #006699");
                    }
                }else{
                    String cellId = cell.getCellId();
                    if(lblA1.getId().equals(cellId)){
                        lblA1.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblA2.getId().equals(cellId)){
                        lblA2.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblA3.getId().equals(cellId)){
                        lblA3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblA4.getId().equals(cellId)){
                        lblA4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblB1.getId().equals(cellId)){
                        lblB1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblB2.getId().equals(cellId)){
                        lblB2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblB3.getId().equals(cellId)){
                        lblB3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblB4.getId().equals(cellId)){
                        lblB4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblC1.getId().equals(cellId)){
                        lblC1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblC2.getId().equals(cellId)){
                        lblC2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblC3.getId().equals(cellId)){
                        lblC3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblC4.getId().equals(cellId)){
                        lblC4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblD1.getId().equals(cellId)){
                        lblD1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblD2.getId().equals(cellId)){
                        lblD2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblD3.getId().equals(cellId)){
                        lblD3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblD4.getId().equals(cellId)){
                        lblD4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblE1.getId().equals(cellId)){
                        lblE1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblE2.getId().equals(cellId)){
                        lblE2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblE3.getId().equals(cellId)){
                        lblE3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblE4.getId().equals(cellId)){
                        lblE4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblF1.getId().equals(cellId)){
                        lblF1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblF2.getId().equals(cellId)){
                        lblF2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblF3.getId().equals(cellId)){
                        lblF3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblF4.getId().equals(cellId)){
                        lblF4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblG1.getId().equals(cellId)){
                        lblG1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblG2.getId().equals(cellId)){
                        lblG2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblG3.getId().equals(cellId)){
                        lblG3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblG4.getId().equals(cellId)){
                        lblG4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblH1.getId().equals(cellId)){
                        lblH1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblH2.getId().equals(cellId)){
                        lblH2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblH3.getId().equals(cellId)){
                        lblH3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblH4.getId().equals(cellId)){
                        lblH4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblI1.getId().equals(cellId)){
                        lblI1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblI2.getId().equals(cellId)){
                        lblI2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblI3.getId().equals(cellId)){
                        lblI3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblI4.getId().equals(cellId)){
                        lblI4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblJ1.getId().equals(cellId)){
                        lblJ1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblJ2.getId().equals(cellId)){
                        lblJ2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblJ3.getId().equals(cellId)){
                        lblJ3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblJ4.getId().equals(cellId)){
                        lblJ4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblK1.getId().equals(cellId)){
                        lblK1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblK2.getId().equals(cellId)){
                        lblK2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblK3.getId().equals(cellId)){
                        lblK3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblK4.getId().equals(cellId)){
                        lblK4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblL1.getId().equals(cellId)){
                        lblL1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblL2.getId().equals(cellId)){
                        lblL2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblL3.getId().equals(cellId)){
                        lblL3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblL4.getId().equals(cellId)){
                        lblL4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblM1.getId().equals(cellId)){
                        lblM1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblM2.getId().equals(cellId)){
                        lblM2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblM3.getId().equals(cellId)){
                        lblM3.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblM4.getId().equals(cellId)){
                        lblM4.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblN1.getId().equals(cellId)){
                        lblN1.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblN2.getId().equals(cellId)){
                        lblN2.setStyle("-fx-background-color:   #cccc00");
                    }
                    else if(lblN3.getId().equals(cellId)){
                        lblN3.setStyle("-fx-background-color:   #cccc00");
                    }else{
                        lblN4.setStyle("-fx-background-color:   #cccc00");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public String getCurrentTime(){
        Date date = new Date();
        String format = "hh:mm";
        DateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public void setDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        lblDate.setText(dtf.format(now));
    }

    public void loadCustomerCombo(){

    }
}
