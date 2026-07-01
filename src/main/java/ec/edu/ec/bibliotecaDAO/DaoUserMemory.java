/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

import ec.edu.ups.biblioteca.models.User;
import java.util.ArrayList;
import java.util.List;

public class DaoUserMemory implements DaoUser{
    
    private List<User> users;
    private int indexSearch;

    public DaoUserMemory() {
        users = new ArrayList<>();
        this.indexSearch = -1;
    }
    public int getIndexSearch() {
        return indexSearch;
    }

    public void setIndexSearch(int indexSearch) {
        this.indexSearch = indexSearch;
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
    public boolean getIndexUpdate(int idSearch){
        if(users.isEmpty())return false;
        for(int i = 0;i<users.size();i++){
            if(idSearch == users.get(i).getiD()){
                this.indexSearch = i;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(int idSearch) {
        if(users.isEmpty())return false;
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
        return this.users;
    }

    @Override
    public void update(String newMail, String newPassword, String name) {
        int index = indexSearch;
        users.get(index).setMail(newMail);
        users.get(index).setPassword(newPassword);
        users.get(index).setName(name);
        this.indexSearch = -1;
   
    }
    
}
