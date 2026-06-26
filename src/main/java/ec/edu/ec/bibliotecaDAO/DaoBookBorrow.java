/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.BookBorrow;
import java.util.List;

/**
 *
 * @author y2
 */
public interface DaoBookBorrow {
    void createBorrow(BookBorrow borrow);
    BookBorrow searchBorrow(int idSearch);
    boolean deleteBorrow(int idSearch);
    List<BookBorrow> listBorrow();
}
