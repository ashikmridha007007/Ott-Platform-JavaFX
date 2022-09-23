/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ott.platform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FreecontentFxmlController implements Initializable {

    @FXML
    private TextField names;
    @FXML
    private Pane paneView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dsiplayimage(ActionEvent event) {
        paneView.getChildren().clear();
        String name= names.getText();
        Image image= new Image("file:///C:/images/"+name+".jpg");
        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
        imageview.setFitWidth(200);
        imageview.setFitHeight(200);
        paneView.getChildren().add(imageview);
    }
    
}
