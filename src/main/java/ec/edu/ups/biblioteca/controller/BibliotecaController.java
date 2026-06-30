/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controller;

import ec.edu.ec.bibliotecaDAO.DaoBook;
import ec.edu.ec.bibliotecaDAO.DaoAuthor;
import ec.edu.ec.bibliotecaDAO.DaoAuthorMemory;
import ec.edu.ec.bibliotecaDAO.DaoBookMemory;
import ec.edu.ec.ups.biblioteca.view.*;
import ec.edu.ups.biblioteca.models.Author;
import ec.edu.ups.biblioteca.models.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author LAB_04
 */
public class BibliotecaController {
    private DaoBook daoBook;
    private CreateBookView createBookView;
    private DeleteBookView deleteBookView;
    private SearchBookView searchBookView;
    private ListBookView listBookView;
    private DaoAuthor daoAuthor;

    public BibliotecaController() {
        configurateEvents();
    }

    public BibliotecaController(DaoAuthor daoAuthorMemory,DaoBook daoBookMemory, CreateBookView createBookView, DeleteBookView deleteBookView, SearchBookView searchBookView, ListBookView listBookView){
        this.daoAuthor = daoAuthorMemory;
        this.daoBook = daoBookMemory;
        this.createBookView = createBookView;
        this.deleteBookView = deleteBookView;
        this.searchBookView = searchBookView;
        this.listBookView = listBookView;
        configurateEvents();
    }
    
    

    
    
    public void configurateEvents(){
        configurateEventsCreateBook();
        configurateEventsListBook();
        configurateCloseWindow();
        configurateEventsDeleteBook();
        configurateEventsSearchBook();
    }
    //Cotroladores del libro
    public void createBook(){
        String tittle = createBookView.getTxtTittle().getText();
        int isbn = Integer.parseInt(createBookView.getTxtISBN().getText());
        String genreL = createBookView.getTxtGenre().getText();
        int day = Integer.parseInt(createBookView.getTxtDay().getText());
        int month = Integer.parseInt(createBookView.getTxtMonth().getText());
        int year = Integer.parseInt(createBookView.getTxtYear().getText());
        String language = createBookView.getTxtBookLanguage().getText();
        Date date = new Date(year-1900,month-1,day);
        boolean restriction = false;
        if(createBookView.getCheckBoxYes().isSelected()){
            restriction = true;
        }
        Author author = daoAuthor.search(Integer.parseInt(createBookView.getTxtBookAuthor().getText()));
        if(author == null){
            Author unknowAuthor = new Author("Desconocida","No especificado",null,"Desconocido",000000000,new Date(1900,00,1));
            daoBook.create(new Book (tittle,isbn,genreL,date,unknowAuthor,language,true,restriction));
            
        }else{
            daoBook.create(new Book (tittle,isbn,genreL,date,author,language,true,restriction));
        }
        
    }
    public void configurateEventsCreateBook(){
        createBookView.getBtnAdd().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ){
                createBook();
            }
        });
    }
    
    public void ListBook(){
        List<Book> book = daoBook.listBooks();
        listBookView.chargeData(book);
    }
    
    public void configurateEventsListBook(){
        listBookView.getBtnList().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ListBook();
                listBookView.getBtnList().setEnabled(false);
            }
        });
    }
    
    public void configurateCloseWindow(){
        listBookView.addInternalFrameListener(new InternalFrameAdapter(){
            @Override
            public void internalFrameClosing(InternalFrameEvent e ){
                listBookView.getModel().setRowCount(0);
                listBookView.getBtnList().setEnabled(true);
            }
            
        });
    }
    public void deleteBook(){
        int isbn = Integer.parseInt(deleteBookView.getTxtISBN().getText());
        daoBook.delete(isbn);
    }
    
    public void configurateEventsDeleteBook(){
        deleteBookView.getBtnDelete().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteBook();
            }
        });
    }
    public void searchBook(){
        int isbn = Integer.parseInt(searchBookView.getTxtISBN().getText());
        daoBook.search(isbn);
    }
    
    public void configurateEventsSearchBook(){
        searchBookView.getBtnSearch().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchBook();
            }
        });
    }
   
    
        
}
    
