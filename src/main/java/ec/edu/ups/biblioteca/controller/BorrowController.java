/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.controller;

import ec.edu.ec.bibliotecaDAO.DaoBorrow;
import ec.edu.ec.ups.biblioteca.view.BorrowsView;
import ec.edu.ec.ups.biblioteca.view.ListBorrowsView;
import ec.edu.ec.ups.biblioteca.view.LogInView;
import ec.edu.ec.ups.biblioteca.view.OrderBookView;
import ec.edu.ec.ups.biblioteca.view.ReturnsView;

/**
 *
 * @author USER
 */
public class BorrowController {
    private BorrowsView borrowView;
    private LogInView logInView;
    private ReturnsView returnsView;
    private ListBorrowsView listBorrowsView;
    private OrderBookView orderBookView;
    private DaoBorrow daoBorrow;

    public BorrowController(BorrowsView borrowView, LogInView logInView, ReturnsView returnsView, ListBorrowsView listBorrowsView, OrderBookView orderBookView, DaoBorrow daoBorrow) {
        this.borrowView = borrowView;
        this.logInView = logInView;
        this.returnsView = returnsView;
        this.listBorrowsView = listBorrowsView;
        this.orderBookView = orderBookView;
        this.daoBorrow = daoBorrow;
    }

    
    
    
}
