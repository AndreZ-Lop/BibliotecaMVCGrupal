/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ec.edu.ec.ups.biblioteca.view;

import ec.edu.ec.bibliotecaDAO.DaoAuthor;
import ec.edu.ec.bibliotecaDAO.DaoAuthorMemory;
import ec.edu.ec.bibliotecaDAO.DaoBook;
import ec.edu.ec.bibliotecaDAO.DaoBookMemory;
import ec.edu.ec.bibliotecaDAO.DaoBorrow;
import ec.edu.ec.bibliotecaDAO.DaoBorrowMemory;
import ec.edu.ec.bibliotecaDAO.DaoUser;
import ec.edu.ec.bibliotecaDAO.DaoUserMemory;
import ec.edu.ups.biblioteca.controller.AuthorController;
import ec.edu.ups.biblioteca.controller.BibliotecaController;
import ec.edu.ups.biblioteca.controller.BorrowsController;
import ec.edu.ups.biblioteca.controller.UserController;
import ec.edu.ups.biblioteca.models.User;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class PrincipalView extends javax.swing.JFrame {
    //Users View
    private CreateUserView createUserView;
    private SearchUserView searchUserView;
    private UpdateUserView updateUserView;
    private DeleteUserView deleteUserView;
    private ListUsersView listUsersView;
    
    //Book views
    private CreateBookView createBookView;
    private SearchBookView searchBookView;
    private DeleteBookView deleteBookView;
    private ListBookView listBookView;
    
    //Author views
    private CreateAuthorView createAuthorView;
    private SearchAuthorView searchAuthorView;
    private UpdateAuthorView updateAuthorView;
    private DeleteAuthorView deleteAuthorView;
    
    //Usurio logeado
    private User userLogged;
    
    //Menu prestamos
    private LogInView logInView;
    private BorrowsView borrowsView;
    private ListBorrowsView listBorrowsView;
    private ReturnsView returnsView;
    
    //DAO
    private DaoBook daoBook;
    private DaoUser daoUser;
    private DaoAuthor daoAuthor;
    private DaoBorrow daoBorrow;
    
    //Conotrollers
    private BibliotecaController controllerBliblio;
    private AuthorController authorController;
    private UserController userController;
    private BorrowsController borrowController;
    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        // Dao se debe instanciar una unica vez durante la aprtura de de la interfaz principal 
        initComponents();
        
        //Properties
        int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
        System.out.println(ancho);
        System.out.println(alto);
        this.setSize(ancho,alto);
        lblFondo.setSize(ancho,alto);
        //Users
        createUserView = new CreateUserView();
        searchUserView = new SearchUserView();
        updateUserView = new UpdateUserView();      
        deleteUserView = new DeleteUserView();
        listUsersView = new ListUsersView();
        
        desktopPane.add(createUserView);
        desktopPane.add(searchUserView);
        desktopPane.add(updateUserView);
        desktopPane.add(deleteUserView);
        desktopPane.add(listUsersView);
        //Book
        createBookView = new CreateBookView();
        searchBookView = new SearchBookView();
        deleteBookView = new DeleteBookView();
        listBookView = new ListBookView();
        
        desktopPane.add(createBookView);
        desktopPane.add(searchBookView);
        desktopPane.add(deleteBookView);
        desktopPane.add(listBookView);
        //Author
        createAuthorView = new CreateAuthorView();
        searchAuthorView = new SearchAuthorView();
        updateAuthorView = new UpdateAuthorView();
        deleteAuthorView = new DeleteAuthorView();
        
        desktopPane.add(createAuthorView);
        desktopPane.add(searchAuthorView);
        desktopPane.add(updateAuthorView);
        desktopPane.add(deleteAuthorView);
        
        //Prestamos
        logInView = new LogInView();
        borrowsView = new BorrowsView();
        listBorrowsView = new ListBorrowsView();
        returnsView = new ReturnsView();
        
        desktopPane.add(logInView);
        desktopPane.add(borrowsView);
        desktopPane.add(listBorrowsView);
        desktopPane.add(returnsView);
        //Dao
        daoBook = new DaoBookMemory();
        daoAuthor = new DaoAuthorMemory();
        daoUser = new DaoUserMemory();
        daoBorrow = new DaoBorrowMemory(daoUser);
        // Controllers
        controllerBliblio = new BibliotecaController(daoAuthor,daoBook,createBookView,deleteBookView,searchBookView,listBookView);
        authorController = new AuthorController(createAuthorView,deleteAuthorView,searchAuthorView,updateAuthorView,daoAuthor);
        userController = new UserController(createUserView,deleteUserView,searchUserView,updateUserView,listUsersView,daoUser);
        borrowController = new BorrowsController(logInView,borrowsView,returnsView,listBorrowsView,this.logOutMenu,daoBook,daoUser,daoBorrow,desktopPane);
        
        cantResizable();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        lblFondo = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        userMenu = new javax.swing.JMenu();
        createMenuUser = new javax.swing.JMenuItem();
        searchMenuUser = new javax.swing.JMenuItem();
        deleteMenuUser = new javax.swing.JMenuItem();
        updateMenuUser = new javax.swing.JMenuItem();
        listMenuUser = new javax.swing.JMenuItem();
        authorMenu = new javax.swing.JMenu();
        createMenuAuthor = new javax.swing.JMenuItem();
        searchMenuAuthor = new javax.swing.JMenuItem();
        deleteMenuAuthor = new javax.swing.JMenuItem();
        updateMenuAuthor = new javax.swing.JMenuItem();
        menuBook = new javax.swing.JMenu();
        createMenuBook = new javax.swing.JMenuItem();
        searchMenuBook = new javax.swing.JMenuItem();
        deleteMenuBook = new javax.swing.JMenuItem();
        listMenuBook = new javax.swing.JMenuItem();
        borrowMenu = new javax.swing.JMenu();
        menuLogIn = new javax.swing.JMenuItem();
        menuBorrow = new javax.swing.JMenuItem();
        returnMenu = new javax.swing.JMenuItem();
        listBorrows = new javax.swing.JMenuItem();
        logOutMenu = new javax.swing.JMenuItem();
        menuLanguage = new javax.swing.JMenu();
        languageMenuEnglish = new javax.swing.JMenuItem();
        languageMenuSpanish = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(java.awt.SystemColor.activeCaption);
        desktopPane.setForeground(new java.awt.Color(255, 255, 255));

        lblFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/WhatsApp Image 2026-07-02 at 15.38.34.jpg"))); // NOI18N
        desktopPane.add(lblFondo);
        lblFondo.setBounds(0, 0, 400, 280);

        userMenu.setBackground(new java.awt.Color(153, 51, 0));
        userMenu.setMnemonic('f');
        userMenu.setText("Usuarios");

        createMenuUser.setBackground(new java.awt.Color(153, 51, 0));
        createMenuUser.setMnemonic('o');
        createMenuUser.setText("Crear");
        createMenuUser.addActionListener(this::createMenuUserActionPerformed);
        userMenu.add(createMenuUser);
        createMenuUser.getAccessibleContext().setAccessibleName("crearProducto");

        searchMenuUser.setMnemonic('s');
        searchMenuUser.setText("Buscar");
        searchMenuUser.addActionListener(this::searchMenuUserActionPerformed);
        userMenu.add(searchMenuUser);
        searchMenuUser.getAccessibleContext().setAccessibleName("buscarProducto");

        deleteMenuUser.setMnemonic('a');
        deleteMenuUser.setText("Eliminar");
        deleteMenuUser.addActionListener(this::deleteMenuUserActionPerformed);
        userMenu.add(deleteMenuUser);
        deleteMenuUser.getAccessibleContext().setAccessibleName("eliminarProductoMenuItem");

        updateMenuUser.setMnemonic('x');
        updateMenuUser.setText("Actualizar");
        updateMenuUser.addActionListener(this::updateMenuUserActionPerformed);
        userMenu.add(updateMenuUser);
        updateMenuUser.getAccessibleContext().setAccessibleName("actualizarProductoMenuItem");

        listMenuUser.setText("Listar");
        listMenuUser.addActionListener(this::listMenuUserActionPerformed);
        userMenu.add(listMenuUser);

        menuBar.add(userMenu);

        authorMenu.setMnemonic('e');
        authorMenu.setText("Autores");

        createMenuAuthor.setMnemonic('t');
        createMenuAuthor.setText("Agregar");
        createMenuAuthor.addActionListener(this::createMenuAuthorActionPerformed);
        authorMenu.add(createMenuAuthor);
        createMenuAuthor.getAccessibleContext().setAccessibleName("agregarProductoMenuItem");

        searchMenuAuthor.setText("Buscar");
        searchMenuAuthor.addActionListener(this::searchMenuAuthorActionPerformed);
        authorMenu.add(searchMenuAuthor);

        deleteMenuAuthor.setMnemonic('y');
        deleteMenuAuthor.setText("Eliminar");
        deleteMenuAuthor.addActionListener(this::deleteMenuAuthorActionPerformed);
        authorMenu.add(deleteMenuAuthor);
        deleteMenuAuthor.getAccessibleContext().setAccessibleName("eliminarProdutoMenuItem");

        updateMenuAuthor.setText("Actualizar");
        updateMenuAuthor.addActionListener(this::updateMenuAuthorActionPerformed);
        authorMenu.add(updateMenuAuthor);

        menuBar.add(authorMenu);
        authorMenu.getAccessibleContext().setAccessibleName("carritoMenu");

        menuBook.setText("Libros");

        createMenuBook.setText("Agregar");
        createMenuBook.addActionListener(this::createMenuBookActionPerformed);
        menuBook.add(createMenuBook);

        searchMenuBook.setText("Buscar");
        searchMenuBook.addActionListener(this::searchMenuBookActionPerformed);
        menuBook.add(searchMenuBook);

        deleteMenuBook.setText("Eliminar");
        deleteMenuBook.addActionListener(this::deleteMenuBookActionPerformed);
        menuBook.add(deleteMenuBook);

        listMenuBook.setText("Listar");
        listMenuBook.addActionListener(this::listMenuBookActionPerformed);
        menuBook.add(listMenuBook);

        menuBar.add(menuBook);

        borrowMenu.setText("Prestamos");

        menuLogIn.setText("Log In");
        menuLogIn.addActionListener(this::menuLogInActionPerformed);
        borrowMenu.add(menuLogIn);

        menuBorrow.setText("Pedir");
        menuBorrow.addActionListener(this::menuBorrowActionPerformed);
        borrowMenu.add(menuBorrow);

        returnMenu.setText("Devolver");
        returnMenu.addActionListener(this::returnMenuActionPerformed);
        borrowMenu.add(returnMenu);

        listBorrows.setText("Prestamos");
        listBorrows.addActionListener(this::listBorrowsActionPerformed);
        borrowMenu.add(listBorrows);

        logOutMenu.setText("Log Out");
        logOutMenu.addActionListener(this::logOutMenuActionPerformed);
        borrowMenu.add(logOutMenu);

        menuBar.add(borrowMenu);

        menuLanguage.setText("Idioma");

        languageMenuEnglish.setText("Ingles");
        languageMenuEnglish.addActionListener(this::languageMenuEnglishActionPerformed);
        menuLanguage.add(languageMenuEnglish);

        languageMenuSpanish.setText("Español");
        languageMenuSpanish.addActionListener(this::languageMenuSpanishActionPerformed);
        menuLanguage.add(languageMenuSpanish);

        menuBar.add(menuLanguage);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMenuUserActionPerformed
        if(updateUserView != null || !updateUserView.isVisible()){
            updateUserView.setVisible(true);
            updateUserView.moveToFront();
            centerInternalFrame(updateUserView, desktopPane);
        }
    }//GEN-LAST:event_updateMenuUserActionPerformed

    private void createMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMenuUserActionPerformed
        // TODO add your handling code here:
        if(createUserView != null || !createUserView.isVisible()){
            createUserView.setVisible(true);
            createUserView.moveToFront();
            centerInternalFrame(createUserView, desktopPane);
        }

    }//GEN-LAST:event_createMenuUserActionPerformed

    private void searchMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuUserActionPerformed
        // TODO add your handling code here:
        if(searchUserView!=null || !searchUserView.isVisible()){
            searchUserView.setVisible(true);
            searchUserView.moveToFront();  
            centerInternalFrame(searchUserView, desktopPane);
        }
    }//GEN-LAST:event_searchMenuUserActionPerformed

    private void deleteMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuUserActionPerformed
        // TODO add your handling code here:
        if(deleteUserView != null || !deleteUserView.isVisible()){
            deleteUserView.setVisible(true);
            deleteUserView.moveToFront();
            centerInternalFrame(deleteUserView, desktopPane);
        }
    }//GEN-LAST:event_deleteMenuUserActionPerformed

    private void listMenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMenuUserActionPerformed
        // TODO add your handling code here:
        if(listUsersView != null || !listUsersView.isVisible()){
            listUsersView.setVisible(true);
            listUsersView.moveToFront();
            centerInternalFrame(listUsersView, desktopPane);
            
        }
    
    }//GEN-LAST:event_listMenuUserActionPerformed

    private void createMenuBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMenuBookActionPerformed
        // TODO add your handling code here:
        if(createBookView != null || !createBookView.isVisible()){
            createBookView.setVisible(true);
            createBookView.moveToFront();
            centerInternalFrame(createBookView, desktopPane);
        }
    }//GEN-LAST:event_createMenuBookActionPerformed

    private void searchMenuBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuBookActionPerformed
        // TODO add your handling code here:
        if(searchBookView != null || searchBookView.isVisible()){
            searchBookView.setVisible(true);
            searchBookView.moveToFront();
            centerInternalFrame(searchBookView, desktopPane);
        }
    }//GEN-LAST:event_searchMenuBookActionPerformed

    private void languageMenuEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageMenuEnglishActionPerformed
        // TODO add your handling code here:
        Locale local = new Locale("en", "US");
        changeLanguage(local);
    }//GEN-LAST:event_languageMenuEnglishActionPerformed

    private void deleteMenuBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuBookActionPerformed
        // TODO add your handling code here:
        if(deleteBookView != null || deleteBookView.isVisible()){
           deleteBookView.setVisible(true);
           deleteBookView.moveToFront();
           centerInternalFrame(deleteBookView, desktopPane);
        }
    }//GEN-LAST:event_deleteMenuBookActionPerformed

    private void listMenuBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMenuBookActionPerformed
        // TODO add your handling code here:
        if(listBookView != null || !listBookView.isVisible()){
            listBookView.setVisible(true);
            listBookView.moveToFront();
            centerInternalFrame(listBookView, desktopPane);
        }
    }//GEN-LAST:event_listMenuBookActionPerformed

    private void createMenuAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMenuAuthorActionPerformed
        // TODO add your handling code here:
        if(createAuthorView != null || !createAuthorView.isVisible()){
            createAuthorView.setVisible(true);  
            createAuthorView.moveToFront();
            centerInternalFrame(createAuthorView, desktopPane);
        }
    }//GEN-LAST:event_createMenuAuthorActionPerformed

    private void searchMenuAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuAuthorActionPerformed
        // TODO add your handling code here:
        if(searchAuthorView != null || !searchAuthorView.isVisible()){
            searchAuthorView.setVisible(true);
            searchAuthorView.moveToFront();
            centerInternalFrame(searchAuthorView, desktopPane);
        }
    }//GEN-LAST:event_searchMenuAuthorActionPerformed

    private void deleteMenuAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuAuthorActionPerformed
        // TODO add your handling code here:
        if(deleteAuthorView != null || !deleteAuthorView.isVisible()){
            deleteAuthorView.setVisible(true);
            deleteAuthorView.moveToFront();
            centerInternalFrame(deleteAuthorView, desktopPane);
        }
    }//GEN-LAST:event_deleteMenuAuthorActionPerformed

    private void updateMenuAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMenuAuthorActionPerformed
        // TODO add your handling code here:
        if(updateAuthorView != null || !updateAuthorView.isVisible()){
            updateAuthorView.setVisible(true);
            updateAuthorView.moveToFront();
            centerInternalFrame(updateAuthorView, desktopPane);
        }
    }//GEN-LAST:event_updateMenuAuthorActionPerformed

    private void menuLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogInActionPerformed
        // TODO add your handling code here:
        if(logInView != null || !logInView.isVisible()){
            logInView.setVisible(true);
            logInView.moveToFront();
            centerInternalFrame(logInView, desktopPane);
        }
    }//GEN-LAST:event_menuLogInActionPerformed

    private void menuBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBorrowActionPerformed
        // TODO add your handling code here:
        if(borrowsView == null || !borrowsView.isVisible()){
            borrowsView.setVisible(true);
            borrowsView.moveToFront();
            centerInternalFrame(borrowsView, desktopPane);
        }
        
    }//GEN-LAST:event_menuBorrowActionPerformed

    private void returnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnMenuActionPerformed
        // TODO add your handling code here:
        if(returnsView == null || !returnsView.isVisible()){
            returnsView.setVisible(true);
            returnsView.moveToFront();
            centerInternalFrame(returnsView, desktopPane);
        }
    }//GEN-LAST:event_returnMenuActionPerformed

    private void listBorrowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBorrowsActionPerformed
        // TODO add your handling code here:
        if(listBorrowsView == null || !listBorrowsView.isVisible()){
            listBorrowsView.setVisible(true);
            listBorrowsView.moveToFront();
            centerInternalFrame(listBorrowsView, desktopPane);
        }
    }//GEN-LAST:event_listBorrowsActionPerformed

    private void logOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutMenuActionPerformed

    private void languageMenuSpanishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageMenuSpanishActionPerformed
        // TODO add your handling code here:
        Locale local = new Locale("es", "EC");
        changeLanguage(local);
    }//GEN-LAST:event_languageMenuSpanishActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu authorMenu;
    private javax.swing.JMenu borrowMenu;
    private javax.swing.JMenuItem createMenuAuthor;
    private javax.swing.JMenuItem createMenuBook;
    private javax.swing.JMenuItem createMenuUser;
    private javax.swing.JMenuItem deleteMenuAuthor;
    private javax.swing.JMenuItem deleteMenuBook;
    private javax.swing.JMenuItem deleteMenuUser;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem languageMenuEnglish;
    private javax.swing.JMenuItem languageMenuSpanish;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JMenuItem listBorrows;
    private javax.swing.JMenuItem listMenuBook;
    private javax.swing.JMenuItem listMenuUser;
    private javax.swing.JMenuItem logOutMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBook;
    private javax.swing.JMenuItem menuBorrow;
    private javax.swing.JMenu menuLanguage;
    private javax.swing.JMenuItem menuLogIn;
    private javax.swing.JMenuItem returnMenu;
    private javax.swing.JMenuItem searchMenuAuthor;
    private javax.swing.JMenuItem searchMenuBook;
    private javax.swing.JMenuItem searchMenuUser;
    private javax.swing.JMenuItem updateMenuAuthor;
    private javax.swing.JMenuItem updateMenuUser;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables
   
    public void changeLanguage(Locale locale){
         ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.biblioteca.i18n.mensajes",locale);
         // menuBar
         userMenu.setText(bundle.getString("User"));
         authorMenu.setText(bundle.getString("Authors"));
         menuBook.setText(bundle.getString("Books"));
         borrowMenu.setText(bundle.getString("Request"));
         menuLanguage.setText(bundle.getString("Language"));
         
         // userItems
         createMenuUser.setText(bundle.getString("createUser"));
         searchMenuUser.setText(bundle.getString("searchUser"));
         deleteMenuUser.setText(bundle.getString("deleteUser"));
         updateMenuUser.setText(bundle.getString("updateUser"));
         listMenuUser.setText(bundle.getString("listUser"));
         
         // authorsItems
         createMenuAuthor.setText(bundle.getString("addAuthor"));
         searchMenuAuthor.setText(bundle.getString("searchAuthor"));
         deleteMenuAuthor.setText(bundle.getString("deleteAuthor"));
         updateMenuAuthor.setText(bundle.getString("updateAuthor"));
         
         // bookItems
         createMenuBook.setText(bundle.getString("menuAddBook"));
         searchMenuBook.setText(bundle.getString("menuSearchBook"));
         deleteMenuBook.setText(bundle.getString("menuDeleteBook"));
         listMenuBook.setText(bundle.getString("menuListBook"));
         
         // borrowItem
         menuLogIn.setText(bundle.getString("logInMenu"));
         menuBorrow.setText(bundle.getString("borrowMenu"));
         returnMenu.setText(bundle.getString("returnMenu"));
         listBorrows.setText(bundle.getString("listMenu"));
         logOutMenu.setText(bundle.getString("logOutMenu"));
         
        // methods user
        createUserView.changeLanguage(locale);
        searchUserView.changeLanguage(locale);
        deleteUserView.changeLanguage(locale);
        updateUserView.changeLanguage(locale);
        listUsersView.changeLanguage(locale);
        
        // methods book
        createBookView.changeLanguage(locale);
        searchBookView.changeLanguage(locale);
        deleteBookView.changeLanguage(locale);
        listBookView.changeLanguage(locale);
        
        // methods author
        createAuthorView.changeLanguage(locale);
        searchAuthorView.changeLanguage(locale);
        updateAuthorView.changeLanguage(locale);
        deleteAuthorView.changeLanguage(locale);
        
        // Methods borrow
        logInView.changeLanguage(locale);
        borrowsView.changeLanguage(locale);
        listBorrowsView.changeLanguage(locale);
        returnsView.changeLanguage(locale);
        
        //controllers language
        userController.changeLanguage(locale);
    }
    
    public static void centerInternalFrame(JInternalFrame frame, JDesktopPane desktop) {
        frame.pack(); // si es necesario
        int x = (desktop.getWidth() - frame.getWidth()) / 2;
        int y = (desktop.getHeight() - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
    public void cantResizable(){
        JInternalFrame[] frames = {
        createUserView,
        searchUserView,
        updateUserView,
        deleteUserView,
        listUsersView,
        createBookView,
        searchBookView,
        deleteBookView,
        listBookView,
        createAuthorView,
        searchAuthorView,
        updateAuthorView,
        deleteAuthorView,
        logInView,
        borrowsView,
        listBorrowsView,
        returnsView
    };

    for (JInternalFrame frame : frames) {
        frame.setResizable(false);
        }
    }
}
