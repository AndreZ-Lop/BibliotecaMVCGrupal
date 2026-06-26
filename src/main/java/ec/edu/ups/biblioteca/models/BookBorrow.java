/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.models;

public class BookBorrow {
    private User userBook;
    private Book bookBorrowed;
    private int transactionNumber;

    public BookBorrow() {
    }

    public BookBorrow(User userBook, Book bookBorrowed, int transactionNumber) {
        this.userBook = userBook;
        this.bookBorrowed = bookBorrowed;
        this.transactionNumber = transactionNumber;
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
