/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.util.List;

/**
 *
 * @author nemus
 */
public interface BookDAO extends DAO{
    public long insertBook(Book book);
    public boolean updateBook(Book book);
    public boolean deleteBook(Book book);
    
    public List<Book> findBookByProperty(BookSearchType searchType, Object value);
    public List<Book> findAll();
}
