/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author nemus
 */
public class DerbyBookDAO implements BookDAO{

    private Connection conn;
    private QueryRunner dbAccess = new QueryRunner();
    
    private static final List<Book> EMPTY = new ArrayList<>();
    
    @Override
    public long insertBook(Book book) {
       try{
           dbAccess.insert(conn, "INSERT INTO books(name, authors, publishedYear, available) VALUES(?, ?, ?, ?)", new ScalarHandler<BigDecimal>(),
                   book.getName(), book.getAuthors(), book.getPublishedYear(), book.isAvailable()).longValue();
           
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return -1L;
    }

    @Override
    public boolean updateBook(Book book) {
       try{
           dbAccess.update(conn, "UPDATE books SET name=?, authors=?, publishedYear=?, available=? WHERE uniqueID=?",
                   book.getName(), book.getAuthors(), book.getPublishedYear(), book.isAvailable());
           
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return false;
    }

    @Override
    public boolean deleteBook(Book book) {
        try{
           dbAccess.update(conn, "DELETE FROM books WHERE uniqueID=?", book.getUniqueID());
           
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return false;
    }

    @Override
    public List<Book> findBookByProperty(BookSearchType searchType, Object value) {
        String whereClause = "";
        String valueClause = "";
        
        switch(searchType){
            case AUTHORS:
                whereClause = "authors LIKE ?";
                valueClause = "%" + value.toString() + "%";
                break;
            case AVAILABLE:
                 whereClause = "available=?";
                 valueClause = value.toString();
                break;
            case ID:
                 whereClause = "uniqueID=?";
                 valueClause = value.toString();
                break;
            case NAME:
                 whereClause = "name LIKE ?";
                 valueClause = "%" + value.toString() + "%";
                break;
            case PUBLISH_YEAR:
                 whereClause = "publishedYear=?";
                 valueClause = value.toString();
                break;
            default:
                System.out.println("Unknown query");
                break;
        }
        try{
          return dbAccess.query(conn, "SELECT * FROM books WHERE" + whereClause, new BeanListHandler<Book>(Book.class),  valueClause);
           
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return EMPTY;
    }

    @Override
    public List<Book> findAll() {
       try{
           dbAccess.query(conn, "SELECT * FROM books", new BeanListHandler<Book>(Book.class));
           
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return EMPTY;
    }

    @Override
    public void setup() throws Exception {
     conn = DriverManager.getConnection("jdbc:derby:books.db;create=true");
     dbAccess.update(conn, "CREATE TABLE books ("
             + "uniqueID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
             + "name VARCHAR(80), authors(100), publishedYear INTEGER, available BOOLEAN"
     + ")");
    }

    @Override
    public void connect() throws Exception {
        conn = DriverManager.getConnection("jdbc:derby:books.db");
    }

    @Override
    public void close() throws Exception {
       conn.close();
       try{
           DriverManager.getConnection("jdbc:derby:books.db;shutdown=true");
       }catch(Exception e){}
    }
    
}
