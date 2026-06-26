/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Author;
import ec.edu.ups.biblioteca.models.Book;
import java.util.ArrayList;
import java.util.List;

public class DaoAuthorMemory implements DaoAuthor{
    private List<Author> authors;

    public DaoAuthorMemory() {
        authors = new ArrayList<>();
    }

    @Override
    public void create(Author author) {
        authors.add(author);
    }

    @Override
    public Author search(int idSearch) {
        if(authors.isEmpty()) return null;
        for(Author search :authors){
            if(idSearch == search.getiD()){
                return search;
            }
            
        }
        return null;
    }

    @Override
    public boolean update(int idSearch,String name, String gender) {
        if(authors.isEmpty()) return false;
        for(Author search :authors){
            if(idSearch == search.getiD()){
                search.setName(name);
                search.setGender(gender);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int idSearch) {
        if(authors.isEmpty()) return false;
        for(int i = 0; i < authors.size();i++){
            if(idSearch == authors.get(i).getiD()){
                authors.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Author> getList() {
        return authors;
    }

    @Override
    public void addBook(Book book, int idSearch) {
        if(authors.isEmpty()) return;
        for(Author search :authors){
            if(idSearch == search.getiD()){
                search.addBook(book);
                return;
            }
        }
        
    }
}
