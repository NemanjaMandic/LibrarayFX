/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author nemus
 */
public class BookController implements Initializable {
    
    @FXML
    private ChoiceBox<BookSearchType> choiceBox;
    
    @FXML
    private ListView<Book> listView;
    
    @FXML private TextField textField;
    
    private Library model;
    
    public BookController(Library model, Stage stage){
        this.model=model;
        stage.setOnCloseRequest(e -> model.close());
    }
    
    public void onSearch(ActionEvent event){
        String param = textField.getText(); 
       listView.getItems().setAll(model.search(choiceBox.getValue(), param));
    }
    public void onLoan(ActionEvent event){
        model.loanBook(listView.getSelectionModel().getSelectedItem().getUniqueID());
    }
    public void onReturn(ActionEvent event){
        model.returnBook(listView.getSelectionModel().getSelectedItem().getUniqueID());
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBox.getItems().setAll(BookSearchType.values());
        choiceBox.getSelectionModel().selectFirst();
                
    }    
    
}
