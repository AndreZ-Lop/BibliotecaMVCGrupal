/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.BookBorrow;
import java.util.ArrayList;
import java.util.List;

public class DaoBookBorrowMemory implements DaoBookBorrow{
    
    private List<BookBorrow> borrows;
    
    public DaoBookBorrowMemory(){
        borrows = new ArrayList<>();
    }

    @Override
    public void createBorrow(BookBorrow borrow) {
        borrows.add(borrow);
    }

    @Override
    public BookBorrow searchBorrow(int idSearch) {
        if(borrows.isEmpty()) return null;
        for(BookBorrow search: borrows){
            if(idSearch == search.getTransactionNumber())
                return search;
        }
        
        return null;
    }

    @Override
    public boolean deleteBorrow(int idSearch) {
        if(borrows.isEmpty()) return false;
        for(int i = 0;i<borrows.size();i++){
            if(idSearch == borrows.get(i).getTransactionNumber()){
                borrows.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<BookBorrow> listBorrow() {
        return borrows;
    }
    
}
