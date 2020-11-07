/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vermsudh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author verms
 */
public class Assign5 extends Application {
    public static void main (String []args){
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             
          Parent root = FXMLLoader.load(getClass().getResource("CookieFXML.fxml"));
          stage.setTitle("Cookie Inventory");
          Scene s = new Scene(root);
          stage.setScene(s);
          stage.show();
    }
}
