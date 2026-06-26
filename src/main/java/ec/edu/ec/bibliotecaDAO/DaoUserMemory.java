/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.User;
import java.util.List;

public class DaoUserMemory implements DaoUser{
    
    private List<User> users;

    public DaoUserMemory() {
    }

    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public User search(int idSearch) {
        if(users.isEmpty())return null;
        for(User search: users){
            if(idSearch == search.getiD())
                return search;
        }
        return null;
        
    }

    @Override
    public boolean update(int idSearch, String newMail, String newPassword, String name) {
        if(users.isEmpty())return false;
        for(User search: users){
            if(idSearch == search.getiD()){
                search.setName(name);
                search.setPassword(newPassword);
                search.setMail(newMail);
                return true;
            }
                
        }
        return false;
    }

    @Override
    public boolean delete(int idSearch) {
        for(int i = 0;i < users.size();i++){
            if(idSearch == users.get(i).getiD()){
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> listUsers() {
        return users;
    }
    
}
