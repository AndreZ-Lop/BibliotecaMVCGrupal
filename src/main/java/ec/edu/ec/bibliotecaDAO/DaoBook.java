package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.Book;
import java.util.List;

public interface DaoBook {
    
    void create(Book book);
    Book search(int ISBN);
    boolean delete(int ISBN);
    List<Book> listBooks();
}
