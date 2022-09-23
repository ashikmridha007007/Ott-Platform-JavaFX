/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ott.platform;

import Class.User;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class CreateController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuItem loginMenuItem;
    @FXML
    private TextField nameTxt;
    @FXML
    private TextField passwordTxt;
    @FXML
    private TextField cPasswordTxt;
    @FXML
    private TextField phoneNumberTxt;
    @FXML
    private TextField eIdTxt;
    @FXML
    private Button createNewAccountBtn;
    @FXML
    private ComboBox userTypeComboBox;
    @FXML
    private Label passwordMatchLabel;
    @FXML
    private Label accountCreationLabel;
    @FXML
    private MenuItem closeMenuItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Accountant","Owner","Content Provider","Viewer");
        userTypeComboBox.setItems(list);
    }    

    

    @FXML
    private void createNewAccountBtnOnClick(ActionEvent event) {
        
         passwordMatchLabel.setText("");
        accountCreationLabel.setText("");
        
        String userType = userTypeComboBox.getSelectionModel().getSelectedItem().toString();
        String name = nameTxt.getText();
        String password = passwordTxt.getText();
        String cPassword = cPasswordTxt.getText();
        String phoneNumber = phoneNumberTxt.getText();
        String eid = eIdTxt.getText();
        
        User u1 = new User (name, userType, eid, password, phoneNumber);        
        
        if(password.equals(cPassword)){
            try {
                FileWriter fw = new FileWriter("user.txt", true);
                
                String str = new String();
                
                str += u1.getUserType()+","+u1.getName()+","+u1.getPassword()+","+u1.getPhoneNumber()+","+u1.getEid()+"\n";

                fw.write(str);
                fw.close();
                
                accountCreationLabel.setText("account created successfully");
                
            } catch (IOException ex) {
                Logger.getLogger(OTTPLATFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            passwordMatchLabel.setText("Password does not match");
        }
        
    }
    
    @FXML
    private void loginMenuItemOnClick(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)borderPane.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void closeMenuItemOnClick(ActionEvent event) {
        
         Platform.exit();
        System.exit(0);
    }
    
}
