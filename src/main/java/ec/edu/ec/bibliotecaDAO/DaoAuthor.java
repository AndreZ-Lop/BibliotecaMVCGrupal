/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Author;
import ec.edu.ups.biblioteca.models.Book;
import java.util.List;

public interface DaoAuthor{
    
    void create(Author author);
    Author search(int idSearch);
    boolean update(int idSearch, String name,String gender);
    boolean delete(int idSearch);
    void addBook(Book book,int searchId);
    List<Author> getList();
    
}
