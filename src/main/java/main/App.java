//Valikko-rakenne edellisistä tehtävistä.
//Muut pitkälti Rocket-esimerkki koodin mukaan.

package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){
            Scanner sc = new Scanner(System.in);
            Library library = new Library();


        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää kirja\r\n" + //
                                "2) Listaa kirjat\r\n" + //
                                "3) Lainaa fiktiokirja\r\n" + //
                                "4) Palauta fiktiokirja\r\n" + //
                                "0) Lopeta ohjelma");
    
    if(sc.hasNext()) {
            int i = 0;
            String stringInput = sc.nextLine();
            i = Integer.parseInt(stringInput);
                                
        switch (i) {
            case 1:
                System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                int type = sc.nextInt();
                sc.nextLine();

                System.out.println("Anna kirjan nimi:");
                String title = sc.nextLine();
                System.out.println("Anna kirjailijan nimi:");
                String author  =sc.nextLine();
                System.out.println("Anna sivumäärä:");
                int pages = sc.nextInt();
                System.out.println("Anna kirjojen määrä:");
                int copies = sc.nextInt();
                sc.nextLine();

                if (type != 1 && type != 2) {
                    System.out.println("Virheellinen kirjatyyppi.");
                }
                else if (type == 1) {
                    library.addBook(new FictionBook(title, author, pages, copies));
                }
                else {
                    library.addBook(new NonFictionBook(title, author, pages, copies));
                }
                break;
            case 2:
                library.listBooks();
                break;
            case 3:
                System.out.println("Anna lainattavan kirjan nimi:");
                String booksName = sc.nextLine();
                Book borrowBook = library.searchBook(booksName);

                if (borrowBook instanceof FictionBook) {
                    ((FictionBook) borrowBook).borrow();
                }
                else {
                    System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                }
                break;
            case 4:
                System.out.println("Anna palautettavan kirjan nimi:");
                String bookName = sc.nextLine();
                Book returnBook = library.searchBook(bookName);

                if (returnBook instanceof FictionBook) {
                    ((FictionBook) returnBook).returnBook();
                }
                else {
                    System.out.println("Kirjaa ei löytynyt tai sitä ei voi palauttaa.");
                }
                break;
            case 0:
                System.out.println("Kiitos ohjelman käytöstä.");
                exit = true;
                break;
            default:
                System.out.println("Virheellinen valinta, yritä uudelleen.");
                break;
            }
        }

    }
    sc.close();
    }
}
