/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.models;

import java.util.Date;

public class BookBorrow {
    private User userBook;
    private Book bookBorrowed;
    private int transactionNumber;
    private Date returnDate;

    public BookBorrow() {
    }

    public BookBorrow(User userBook, Book bookBorrowed, int transactionNumber,Date returnDate) {
        this.userBook = userBook;
        this.bookBorrowed = bookBorrowed;
        this.transactionNumber = transactionNumber;
        this.returnDate = returnDate;
    }

    public User getUserBook() {
        return userBook;
    }

    public void setUserBook(User userBook) {
        this.userBook = userBook;
    }

    public Book getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(Book bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.transactionNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookBorrow other = (BookBorrow) obj;
        return this.transactionNumber == other.transactionNumber;
    }

    
    
}
