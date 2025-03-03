package main;

public class FictionBook extends Book implements Borrowable {
    private int borrowed;

    public FictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
        this.borrowed = 0;
    }

    public String categorize() {
        return "Fiktiokirja";
    }

    public void borrow() {
        if (copies > 0) {
            copies = copies -1;
            borrowed = borrowed +1;
            System.out.println("Kirja " + title + " on nyt lainattu.");
        }
        else {
            System.out.println("Kirjaa " + title + " ei enään ole lainattavissa!");
        }
    }

    public void returnBook() {
        if (borrowed > 0) {
            copies = copies +1;
            borrowed = borrowed -1;
            System.out.println("Kirja " + title + " on palautettu.");
        }
        else {
            System.out.println("Kirja " + title + " ei ole lainassa.");
        }
    }
}
