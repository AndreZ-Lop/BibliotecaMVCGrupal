package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Book;
import ec.edu.ups.biblioteca.models.BookBorrow;
import ec.edu.ups.biblioteca.models.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoBorrowMemory implements DaoBorrow{
    private List<BookBorrow> borrows;
    private DaoUser daoUser;
    private int transactionNumber;

    public DaoBorrowMemory(DaoUser daoUser) {
        this.daoUser = daoUser;
        this.borrows = new ArrayList<>();
        this.transactionNumber = 0;
        
    }
    

    @Override
    public void newBorrow(User user,Book book) {
        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(7);
        transactionNumber ++;
        borrows.add(new BookBorrow(user,book,this.transactionNumber,returnDate));
    }

    @Override
    public boolean returnBorrowU(int index) {
       
       return false;
    }

    @Override
    public List<BookBorrow> listUsers() {
        return this.borrows;
    }
   
}
