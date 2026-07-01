/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Book;
import ec.edu.ups.biblioteca.models.BookBorrow;
import ec.edu.ups.biblioteca.models.User;
import java.util.List;

public interface DaoBorrow {
    
    void newBorrow(User user,Book book);
    boolean returnBorrowU(int index);
    List<BookBorrow> listUsers();
    
}
