/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.models;

import java.util.List;
import ec.edu.ups.biblioteca.models.Book;
import java.util.ArrayList;
import java.util.Date;

public class Author extends Person{
    private String nationality;
    private List<Book> authorBooks;
    
    public Author(){
        authorBooks = new ArrayList<>();
    }

    public Author(String nationality, List<Book> authorBooks,String name,int iD, Date birthday) {
        super(name,iD,birthday);
        this.nationality = nationality;
        this.authorBooks = authorBooks;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public List<Book> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<Book> authorBooks) {
        this.authorBooks = authorBooks;
    }
    
    public void addBook(Book book){
        authorBooks.add(book);
    }
    
}
