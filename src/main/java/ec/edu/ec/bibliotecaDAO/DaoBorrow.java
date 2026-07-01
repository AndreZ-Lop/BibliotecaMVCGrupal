/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ec.bibliotecaDAO;

/**
 *
 * @author USER
 */
public interface DaoBorrow {
    void logIn(String correo,String contrasenia);
    boolean order(String nombre);
    boolean returns (String nombre);
    boolean borrow (String nombre);
    
    
}
