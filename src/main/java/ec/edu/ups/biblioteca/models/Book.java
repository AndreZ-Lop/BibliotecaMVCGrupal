/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.biblioteca.models;

import java.util.Date;

public class Book {
    private String tittle;
    private int ISBN;
    private String genre;
    private Date publicationDate;
    private Author bookAuthor;
    private String bookLanguage;
    private boolean isAvailable;
    private boolean bookRestrictions;

    public Book() {
        
    }

    public Book(String tittle, int ISBN, String genero, Date fechaPublicacion, Author autorLibro, String idiomaLibro, boolean estado, boolean restriccionesLibro) {
        this.tittle = tittle;
        this.ISBN = ISBN;
        this.genre = genero;
        this.publicationDate = fechaPublicacion;
        this.bookAuthor = autorLibro;
        this.bookLanguage = idiomaLibro;
        this.isAvailable = estado;
        this.bookRestrictions = restriccionesLibro;
    }

    public String getTitulo() {
        return tittle;
    }

    public void setTitulo(String title) {
        this.tittle = tittle;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genre;
    }

    public void setGenero(String genero) {
        this.genre = genero;
    }

    public Date getFechaPublicacion() {
        return publicationDate;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.publicationDate = fechaPublicacion;
    }

    public Author getAutorLibro() {
        return bookAuthor;
    }

    public void setAutorLibro(Author autorLibro) {
        this.bookAuthor = autorLibro;
    }

    public String getIdiomaLibro() {
        return bookLanguage;
    }

    public void setIdiomaLibro(String idiomaLibro) {
        this.bookLanguage = idiomaLibro;
    }

    public boolean getEstado() {
        return isAvailable;
    }

    public void setEstado(boolean estado) {
        this.isAvailable = estado;
    }

    public boolean getRestriccionesLibro() {
        return bookRestrictions;
    }

    public void setRestriccionesLibro(boolean restriccionesLibro) {
        this.bookRestrictions = restriccionesLibro;
    }
   
}
