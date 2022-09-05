import java.util.Arrays;

public class Library {
    private Book[] books;
    private Book chosenBook;

    public Library(int size){
        this.books = new Book[size];
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
        chosenBook = searchBook(name);
        System.out.printf("%s by %s was published in %d\n", chosenBook.getName(), chosenBook.getAuthor().toString(), chosenBook.getYear());
    }

    public void setYear(String name, int year){
        chosenBook = searchBook(name);
        System.out.println("Publication year set to " + year);
        chosenBook.setYear(year);
    }

    private Book searchBook(String name){
        for (Book book : books) {
            if(book == null){
                throw new RuntimeException("There is no book in the library with the title " + name);
            }
            if(book.getName().equals(name)){
                return book;
            }
        }
        throw new RuntimeException("There is no book in the library with the title " + name);
    }

    private String separator(){
        return "-----------------------------------------------------------------------\n";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(separator());
        stringBuilder.append("Library:").append("\n");
        for (Book book : books) {
            if(book == null){
                break;
            }
            stringBuilder.append(book).append("\n");
        }
        stringBuilder.append(separator());
        return stringBuilder.toString();
    }
}
