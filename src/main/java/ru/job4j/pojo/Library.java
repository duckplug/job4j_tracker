package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("One", 33);
        Book two = new Book("Two", 123);
        Book three = new Book("Three", 333);
        Book cleaneCode = new Book("Clean Code", 0);

        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = cleaneCode;

        for (Book booksAr : books) {
            System.out.println(booksAr.getName() + " - " + booksAr.getPages());
        }
        System.out.println();
        System.out.println("Switch");
        System.out.println();
        Book sw = new Book("0", 0);
        sw = books[3];
        books[3] = books[0];
        books[0] = sw;
        for (Book booksAr : books) {
            System.out.println(booksAr.getName() + " - " + booksAr.getPages());
        }
        System.out.println();
        System.out.println("Search book");
        System.out.println();
        for (Book booksAr : books) {

            if ("Clean Code".equals(booksAr.getName())) {
                System.out.println(booksAr.getName() + " - " + booksAr.getPages());
            }
        }
    }
}

