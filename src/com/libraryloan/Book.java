/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryloan;

import java.util.List;
import java.util.Objects;


public class Book {
    
    private long uniqueID;
    private String name;
    private List<String> authors;
    private int publishedYear;
    private boolean available;
    
    public Book(){
        
    }
    public Book(String name, List<String> authors, int publishedYear, boolean available){
        this.name=name;
        this.authors=authors;
        this.publishedYear=publishedYear;
        this.available=available;
    }
    /**
     * @return the uniqueID
     */
    public long getUniqueID() {
        return uniqueID;
    }

    /**
     * @param uniqueID the uniqueID to set
     */
    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the authors
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * @return the publishedYear
     */
    public int getPublishedYear() {
        return publishedYear;
    }

    /**
     * @param publishedYear the publishedYear to set
     */
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.authors);
        hash = 31 * hash + this.publishedYear;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Book ID ").append(uniqueID);
        builder.append(" Name: ").append(name);
        builder.append(" Authors: ").append(authors);
        builder.append(" Published Year: ").append(publishedYear);
        builder.append(" Available: ").append(available);
        
        return builder.toString();
    }
}
