package com.example.mahia.libraryapp;

import android.graphics.drawable.Drawable;

/* This class is for the book list adapter.
  So I can get and set the title, author and isbn

  Private variable bookname is corresponding to title
  Private variable author is corresponding to author
  Private variable number is corresponding to the ISBN of the book
  Private variable picture corresponds to the picture of said book
 */
public class Book {
    private String bookname;
    private  String author;
    private String number;
    private String picture;

    // This method creates a new book list object to fill the booklist adapter
    public Book(String bookname, String author, String number,String picture){
        this.bookname = bookname;
        this.author = author;
        this.number = number;
        this.picture = picture;

    }

    public String getBookname(){
        return bookname;
    }
    public void setBookname(String bookname){
       this.bookname = bookname;

    }
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
