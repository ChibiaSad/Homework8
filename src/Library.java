import java.util.Arrays;

public class Library {
    private Book[] books;
    private Book book;

    public Library(int size){
        this.books = new Book[size];
    }

    public void printAllLibrary() {
        printSeparator();
        for (Book book : books) {
            if(book == null){
                printSeparator();
                return;
            }
            System.out.printf("%s: %s: %d\n", book.getAuthor().toString(), book.getName(), book.getYear());
        }
        printSeparator();
    }

    private void printSeparator(){
        System.out.println("-------------------------------------------------------------");
    }

    public void addBook(Book book){
        for (int i = 0; i < books.length; i++) {
            if(books[i] == null){
                books[i] = book;
                return;
            }
        }
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = book;
    }

    public void bookData(String name){
        this.book = searchBook(name);
        System.out.printf("%s by %s was published in %d\n", book.getName(), book.getAuthor().toString(), book.getYear());
    }

    public void setYear(String name, int year){
        this.book = searchBook(name);
        book.setYear(year);
    }

    private Book searchBook(String name){
        for (Book book : books) {
            if(book.getName().equals(name)){
                return book;
            }
        }
        throw new RuntimeException("В библиотеке нет книги с названием " + name);
    }
}
