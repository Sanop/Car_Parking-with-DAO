package controller;

import business.BOFactory;
import business.BOType;
import business.custom.*;
import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.*;
import entity.Package;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class DashBoardController {
    public JFXHamburger jfxHamburger;
    public JFXDrawer jfxDrawer;
    public Pane paneHandleCarPark;
    public Pane paneHandlePackages;
    public Pane paneManageCustomers;
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
    public JFXTextField txtOutTime;
    public JFXButton btnIN;
    public Label lblDate;
    public JFXComboBox<String> cmbCellID;
    public Label lblTimeCreation;
    public Label lblInvoiceNumber;
    public JFXButton btnSearchInvoice;
    public JFXTextField txtInvoiceNumber;
    public JFXTextField txtOutCellID;
    public Label lblInTime;
    public Label lblOutTime;
    public Label lblExtraPayment;
    public Label lblNetPayment;
    public JFXButton btnOut;
    public JFXButton btnAddNewPackageID;
    public Label lblPackageID;
    public JFXTextField txtnNewPackageType;
    public JFXTextField txtNewPackagePrice;
    public JFXComboBox<Package> cmbAddedPackagesSettings;
    public JFXButton btnDeletePackage;
    public JFXButton btnSavePackage;
    public Label lblPriceFormat;
    public Label lblA1P;
    public Label lblB1P;
    public Label lblC1P;
    public Label lblD1P;
    public Label lblE1P;
    public Label lblF1P;
    public Label lblA2P;
    public Label lblB2P;
    public Label lblC2P;
    public Label lblD2P;
    public Label lblE2P;
    public Label lblF2P;
    public JFXComboBox<Package> cmbHandlePackageType;
    public JFXTextField txtPackagePrice;
    public JFXComboBox<String> cmbPackageCellID;
    public JFXDatePicker pickerOutDate;
    public JFXButton btnSaveNewPackage;
    public Label lblPackageInvoiceNumber;
    public JFXComboBox<String> cmbPackageCustomerID;
    public JFXTextField txtPackageInvoiceSerach;
    public JFXButton btnPackageSearchInvoice;
    public Label lblInDate;
    public Label lblOutDate;
    public Label lblExtraChargePackage;
    public Label lblNetpaymentPackage;
    public JFXTextField txtCellIdPackage;
    public JFXButton btnPayPackage;
    public ListView<Users> lstRegisterdUsers;
    public Label lblUserID;
    public JFXButton btnAddNewUser;
    public JFXTextField txtUserFullName;
    public JFXTextField txtUserNIC;
    public JFXTextField txtUserAddress;
    public JFXTextField txtUserContact;
    public JFXTextField txtUserMail;
    public JFXPasswordField txtUserNewPassword;
    public JFXPasswordField txtUserConfirmPassword;
    public JFXTextField txtUserNameToSystem;
    public JFXComboBox<String> cmbUserRole;
    public JFXButton btnSaveUsers;
    public JFXButton btnDeleteUsers;
    public Label lblUserOnlyCharacters;
    public Label lblUserNICCorrectFormat;
    public Label lblUserContactCorrectFormat;
    public Label lblUserEmailCOrrectFormat;
    public Label lblPasswordMatch;

    CustomerBO customerBO = BOFactory.getInstance().getBO(BOType.CUSTOMER);
    CarCellBO carCellBO = BOFactory.getInstance().getBO(BOType.CARCELL);
    DefaultPaymentBO defaultPaymentBO = BOFactory.getInstance().getBO(BOType.DEFAULT_PAYMENT);
    PaymentBO paymentBO = BOFactory.getInstance().getBO(BOType.PAYMENT);
    PackageBO packageBO = BOFactory.getInstance().getBO(BOType.PACKAGE);
    PackageCellsBO packageCellsBO = BOFactory.getInstance().getBO(BOType.PACKAGE_CELLS);
    PackagePaymentBO packagePaymentBO = BOFactory.getInstance().getBO(BOType.PACKAGE_PAYMENT);
    UsersBO usersBO = BOFactory.getInstance().getBO(BOType.USERS);

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

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String selectedItem = cmbCustomerID.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    return;
                }
                try {
                    Customer customer = customerBO.getCustomerByID(selectedItem);
                    txtVehicalInNumber.setText(customer.getCarNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cmbAddedPackagesSettings.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Package>() {
            @Override
            public void changed(ObservableValue<? extends Package> observable, Package oldValue, Package newValue) {
                Package selectedItem = cmbAddedPackagesSettings.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    return;
                }

                txtnNewPackageType.setText(selectedItem.getType());
                txtNewPackagePrice.setText(selectedItem.getPrice());
                lblPackageID.setText(selectedItem.getId());

                txtNewPackagePrice.setDisable(false);
                txtnNewPackageType.setDisable(false);

                btnSavePackage.setText("Update");
                btnSavePackage.setDisable(false);
                btnDeletePackage.setDisable(false);
            }
        });

        cmbHandlePackageType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Package>() {
            @Override
            public void changed(ObservableValue<? extends Package> observable, Package oldValue, Package newValue) {
                Package selectedItem = cmbHandlePackageType.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    return;
                }

                txtPackagePrice.setText(selectedItem.getPrice());
            }
        });

        lstRegisterdUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Users>() {
            @Override
            public void changed(ObservableValue<? extends Users> observable, Users oldValue, Users newValue) {
                Users selectedItem = lstRegisterdUsers.getSelectionModel().getSelectedItem();
                if(selectedItem == null){
                    return;
                }


                lblUserID.setText(selectedItem.getId());
                txtUserFullName.setText(selectedItem.getName());
                txtUserFullName.setDisable(false);
                txtUserNIC.setText(selectedItem.getNic());
                txtUserNIC.setDisable(false);
                txtUserAddress.setText(selectedItem.getAddress());
                txtUserAddress.setDisable(false);
                txtUserContact.setText(selectedItem.getContact());
                txtUserContact.setDisable(false);
                txtUserMail.setText(selectedItem.getEmail());
                txtUserMail.setDisable(false);
                txtUserNewPassword.setText(selectedItem.getPassword());
                txtUserNewPassword.setDisable(false);
                txtUserConfirmPassword.setText(selectedItem.getPassword());
                txtUserConfirmPassword.setDisable(false);
                txtUserNameToSystem.setText(selectedItem.getUserName());
                txtUserNameToSystem.setDisable(false);
                cmbUserRole.getSelectionModel().select(selectedItem.getUserRole());
                cmbUserRole.setDisable(false);

                btnSaveUsers.setText("Update");
                btnSaveUsers.setDisable(false);
                btnDeleteUsers.setDisable(false);
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
        paneManageCustomers.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(true);

        loadPackageSettingCombo();

        managePackageCommon();
    }

    private void loadPackageSettingCombo() {
        ObservableList<Package> items = cmbAddedPackagesSettings.getItems();
        items.clear();

        try {
            List<Package> allPackages = packageBO.getAllPackages();

            for (Package allPackage : allPackages) {
                items.add(new Package(allPackage.getId(),allPackage.getType(),allPackage.getPrice()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void managePackageCommon() {
        txtnNewPackageType.setDisable(true);
        txtnNewPackageType.clear();
        txtNewPackagePrice.setDisable(true);
        txtNewPackagePrice.clear();
        btnSavePackage.setDisable(true);
        btnSavePackage.setText("Save");
        btnDeletePackage.setDisable(true);
        btnAddNewPackageID.requestFocus();
        loadNewPackageID();
    }

    private void loadNewPackageID() {
        try {
            lblPackageID.setText(packageBO.createNewPackageID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load_Register_new_User() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneRegisterNewUser.setVisible(true);
        paneSettings.setVisible(false);

        commonRegisterNewUser(true);

        loadUserCombo();

    }

    private void loadUserList() {
        ObservableList<Users> items = lstRegisterdUsers.getItems();
        items.clear();

        try {
            List<Users> allUsers = usersBO.getAllUsers();
            for (Users user : allUsers) {
                items.add(new Users(user.getId(),
                        user.getName(),
                        user.getNic(),
                        user.getAddress(),
                        user.getContact(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getUserName(),
                        user.getUserRole()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadUserCombo() {
        ObservableList<String> items = cmbUserRole.getItems();
        items.add("Admin");
        items.add("Reception");
    }

    private void commonRegisterNewUser(boolean flag) {
        txtUserFullName.clear();
        txtUserFullName.setDisable(flag);
        txtUserNIC.clear();
        txtUserNIC.setDisable(flag);
        txtUserAddress.clear();
        txtUserAddress.setDisable(flag);
        txtUserContact.clear();
        txtUserContact.setDisable(flag);
        txtUserMail.clear();
        txtUserMail.setDisable(flag);
        txtUserNewPassword.clear();
        txtUserNewPassword.setDisable(flag);
        txtUserConfirmPassword.clear();
        txtUserConfirmPassword.setDisable(flag);
        txtUserNameToSystem.clear();
        txtUserNameToSystem.setDisable(flag);
        cmbUserRole.getSelectionModel().select(null);
        cmbUserRole.setDisable(flag);
        btnSaveUsers.setDisable(flag);
        btnSaveUsers.setText("Save");
        btnDeleteUsers.setDisable(flag);
        btnAddNewUser.requestFocus();
        loadNewUserID();
        loadUserList();
    }

    private void load_Manage_Customer() {
        paneHandleCarPark.setVisible(false);
        paneHandlePackages.setVisible(false);
        paneManageCustomers.setVisible(true);
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
        paneManageCustomers.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);

        setPackageCellColors();

        loadPackageTypeCombo();

        loadNotReservedPackageCellListCombo();

        loadCustomerCombo();
        pickerOutDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        String s = loadInvoiceNumber();
        lblPackageInvoiceNumber.setText(s);
        btnPayPackage.setDisable(true);
    }

    private void loadNotReservedPackageCellListCombo() {

        ObservableList<String> items = cmbPackageCellID.getItems();
        try {
            ResultSet notReservedCells = packageCellsBO.getNotReservedCells();
            while (notReservedCells.next()){
                items.add(notReservedCells.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPackageTypeCombo() {
        ObservableList<Package> items = cmbHandlePackageType.getItems();
        items.clear();

        try {
            List<Package> allPackages = packageBO.getAllPackages();

            for (Package aPackage : allPackages) {
                items.add(new Package(aPackage.getId(),aPackage.getType(),aPackage.getPrice()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPackageCellColors() {
        try {
            List<PackageCells> allCells = packageCellsBO.getAllCells();

            for (PackageCells cell : allCells) {
                String id = cell.getId();
                if(cell.getStatus().equals("not reserved")){
                    if(lblA1P.getId().equals(id)){
                        lblA1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblA2P.getId().equals(id)){
                        lblA2P.setStyle("-fx-background-color:   #006699");
                    }else if(lblB1P.getId().equals(id)){
                        lblB1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblB2P.getId().equals(id)){
                        lblB2P.setStyle("-fx-background-color:   #006699");
                    }else if(lblC1P.getId().equals(id)){
                        lblC1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblC2P.getId().equals(id)){
                        lblC2P.setStyle("-fx-background-color:   #006699");
                    }else if(lblD1P.getId().equals(id)){
                        lblD1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblD2P.getId().equals(id)){
                        lblD2P.setStyle("-fx-background-color:   #006699");
                    }else if(lblE1P.getId().equals(id)){
                        lblE1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblE2P.getId().equals(id)){
                        lblE2P.setStyle("-fx-background-color:   #006699");
                    }else if(lblF1P.getId().equals(id)){
                        lblF1P.setStyle("-fx-background-color:   #006699");
                    }else if(lblF2P.getId().equals(id)){
                        lblF2P.setStyle("-fx-background-color:   #006699");
                    }
                }else{
                    if(lblA1P.getId().equals(id)){
                        lblA1P.setStyle("-fx-background-color:   #cccc00");;
                    }else if(lblA2P.getId().equals(id)){
                        lblA2P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblB1P.getId().equals(id)){
                        lblB1P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblB2P.getId().equals(id)){
                        lblB2P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblC1P.getId().equals(id)){
                        lblC1P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblC2P.getId().equals(id)){
                        lblC2P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblD1P.getId().equals(id)){
                        lblD1P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblD2P.getId().equals(id)){
                        lblD2P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblE1P.getId().equals(id)){
                        lblE1P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblE2P.getId().equals(id)){
                        lblE2P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblF1P.getId().equals(id)){
                        lblF1P.setStyle("-fx-background-color:   #cccc00");
                    }else if(lblF2P.getId().equals(id)){
                        lblF2P.setStyle("-fx-background-color:   #cccc00");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void load_Handle_Car_Park() {
        paneHandleCarPark.setVisible(true);
        paneHandlePackages.setVisible(false);
        paneManageCustomers.setVisible(false);
        paneRegisterNewUser.setVisible(false);
        paneSettings.setVisible(false);

        setCellColors();
        loadCustomerCombo();
        loadNotReservedVehicalList();

        String s = loadInvoiceNumber();
        lblInvoiceNumber.setText(s);

        txtOutCellID.setDisable(true);
        btnOut.setDisable(true);

    }

    private String loadInvoiceNumber() {
        Random r = new Random();
        return r.nextInt(100000000)+"";
    }

    private void loadNotReservedVehicalList() {
        try {
            ResultSet notReservedCells = carCellBO.getNotReservedCells();
            ObservableList<String> items = cmbCellID.getItems();
            items.clear();

            while(notReservedCells.next()){
                items.add(notReservedCells.getString(1));
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
        String customerID;
        if(cmbCustomerID.getSelectionModel().getSelectedItem()== null){
            customerID = null;
        }else{
            customerID = cmbCustomerID.getSelectionModel().getSelectedItem();
        }

        if(txtVehicalInNumber.getText().trim().isEmpty()){
            txtVehicalInNumber.requestFocus();
        }else if(cmbCellID.getSelectionModel().getSelectedItem() == null){
            cmbCellID.requestFocus();
        }else if(txtOutTime.getText().trim().isEmpty()){
            txtOutTime.requestFocus();
        }else if(txtOutTime.getText().trim().matches("\\d{2}[.]\\d{2}")){
            lblTimeCreation.setVisible(false);
            Random r = new Random();
            DefaultPayment entity = new DefaultPayment(customerID,cmbCellID.getSelectionModel().getSelectedItem(),getCurrentTime(),txtOutTime.getText(),lblInvoiceNumber.getText());
            try {
                defaultPaymentBO.add(entity);
                setCellColors();
                cmbCustomerID.getSelectionModel().select(null);
                txtVehicalInNumber.clear();
                cmbCellID.getSelectionModel().select(null);
                txtOutTime.clear();
                cmbCustomerID.requestFocus();
                loadInvoiceNumber();
                loadNotReservedVehicalList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            lblTimeCreation.setVisible(true);
            txtOutTime.requestFocus();
        }
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
        try {
            ResultSet customerIdList = customerBO.getCustomerIdList();
            ObservableList<String> items = cmbCustomerID.getItems();
            ObservableList<String> customerIDs = cmbPackageCustomerID.getItems();
            customerIDs.clear();
            items.clear();

            while (customerIdList.next()){
                items.add(customerIdList.getString(1));
                customerIDs.add(customerIdList.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnOutAction(ActionEvent actionEvent) {
        Payment payment = new Payment(txtInvoiceNumber.getText(),lblNetPayment.getText(),lblDate.getText());
        CarCell carCell = new CarCell(txtOutCellID.getText(),"not reserved");
        try {
            boolean result = paymentBO.add(payment, carCell);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
                txtInvoiceNumber.clear();
                txtOutCellID.clear();
                lblInTime.setText("00.00");
                lblOutTime.setText("00.00");
                lblExtraPayment.setText("00.00");
                lblNetPayment.setText("00.00");
                btnOut.setDisable(true);
                txtInvoiceNumber.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setCellColors();
    }

    public void btnSearchInvoiceOnAction(ActionEvent actionEvent) {
        try {
            ResultSet resultSet = defaultPaymentBO.searchByInvoice(txtInvoiceNumber.getText());
            if(resultSet.next()){
                txtOutCellID.setText(resultSet.getString(3));
                String inTime = resultSet.getString(4);
                lblInTime.setText(inTime);
                String outTime = resultSet.getString(5);
                lblOutTime.setText(outTime);

                String currentTime = getCurrentTime();
                String substring = currentTime.substring(3, 5);
                int current = Integer.parseInt(substring);

                String substring1 = outTime.substring(3, 5);
                int out = Integer.parseInt(substring1);

                if(current > out){
                    lblExtraPayment.setText("100");
                    lblNetPayment.setText("200");
                }else{
                    lblNetPayment.setText("100");
                }

                btnOut.setDisable(false);
                lblOutTime.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddNewPackageIDOnAction(ActionEvent actionEvent) {
        cmbAddedPackagesSettings.getSelectionModel().select(null);
        txtnNewPackageType.setDisable(false);
        txtnNewPackageType.clear();
        txtNewPackagePrice.setDisable(false);
        txtNewPackagePrice.clear();
        txtnNewPackageType.requestFocus();
        loadNewPackageID();
        btnSavePackage.setDisable(false);
        btnSavePackage.setText("Save");

    }

    public void btnSavePackageOnAction(ActionEvent actionEvent) {
        if(txtnNewPackageType.getText().trim().isEmpty()){
            txtnNewPackageType.requestFocus();
        }else if(txtNewPackagePrice.getText().trim().isEmpty()){
            txtNewPackagePrice.requestFocus();
        }else if(txtNewPackagePrice.getText().trim().matches("\\d+[.]\\d{2}")){
            lblPriceFormat.setVisible(false);
            if(btnSavePackage.getText().equals("Save")){
                savePackage();
            }else{
                updatePackage();
            }

            loadPackageSettingCombo();
            managePackageCommon();
        }else{
            lblPriceFormat.setVisible(true);
            txtNewPackagePrice.requestFocus();
        }
    }

    private void updatePackage() {
        try {
            boolean result = packageBO.updatePackage(new Package(lblPackageID.getText(), txtnNewPackageType.getText(), txtNewPackagePrice.getText()));
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated").showAndWait();
            }
            cmbAddedPackagesSettings.getSelectionModel().select(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePackage() {
        try {
            boolean result = packageBO.addPackage(new Package(lblPackageID.getText(),
                    txtnNewPackageType.getText(),
                    txtNewPackagePrice.getText()));

            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeletePackageOnAction(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Do you really want to delete this package", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if(buttonType.get().equals(ButtonType.YES)){
                packageBO.deletePackage(lblPackageID.getText());
            }
            managePackageCommon();
            loadPackageSettingCombo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveNewPackageOnAction(ActionEvent actionEvent) {
        if(cmbHandlePackageType.getSelectionModel().getSelectedItem() == null){
            cmbHandlePackageType.requestFocus();
        }else if(cmbPackageCellID.getSelectionModel().getSelectedItem() == null){
            cmbPackageCellID.requestFocus();
        }else if(pickerOutDate.getValue().toString() == null) {
            pickerOutDate.requestFocus();
        }else if(cmbPackageCustomerID.getSelectionModel().getSelectedItem() == null){
            cmbPackageCustomerID.requestFocus();
        }else{
            Package packageType = cmbHandlePackageType.getSelectionModel().getSelectedItem();
            String packageID = packageType.getId();
            String packagePrice = packageType.getPrice();
            String cellID = cmbPackageCellID.getSelectionModel().getSelectedItem();
            String inDate = lblDate.getText();
            String outDate = pickerOutDate.getValue().toString();
            String invoice = lblPackageInvoiceNumber.getText();
            String customerID = cmbPackageCustomerID.getSelectionModel().getSelectedItem();

            PackagePayment packagePayment = new PackagePayment(packageID, packagePrice, cellID, inDate, outDate, invoice,customerID);
            PackageCells packageCells = new PackageCells(cellID, "reserved");
            try {
                boolean result = packagePaymentBO.add(packagePayment, packageCells);
                if(result){
                    new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
                    cmbHandlePackageType.getSelectionModel().select(null);
                    txtPackagePrice.clear();
                    cmbPackageCellID.getSelectionModel().select(null);
                    pickerOutDate.setValue(null);
                    lblPackageInvoiceNumber.setText(loadInvoiceNumber());
                    setPackageCellColors();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btnPackageSearchInvoiceOnAction(ActionEvent actionEvent) {
        if(txtPackageInvoiceSerach.getText().trim().isEmpty()){
            txtPackageInvoiceSerach.requestFocus();
        }else{
            String invoiceNumber = txtPackageInvoiceSerach.getText();
            try {
                PackagePayment search = packagePaymentBO.search(invoiceNumber);
                lblInDate.setText(search.getInDate());
                lblOutDate.setText(search.getOutDate());
                txtCellIdPackage.setText(search.getCellid());
                String currentDate = lblDate.getText();

                int outInt = Integer.parseInt(search.getOutDate().substring(8, 10));
                int currentInt = Integer.parseInt(currentDate.substring(8, 10));

                if(currentInt < outInt){
                    lblNetpaymentPackage.setText(search.getPrice());
                }else{
                    String price = search.getPrice();
                    price = price.substring(0, price.length() - 3);
                    int priceInt = Integer.parseInt(price);
                    lblNetpaymentPackage.setText((priceInt+500) + "");
                    lblExtraChargePackage.setText("500");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        btnPayPackage.setDisable(false);

    }

    public void btnPayPackageOnAction(ActionEvent actionEvent) {
        String invoice = txtPackageInvoiceSerach.getText();
        String netPayment = lblNetpaymentPackage.getText();
        String date = lblDate.getText();

        Payment payment = new Payment(invoice,netPayment,date);
        PackageCells packageCells = new PackageCells(txtCellIdPackage.getText(),"not reserved");
        try {
            boolean result = packagePaymentBO.pay(payment, packageCells);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Success").showAndWait();
            }

            txtCellIdPackage.clear();
            lblInDate.setText("");
            lblOutDate.setText("");
            lblNetpaymentPackage.setText("");
            lblExtraChargePackage.setText("");
            btnPayPackage.setDisable(true);
            txtPackageInvoiceSerach.clear();
            setPackageCellColors();
            txtPackageInvoiceSerach.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnAddNewUserOnAction(ActionEvent actionEvent) {
        commonRegisterNewUser(false);
        btnDeleteUsers.setDisable(true);
        txtUserFullName.requestFocus();
    }

    private void loadNewUserID() {
        try {
            lblUserID.setText(usersBO.getNewUserID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveUsersOnAction(ActionEvent actionEvent) {
        if(txtUserFullName.getText().trim().isEmpty()){
            txtUserFullName.requestFocus();
        }else if(txtUserNIC.getText().trim().isEmpty()){
            txtUserNIC.requestFocus();
        }else if(txtUserAddress.getText().trim().isEmpty()){
            txtUserAddress.requestFocus();
        }else if(txtUserContact.getText().trim().isEmpty()){
            txtUserContact.requestFocus();
        }else if(txtUserMail.getText().trim().isEmpty()){
            txtUserMail.requestFocus();
        }else if(txtUserNewPassword.getText().trim().isEmpty()){
            txtUserNewPassword.requestFocus();
        }else if(txtUserConfirmPassword.getText().trim().isEmpty()){
            txtUserConfirmPassword.requestFocus();
        }else if(txtUserNameToSystem.getText().trim().isEmpty()){
            txtUserNameToSystem.requestFocus();
        }else if(cmbUserRole.getSelectionModel().getSelectedItem() == null){
            cmbUserRole.requestFocus();
        }else if(txtUserFullName.getText().trim().matches("[a-z A-Z.]+")){
            lblUserOnlyCharacters.setVisible(false);
            if(txtUserNIC.getText().trim().matches("\\d{9}[vV]")){
                lblUserNICCorrectFormat.setVisible(false);
                if(txtUserContact.getText().trim().matches("\\d{3}[-]\\d{7}")){
                    lblUserContactCorrectFormat.setVisible(false);
                    if(txtUserMail.getText().trim().matches("[a-z0-9]+[@][a-z]+[.][a-z]+")){
                        lblUserEmailCOrrectFormat.setVisible(false);
                        if(txtUserConfirmPassword.getText().equals(txtUserNewPassword.getText())){
                            lblPasswordMatch.setVisible(false);
                            if(btnSaveUsers.getText().equals("Save")){
                                saveUsers();
                            }else{
                                updateUsers();
                            }

                            commonRegisterNewUser(true);
                        }else{
                            lblPasswordMatch.setVisible(true);
                            txtUserConfirmPassword.requestFocus();
                        }
                    }else{
                        lblUserEmailCOrrectFormat.setVisible(true);
                        txtUserMail.requestFocus();
                    }
                }else{
                    lblUserContactCorrectFormat.setVisible(true);
                    txtUserContact.requestFocus();
                }
            }else{
                lblUserNICCorrectFormat.setVisible(true);
                txtUserNIC.requestFocus();
            }
        }else{
            lblUserOnlyCharacters.setVisible(true);
            txtUserFullName.requestFocus();
        }
    }

    private void updateUsers() {
        try {
            boolean result = usersBO.updateUser(lblUserID.getText(),
                    txtUserFullName.getText(),
                    txtUserNIC.getText(),
                    txtUserAddress.getText(),
                    txtUserContact.getText(),
                    txtUserMail.getText(),
                    txtUserConfirmPassword.getText(),
                    txtUserNameToSystem.getText(),
                    cmbUserRole.getSelectionModel().getSelectedItem());

            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully Updated").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try {
            boolean result = usersBO.saveUser(lblUserID.getText(),
                    txtUserFullName.getText(),
                    txtUserNIC.getText(),
                    txtUserAddress.getText(),
                    txtUserContact.getText(),
                    txtUserMail.getText(),
                    txtUserConfirmPassword.getText(),
                    txtUserNameToSystem.getText(),
                    cmbUserRole.getSelectionModel().getSelectedItem());

            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"SuccessFully Addedd").showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteUsersonAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Do you really want to delete this User", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if(buttonType.get().equals(ButtonType.YES)){
            try {
                usersBO.deleteUser(lblUserID.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        commonRegisterNewUser(true);
    }
}
