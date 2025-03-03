package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kirja lisätty kirjastoon!");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        int amountOfBooks = 0;
        for (Book book : getBooks()) {
            book.displayInfo();
            System.out.println("Kirjan kategoria: " + book.categorize());
            amountOfBooks += book.copies;
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + amountOfBooks);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getBookName().equals(title)) {
                return book;
            }
        }
        return null;
    }
}

