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

    private void configurateEvents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Funcionamientos
    
    
}


