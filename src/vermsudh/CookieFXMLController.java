/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vermsudh;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import prog24178.labs.objects.Cookies;
import prog24178.labs.objects.CookieInventoryItem;

/**
 * FXML Controller class
 *
 * @author verms
 */
public class CookieFXMLController implements Initializable {
    
    @FXML 
    private Button addbtn, sellbtn, exitButton;
    @FXML
    private ComboBox<Cookies> comboBox;
    @FXML
    private TextField qtySold, qtyBaked;
    
    CookieInventoryItem cInvItem = new CookieInventoryItem();
    CookieInventoryFile cInvFile = new CookieInventoryFile();
    List<CookieInventoryItem> itemList = new ArrayList<CookieInventoryItem>();
   
    @FXML
     void CloseButtonAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.NONE);

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Exit Program?");
        alert.setContentText("Are you sure you wish to exit?");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        }
    }
    @FXML 
     void sellButtonAction(ActionEvent event){
        if(qtySold.getText().equals("")){
        Alert a = new Alert(Alert.AlertType.ERROR);
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Please enter the number of cookies sold.");
        alert.setTitle("Data Entry Error");
        Optional<ButtonType> showAndWait = alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
            }
        }else if(String.valueOf(cInvItem.getQuantity()).equals(qtySold.getText())) {
              System.out.println(cInvItem.getQuantity());
              System.out.println("Hello this is sell button");
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setHeaderText("Sorry, there are no "+comboBox.getValue());
              alert.setTitle("Insuffient Inventory");
          }
    }
    @FXML
    void addButtonAction(ActionEvent event){
        if (qtyBaked.getText().equals("")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Please enter the number of cookies added.");
                alert.setTitle("Data Entry Error");
                Optional<ButtonType> showAndWait = alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    System.exit(0);
                }
            
       }else if( Integer.parseInt(qtyBaked.getText())>0){
            for(Cookies cook : Cookies.values()) {
                
    	        if(cook.equals(comboBox.getValue())) {
                            cInvItem = new CookieInventoryItem(cook.getId(), Integer.parseInt(qtyBaked.getText()));
                    itemList.add(cInvItem);
                    System.out.println("item list" + itemList);
                    
    		}	
    	    }
             File f = new File("cookies.dat");
           CookieInventoryFile f1 = new CookieInventoryFile();
           f1.addAll(itemList);
           f1.writeToFile(f);
        }
               
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.setItems(observableArrayList(Cookies.values()));
        
    }    
    
}
