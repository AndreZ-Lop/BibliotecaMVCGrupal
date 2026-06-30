/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controller;

import ec.edu.ec.ups.biblioteca.view.CreateUserView;
import ec.edu.ec.ups.biblioteca.view.DeleteUserView;
import ec.edu.ec.ups.biblioteca.view.SearchUserView;
import ec.edu.ec.ups.biblioteca.view.ListUsersView;
import ec.edu.ec.ups.biblioteca.view.UpdateUserView;
import ec.edu.ec.bibliotecaDAO.DaoUser;
import ec.edu.ups.biblioteca.models.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class UserController {
    private CreateUserView createUserView;
    private DeleteUserView deleteUserView;
    private SearchUserView searchUserView;
    private UpdateUserView updateUserView;
    private ListUsersView listUsersView;
    private DaoUser daoUser;

    public UserController() {
        configurateEvents();
    }

    public UserController(CreateUserView createUserView, DeleteUserView deleteUserView, SearchUserView searchUserView, UpdateUserView updateUserView, ListUsersView listUsersView, DaoUser daoUser) {
        this.createUserView = createUserView;
        this.deleteUserView = deleteUserView;
        this.searchUserView = searchUserView;
        this.updateUserView = updateUserView;
        this.listUsersView = listUsersView;
        this.daoUser = daoUser;
        configurateEvents();
        
    }

    public void configurateEvents() {
        //Create
        configurateButtonCreate();
        configurateButtonCancel();
        //list
        configurateButtonlist();
        eventWindowClosing();
        configurateButtonCancelList();
        //delete  
        configurateButtonDelete();
        configurateButtonCancelDelete();
        //update
        configurateButtoSearchUp();
        configurateButtonUpdate();
        configurateButtonCancelUpdate();
        eventWindowClosingUpdate();
        //buscar
        configurateButtonSearch();
        configurateButtonCancelSearch();
        
        
    }
    // Funcionamientos
    /*
    Metodos para poder obtener los datos para crear usuarios
    */
    public void configurateEventCreate() {
        String name = createUserView.getTxtNameUser().getText();
        int iD = Integer.parseInt(createUserView.getTxtIdUser().getText());
        int day = Integer.parseInt(createUserView.getTxtDayUser().getText());
        int month = Integer.parseInt(createUserView.getTxtMonthUser().getText());
        int year = Integer.parseInt(createUserView.getYearUser().getText());
        //Validacion Edad
        Date date = new Date(year - 1900,month - 1, day);
        int age =  LocalDate.now().getYear() - (date.getYear() + 1900);
        String mail = createUserView.getMailUser().getText();
        String password = createUserView.getPasswordUser().getText();
        if(age<18){
            int option = JOptionPane.showConfirmDialog(createUserView,"Su cuenta tendra restriccione de edad desea continuar?");
            if(option == JOptionPane.YES_OPTION){
                daoUser.create(new User(mail,password,true,name,iD,date));
            }else{
                createUserView.dispose();
            }
        }else{
            daoUser.create(new User(mail,password,false,name,iD,date));
        }
    }
    /*
    Metodos para listar usuarios
    */
    public void configurateEventList(){
        listUsersView.listElements(daoUser.listUsers());
    }
    /*
    Metodos para eliminar usuarios
    */
    public void configurateEventDelete(){
        int delete = Integer.parseInt(deleteUserView.getTxtDeleteUser().getText());
        if(!daoUser.delete(delete)){
            JOptionPane.showMessageDialog(deleteUserView, "No se pudo eliminar el usuario");
        }else{
            JOptionPane.showMessageDialog(deleteUserView, "Se ha eliminado el usuario correctamente");
        }
        
    }
    /*
    Metodos para poder obtener los datos para actualizar usuarios
    */
    
    // Habilitar Cambios
    public void configurateShowOptions(){
        if(!daoUser.getIndexUpdate(Integer.parseInt(updateUserView.getTxtIdSearch().getText()))){
            JOptionPane.showMessageDialog(updateUserView,"Usuario no encontrado");
            updateUserView.getBtnUpdate().setEnabled(false);
            updateUserView.getTxtNewMail().setEnabled(false);
            updateUserView.getTxtNewName().setEnabled(false);
            updateUserView.getTxtNewPassword().setEnabled(false);
        }else{
            updateUserView.getBtnUpdate().setEnabled(true);
            updateUserView.getTxtNewMail().setEnabled(true);
            updateUserView.getTxtNewName().setEnabled(true);
            updateUserView.getTxtNewPassword().setEnabled(true);
        }
    }
    
    //actualizar
    public void configurateUpdate(){
        String newName = updateUserView.getTxtNewName().getText();
        String newMail = updateUserView.getTxtNewMail().getText();
        String newPassword = updateUserView.getTxtNewPassword().getText();
        daoUser.update(newMail, newPassword, newName);
    }
    
     /*
    Metodos para poder obtener los datos para actualizar usuarios
    */
    
    public void configurateSearch(){
        User userFounded = daoUser.search(Integer.parseInt(searchUserView.getTxtUserSearch().getText()));
        if(userFounded == null){
            JOptionPane.showMessageDialog(searchUserView, "Usuario no encontrado");
        }else{
            JOptionPane.showMessageDialog(searchUserView, """
                                                          Usuario Encontrado
                                                          Nombre: """ + userFounded.getName() + "\nCorreo: " + userFounded.getMail() 
                                                          + "\nCedula: " + userFounded.getiD());
        }
    }
    
    // Clases anonimas 
    /*
    Clases para funcionamiento de la ventana crear usuario
    */
    //Create
    public void configurateButtonCreate(){
        createUserView.getBtnCreateUser().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateEventCreate();
            }
        });
    }
    //Cancel
    public void configurateButtonCancel(){
        createUserView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createUserView.dispose();
            }
        });
    }
    /*
    Clases para implementar el funcionamiento de la ventana list
    */
    //List
    public void configurateButtonlist(){
        listUsersView.getBtnList().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateEventList();
                listUsersView.getBtnList().setEnabled(false);
            }
        });
    }
    // Closing
    public void eventWindowClosing(){
        listUsersView.addInternalFrameListener(new InternalFrameAdapter(){
            @Override
            public void internalFrameClosing(InternalFrameEvent e){
               listUsersView.getBtnList().setEnabled(true);
               listUsersView.getModel().setRowCount(0);
            }
        });
    }
    //Cancel
    public void configurateButtonCancelList(){
        listUsersView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                listUsersView.dispose();
            }
        });
    }
    /*
    Clases para implementar el funcionamiento de la ventana eliminar
    */
    // Button Delete
    public void configurateButtonDelete(){
        deleteUserView.getBtnDelete().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateEventDelete();
            }
        });
    }
    // Button Cancel
    public void configurateButtonCancelDelete(){
        deleteUserView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                deleteUserView.dispose();
            }
        });
    }
    /*
    Clases para implementar el funcionamiento de la ventana actualizar
    */
    // Button search
    public void configurateButtoSearchUp(){
        updateUserView.getBtnSearch().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateShowOptions();
            }
        });
    }
    // Button update
    public void configurateButtonUpdate(){
        updateUserView.getBtnUpdate().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                configurateUpdate();
            }
        });
    }
    // Button cancel
     public void configurateButtonCancelUpdate(){
        updateUserView.getBtnCancel().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateUserView.dispose();
            }
        });
    }
     // Window close
     public void eventWindowClosingUpdate(){
        updateUserView.addInternalFrameListener(new InternalFrameAdapter(){
            @Override
            public void internalFrameClosing(InternalFrameEvent e){
                updateUserView.getBtnUpdate().setEnabled(false);
                updateUserView.getTxtNewMail().setEnabled(false);
                updateUserView.getTxtNewName().setEnabled(false);
                updateUserView.getTxtNewPassword().setEnabled(false);
            }
        });
    }
    /*
    Clases para implementar el funcionamiento de la ventana buscar
    */
     //Boton buscar
     public void configurateButtonSearch(){
         searchUserView.getBtnSearch().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 configurateSearch();
             }
         });
     }
     //Boton cancelar
     public void configurateButtonCancelSearch(){
         searchUserView.getBtnCancel().addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 searchUserView.dispose();
             }
         });
     }
}


