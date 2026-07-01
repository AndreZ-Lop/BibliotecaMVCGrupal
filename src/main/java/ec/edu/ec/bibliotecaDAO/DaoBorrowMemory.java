/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Book;
import ec.edu.ups.biblioteca.models.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DaoBorrowMemory implements DaoBorrow{
    private List<User> users;
    private List<Book> books;

    public DaoBorrowMemory() {
        books  = new ArrayList<>();
        users = new ArrayList<>();
    }

    @Override
    public void logIn(String correo, String contrasenia) {
        if(users.isEmpty());
        for(User userSearch : users){
            if(correo == userSearch.getMail()){
                userSearch.setMail(correo);
                userSearch.setPassword(contrasenia);
            }
        }
    }

    @Override
    public boolean order(String nombre) {
        if(books.isEmpty()) return false;
        for(Book searchBook : books){
            if(nombre == searchBook.getTitulo()){
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean returns(String nombre) {
        if(books.isEmpty()) return false;
        for(Book searchBook : books){
            if(nombre == searchBook.getTitulo()){
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean borrow(String nombre) {
        if(books.isEmpty()) return false;
        for(Book searchBook : books){
            if(nombre == searchBook.getTitulo()){
                return  true;
            }
        }
        return false;
    }
    
    
    
    
}
