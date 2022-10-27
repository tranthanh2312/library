package book;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookManagementMenu {
    BookManagement bookManagement = new BookManagement();
    public void displayMenu() {
        System.out.println("============");
        System.out.println("Book Management");
        System.out.println("1: Add book");
        System.out.println("2: Remove book");
        System.out.println("3: Search by ISBN");
        System.out.println("4: Search by Title");
        System.out.println("5: Read from file");
        System.out.println("6: Save to file");
        System.out.println("7: Display all");
        System.out.println("============");
    }

    public void handleMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            displayMenu();
            System.out.println("Enter choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    searchByISBN();
                    break;
                case 4:
                    searchByTitle();
                    break;
                case 5:
                    readFromFile();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    displayAll();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        System.out.println("Enter title");
        String title = scanner.nextLine();
        System.out.println("Enter author");
        String author = scanner.nextLine();
        System.out.println("Enter year");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(isbn,title,author,year);
        bookManagement.add(newBook);
    }

    public void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        if (bookManagement.remove(isbn)){
            System.out.println("Remove successful");
        } else {
            System.out.println("Remove fail!! Check ISBN");
        };
    }

    public void searchByISBN(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ISBN");
        String isbn = scanner.nextLine();
        Book searchBook = bookManagement.searchByID(isbn);
        if (searchBook != null){
            System.out.println(searchBook);
        } else {
            System.out.println("Not found");
        }
    }

    public void searchByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title");
        String title = scanner.nextLine();
        List<Book> bookList = bookManagement.searchByTitle(title);
        for (Book b : bookList){
            System.out.println(b);
        }
    }

    public void readFromFile() {
        try{
            bookManagement.readFromFile();
        } catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        try{
            bookManagement.saveToFile();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void displayAll(){
        System.out.println(bookManagement.display());
    }
}
