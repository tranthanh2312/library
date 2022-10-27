package book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {
    private List<Book> books;
    private final String filePath = "books.csv";

    public BookManagement() {
        books = new ArrayList<>();
        Book b1 = new Book("a01", "Cha Giau Cha Ngheo", "Robert Kyoshaki", 2015);
        Book b2 = new Book("a02", "Tri tue Do Thai", "Robert", 2016);
        Book b3 = new Book("a03", "36 Ke Kinh Doanh", "Thai Nguyen", 2020);

        books.add(b1);
        books.add(b2);
        books.add(b3);

    }

    public void add(Book b) {
        books.add(b);
    }

    public boolean remove(String isbn) {
        Book bookSearch = searchByID(isbn);
        if (bookSearch != null) {
            books.remove(bookSearch);
            return true;
        }
        return false;
    }

    public Book searchByID(String isbn) {
        for (Book b : books) {
            if (b.getISBN().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().contains(title)) {
                bookList.add(b);
            }
        }
        return bookList;
    }

    public void saveToFile() throws IOException {
        FileWriter fw = new FileWriter(filePath,true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Book b : books) {
            bw.write(b.toString());
            bw.newLine();
        }
        bw.close();
        fw.close();
    }

    public void readFromFile() throws IOException {
        books.clear();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Book b;
        while((line = br.readLine()) != null){
            b = handleLine(line);
            books.add(b);
        }
    }

    public Book handleLine(String line){
        String[] str = line.split(",");
        Book newBook = new Book(str[0],str[1],str[2],Integer.parseInt(str[3]));
        return newBook;
    }

    public String display(){
        String listBook = "";
        for (Book b : books){
            listBook += b.toString() + "\n";
        }
        return listBook;
    }
}
