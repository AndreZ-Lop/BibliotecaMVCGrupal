/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Book;
import java.util.ArrayList;
import java.util.List;

public class DaoBookMemory implements DaoBook{
    
    private List<Book> books;
    
    public DaoBookMemory(){
        books = new ArrayList<>();
    }

    @Override
    public void create(Book book) {
       books.add(book);
    }

    @Override
    public Book search(int ISBN) {
       
        for(Book search:books){
            if(ISBN == search.getISBN()){
                return search;
            }
        }
        return null;
    }

    @Override
    public boolean delete(int ISBN) {
        if(books.isEmpty()) return false;
        for(int i = 0;i < books.size() ;i++){
            if(ISBN == books.get(i).getISBN()){
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> listBooks() {
        return books;
    }
    
}
