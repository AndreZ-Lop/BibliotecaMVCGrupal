/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controller;

import ec.edu.ec.bibliotecaDAO.DaoBook;
import ec.edu.ec.bibliotecaDAO.DaoBorrow;
import ec.edu.ec.bibliotecaDAO.DaoUser;
import ec.edu.ec.ups.biblioteca.view.BorrowsView;
import ec.edu.ec.ups.biblioteca.view.ListBorrowsView;
import ec.edu.ec.ups.biblioteca.view.LogInView;
import ec.edu.ec.ups.biblioteca.view.ReturnsView;
import ec.edu.ups.biblioteca.models.Book;
import ec.edu.ups.biblioteca.models.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class BorrowsController {
    private LogInView logInView;
    private BorrowsView borrowView;
    private ReturnsView returnsView;
    private ListBorrowsView listBorrowView;
    private JMenuItem logOutMenu;
    private DaoUser daoUser;
    private DaoBook daoBook;
    private DaoBorrow daoBorrow;
    private JDesktopPane desktop;
    private User loggedUser;
    private int indexUser;

    public BorrowsController(LogInView logInView, BorrowsView borrowView, ReturnsView returnsView, ListBorrowsView listBorrowView, JMenuItem logOutMenu, DaoBook daoBook, DaoUser daoUser, DaoBorrow daoBorrow,JDesktopPane desktop) {
        this.logInView = logInView;
        this.borrowView = borrowView;
        this.returnsView = returnsView;
        this.listBorrowView = listBorrowView;
        this.logOutMenu = logOutMenu;
        this.daoUser = daoUser;
        this.daoBook = daoBook;
        this.daoBorrow = daoBorrow;
        this.desktop = desktop;
        this.loggedUser = null;
        this.indexUser = 0;
        configurate();
    }

    public void configurate() {
        //LogIn
        configurateButton();
        //borrow
        configurateButtonBorrow();
        configurateButtonBorrowCancel();
        //list
        configurateButtonList();
        configurateButtonListCancel();
        //delete
        
        
    }
    
    //log in
    public boolean configurateView(){
        String mail = logInView.getTxtMailLogIn().getText();
        String password = logInView.getTxtPassord().getText();
        if(daoUser.listUsers().isEmpty()) return false;
        for (int i = 0; i < daoUser.listUsers().size(); i++){
            if (daoUser.listUsers().get(i).getMail().equals(mail) && daoUser.listUsers().get(i).getPassword().equals(password)) {
                this.loggedUser = daoUser.listUsers().get(i);
                this.indexUser = i;
                
                return true;
            }
        }
        return false;
       
    }
    public void configurateButton(){
        logInView.getBtnLogIn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateView();
       
            }
        });
        
    }
    
    //borrows
    public void configurateBorrowView(){
        String name = borrowView.getTxtBorrows().getText();
        boolean find = false;
        if(loggedUser == null){ 
            JOptionPane.showMessageDialog(borrowView, "Necesita iniciar sesion");
        }else{
            for(Book book : daoBook.listBooks()){
                if(book.getTitulo().equals(name)){
                    find = true;
                    if(!book.getEstado()){
                        JOptionPane.showMessageDialog(borrowView,"No se encuentra disponible por el momento");
                      
                    }else{
                        if(book.getRestriccionesLibro() && loggedUser.isRestrictions()){
                            JOptionPane.showMessageDialog(borrowView,"Menores de edad no pueden solicitar este libros");
                        }else{
                            book.setEstado(false);
                            daoUser.listUsers().get(indexUser).setCanRequest(false);
                            daoBorrow.newBorrow(loggedUser, book);
                            JOptionPane.showMessageDialog(borrowView,"Prestamo realizado");
                            break;
                        }
                    }
                }
            }
            if(!find){
                JOptionPane.showMessageDialog(borrowView, "No se encontro el libro solicitado");
            }
        }
    }
    
    public void configurateButtonBorrow(){
        borrowView.getBtnBorrow().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateBorrowView();
            }
        });
    }
    
    public void configurateButtonBorrowCancel(){
        borrowView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                borrowView.dispose();
            }
        });
    }
    
    //list
    public void configurateListView(){
        listBorrowView.listElements(daoBorrow.listUsers());
    }
    public void configurateButtonList(){
        listBorrowView.getBtnBorrowList().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateListView();
                listBorrowView.getBtnBorrowList().setEnabled(false);
            }
        });
    }
    
    public void configurateButtonListCancel(){
        listBorrowView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                listBorrowView.dispose();
            }
        });
    }
    
    public void closing(){
        listBorrowView.addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e){
                listBorrowView.getBtnBorrowList().setEnabled(true);
                listBorrowView.getModel().setRowCount(0);
            }
        });
    }
    
    //delete
    public void configurateReturnBorrow(){
        String search = returnsView.getTxtReturn().getText();
        for(int i = 0;i<daoBorrow.listUsers().size();i++){
            if(daoBorrow.listUsers().get(i).getBookBorrowed().getTitulo().equals(search)){
                daoBorrow.returnBorrowU(i);
                JOptionPane.showMessageDialog(returnsView, "Libro devuelto");
            }else{
                JOptionPane.showMessageDialog(returnsView, "No se encontro ningun libro con ese nombre");
            }
        }
    }
    
    public void configurateButtonDelete(){
       returnsView.getBtnReturn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateListView();
                returnsView.getBtnReturn().setEnabled(false);
            }
        });
    }
    
    public void configurateButtonDeleteCancel(){
        returnsView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                returnsView.dispose();
            }
        });
    }
    //logOUT
    public void configurateButtonDeleteLogOut(){
        logOutMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                loggedUser = null;
                JOptionPane.showMessageDialog(desktop, "Se cerro sesion");
            }
        });
    }
    
    
    
}
