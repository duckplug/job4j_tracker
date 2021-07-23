package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("One", 33);
        Book two = new Book("Two", 123);
        Book three = new Book ("Three", 333);
        Book cleaneCode = new Book ("Clean Code", 0);

        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = cleaneCode;

        for (int i = 0; i < books.length; i++) {
           Books booksAr = Books[i];
            
        }


    }
}
