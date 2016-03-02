/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nemus
 */
public class Main extends Application {
    
    private BookDAO buildDAO(){
        return new DerbyBookDAO();
    }
    private Library buildModel(){
        try {
            return new Library(buildDAO());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private BookController buildController(Stage stage){
        return new BookController(buildModel(), stage);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Book.fxml"));
        loader.setControllerFactory(t -> buildController(stage));
        
        
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
