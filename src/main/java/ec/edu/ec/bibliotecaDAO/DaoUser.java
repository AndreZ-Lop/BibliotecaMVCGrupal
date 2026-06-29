/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.User;
import java.util.List;

/**
 *
 * @author y2
 */
public interface DaoUser {
    void create(User user);
    User search(int idSearch);
    boolean getIndexUpdate(int idSearch);
    void update(String newMail,String newPassword,String name);
    boolean delete(int idSearch);
    List<User> listUsers();
    
}
