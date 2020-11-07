/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vermsudh;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import prog24178.labs.objects.CookieInventoryItem;

/**
 *
 * @author verms
 */
public class CookieInventoryFile extends ArrayList<CookieInventoryItem>{
     
    
    public CookieInventoryFile(){}
    public CookieInventoryFile(File file){
       writeToFile(file);
       loadFromFile(file);
    }
   
    public CookieInventoryItem find(int id ){
        //"this" is used to reference the arraylist
       for(int i =0;i< this.size();i++){
           CookieInventoryItem temp = this.get(i);
//           if(id == temp.getCookie()){}
       }
       
       return null;
        //why we dont have a getter method for the cookie so that we can match the id

    }
    
    public void loadFromFile(File file){
        try {
            Scanner in = new Scanner(file);
            while(in.hasNext()){
                //Get input line by line
                //Use input(Input as in "1|124", the string input from the file) to make CookieInventoryItem object
                //Add the object to "this" arraylist ex. this.add(...)
                String line = in.nextLine();
                String item = "";
                int id = 0, qty = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.substring(i, i + 1).equals("|")) {
                        id = Integer.parseInt(item);
                        item = "";
                    }else {
                        item += line.substring(i, i + 1);
                    }
                }
                qty = Integer.parseInt(item);
                CookieInventoryItem cit = new CookieInventoryItem(id, qty);
                this.add(cit);
            }
           }catch (FileNotFoundException ex) {
            Logger.getLogger(CookieInventoryFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void writeToFile(File file){
            System.out.println("Hello file" +file.getName());
            CookieInventoryItem c1 = null;

        for(int i =0; i<this.size();i++){
            c1 = this.get(i);
            
        }
         
            
	    try{
		    FileWriter fw = new FileWriter (file, true);
		    BufferedWriter bf = new BufferedWriter(fw);
                try (PrintWriter output = new PrintWriter(bf)) {
                    output.println(c1.toFileString());
                }
	    }
	    catch(IOException e){
		    System.out.println(e.getMessage());
	    }
            
    }
}
