/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Author;

import java.util.List;

public interface DaoAuthor{
    
    void create(Author author);
    Author search(int idSearch);
    boolean getIndexUpdate(int idSearch);
    void update(String nation,String name);
    boolean delete(int idSearch);
    
}
