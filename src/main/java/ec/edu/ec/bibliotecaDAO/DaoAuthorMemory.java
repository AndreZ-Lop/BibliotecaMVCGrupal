/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Author;

import java.util.ArrayList;
import java.util.List;

public class DaoAuthorMemory implements DaoAuthor{
    private List<Author> authors;
    private int indexSearch;

    public DaoAuthorMemory() {
        authors = new ArrayList<>();
        this.indexSearch = -1;
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
    public boolean getIndexUpdate(int idSearch) {
        if(authors.isEmpty())return false;
        for(int i = 0;i<authors.size();i++){
            if(idSearch == authors.get(i).getiD()){
                this.indexSearch = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(String nation, String name) {
        int index = this.indexSearch;
        authors.get(index).setName(name);
        authors.get(index).setNationality(nation);
        this.indexSearch = -1;
    }
}
