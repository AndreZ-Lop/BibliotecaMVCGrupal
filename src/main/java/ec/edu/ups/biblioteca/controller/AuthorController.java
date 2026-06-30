/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controller;

import ec.edu.ec.bibliotecaDAO.DaoAuthor;
import ec.edu.ec.ups.biblioteca.view.CreateAuthorView;
import ec.edu.ec.ups.biblioteca.view.DeleteAuthorView;
import ec.edu.ec.ups.biblioteca.view.SearchAuthorView;
import ec.edu.ec.ups.biblioteca.view.UpdateAuthorView;
import ec.edu.ups.biblioteca.models.Author;
import ec.edu.ups.biblioteca.models.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class AuthorController {
    private CreateAuthorView createAuthorView;
    private DeleteAuthorView deleteAuthorView;
    private SearchAuthorView searchAuthorView;
    private UpdateAuthorView updateAuthorView;
    private DaoAuthor daoAuthor;

    public AuthorController(CreateAuthorView createAuthorView, DeleteAuthorView deleteAuthorView, SearchAuthorView searchAuthorView, UpdateAuthorView updateAuthorView, DaoAuthor daoAuthor) {
        this.createAuthorView = createAuthorView;
        this.deleteAuthorView = deleteAuthorView;
        this.searchAuthorView = searchAuthorView;
        this.updateAuthorView = updateAuthorView;
        this.daoAuthor = daoAuthor;
        configurateEvents();
    }
     public void configurateEvents(){
         configurateEventsCreateAuthor();
         configurateEventsDeleteAuthor();
         configurateEventsSearchAuthor();
         configurateEventsUpdateAuthor();
         
    }
     // controladores de autor 
    public void createAuthor(){
        String nombre = createAuthorView.getTxtNameUser().getText();
        int id = Integer.parseInt(createAuthorView.getTxtIdUser().getText());
        int day = Integer.parseInt(createAuthorView.getTxtDayUser().getText());
        int month = Integer.parseInt(createAuthorView.getTxtMonthUser().getText());
        int year = Integer.parseInt(createAuthorView.getTxtyearUser().getText());
        List<Book> authBooks = new ArrayList<>();
        Date date = new Date(year-1900,month-1,day);
        String genreA = createAuthorView.getTxtGenderAuthor().getText();
        String national = createAuthorView.getTxtNacionality().getText();
        Author author = new Author(national,genreA,authBooks,nombre,id,date);
        daoAuthor.create(author);        
    }
    
    public void configurateEventsCreateAuthor(){
        createAuthorView.getBtnCreateUser().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createAuthor();
            }
        });
    }
    
    public void deleteAuthor(){
        int isbn = Integer.parseInt(deleteAuthorView.getTxtDeleteAuthor().getText());
        daoAuthor.delete(isbn);
    }
    public void configurateEventsDeleteAuthor(){
        deleteAuthorView.getBtnDelete().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteAuthor();
            }
        });
    }
    public void searchAuthor(){
        int id= Integer.parseInt(searchAuthorView.getTxtAuthorSearch().getText());
        Author authorFounded = daoAuthor.search(id);
        if(authorFounded == null ){
            JOptionPane.showMessageDialog(searchAuthorView,"No se encontro el autor");
        }else{
            JOptionPane.showMessageDialog(searchAuthorView, """
                                                          Autor Encontrado
                                                          Nombre: """ + authorFounded.getName() + "\nNacionalidad: " + authorFounded.getNationality()
                                                          + "\nCedula: " + authorFounded.getiD());
        }
    }
    
    public void  configurateEventsSearchAuthor(){
        searchAuthorView.getBtnSearch().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e ){
                searchAuthor();
            }
        });
    }
    
     public void configurateShowOptions(){
        if(!daoAuthor.getIndexUpdate(Integer.parseInt(updateAuthorView.getTxtIdSearch().getText()))){
            JOptionPane.showMessageDialog(updateAuthorView,"Usuario no encontrado");
            updateAuthorView.getBtnUpdate().setEnabled(false);
            updateAuthorView.getTxtNewName().setEnabled(false);
            updateAuthorView.getTxtNewNation().setEnabled(false);
        }else{
            updateAuthorView.getBtnUpdate().setEnabled(true);
            updateAuthorView.getTxtNewName().setEnabled(true);
            updateAuthorView.getTxtNewNation().setEnabled(true);
        }
    }
    
    //actualizar
    public void configurateUpdate(){
        String newName = updateAuthorView.getTxtNewName().getText();
        String newNation = updateAuthorView.getTxtNewNation().getText();
        daoAuthor.update(newName,newNation);
    }
    
    public void configurateEventsUpdateAuthor(){
        updateAuthorView.getBtnSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               configurateShowOptions();
            }
        });
        updateAuthorView.getBtnUpdate().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateUpdate();
            }
        });
    }
    
    
    
}
