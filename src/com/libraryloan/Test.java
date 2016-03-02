/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nemus
 */
public class Test {
    
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
    public static void main(String[] args) throws Exception{
        BookDAO book = new DerbyBookDAO();
        book.setup();
        
        Library model = new Library(book);
        
       /* 
        model.addNewBook("TestName1", "John Smith_Jack_Jane Smith_Jane Smith", 2010);
        model.addNewBook("TestName1", "John Smith_Jack_Jane Smith_Jane Smith", 2010);
        model.addNewBook("TestName1", "John Smith_Jack_Jane Smith_Jane Smith", 2010);
        model.addNewBook("TestName1", "John Smith_Jack_Jane Smith_Jane Smith", 2010);
        model.addNewBook("TestName1", "John Smith_Jack_Jane Smith_Jane Smith", 2010);
        
         model.addNewBook("TestName2", "John Smith_Jack_Jane Smith_Jane Smith", 2013);
        model.addNewBook("TestName2", "John Smith_Jack_Jane Smith_Jane Smith", 2013);
        model.addNewBook("TestName2", "John Smith_Jack_Jane Smith_Jane Smith", 2013);
        model.addNewBook("TestName2", "John Smith_Jack_Jane Smith_Jane Smith", 2013);
        model.addNewBook("TestName2", "John Smith_Jack_Jane Smith_Jane Smith", 2013);
        
         model.addNewBook("TestName3", "Jane Smith", 2014);
        model.addNewBook("TestName3", "Jane Smith", 2014);
        model.addNewBook("TestName3", "Jane Smith", 2014);
        model.addNewBook("TestName3", "Jane Smith", 2014);
        model.addNewBook("TestName3", "Jane Smith", 2014);
        */
        book.close();
    }
}
