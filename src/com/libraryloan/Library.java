/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nemus
 */
public class Library {
    
    private BookDAO bookDAO;
    
    public Library(BookDAO bookDAO) throws Exception{
        this.bookDAO=bookDAO;
        bookDAO.connect();
    }
    public void addNewBook(String name, String authors, int year){
        // probaj da ubacis new Book(name ,authors, year)
        Book book = new Book();
        book.setAvailable(true);
        book.setName(name);
        book.setAuthors(authors);
        book.setPublishedYear(year);
        bookDAO.insertBook(book);
    }
    public void loanBook(long uniqueID){
       List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
       if(books.size() > 0){
           books.get(0).setAvailable(false);
           bookDAO.updateBook(books.get(0));
       }
    }
    public void returnBook(long uniqueID){
         List<Book> books = bookDAO.findBookByProperty(BookSearchType.ID, uniqueID);
       if(books.size() > 0){
           books.get(0).setAvailable(true);
           bookDAO.updateBook(books.get(0));
       }
    }
    
    public List<Book> search(BookSearchType searchType, String value){
        return bookDAO.findBookByProperty(searchType, value);
    }
    public void close(){
        try {
            bookDAO.close();
        } catch (Exception ex) {
            System.out.println("Error!");
            ex.printStackTrace();
        }
    }
}
