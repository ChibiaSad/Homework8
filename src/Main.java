import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //minimal
        Author author1 = new Author("George R.R.", "Martin");
        Book book1 = new Book("Game of Thrones", author1, 1996);
        Book book2 = new Book("A Knight of the Seven Kingdoms", author1, 1997);
        System.out.printf("Книга %s, автором которой является %s, была написана в %d году\n", book1.getName(), book1.getAuthor().toString(), book1.getYear());
        book2.setYear(1998);
        System.out.printf("Книга %s, автором которой является %s, была написана в %d году\n\n", book2.getName(), book2.getAuthor().toString(), book2.getYear());

        //middle
        Book[] books = {book1, book2};
        Author author2 = new Author("Stephen", "King");
        Book book3 = new Book("The Stand", author2, 1978);
        Book book4 = new Book("It", author2, 1985);

        books = addBook(books, book3);
        books = addBook(books, book4);

        printAllLibrary(books);

        //hard
        System.out.println();
        Library library = new Library(3);
        library.addBook(book1);
        library.addBook(book3);
        library.addBook(book2);
        library.addBook(book4);
        library.printAllLibrary();

        library.bookData("It");
        library.setYear("It", 1986);
        library.bookData("It");
    }

    private static void printAllLibrary(Book[] books) {
        for (Book book : books) {
            System.out.printf("%s: %s: %d\n", book.getAuthor().toString(), book.getName(), book.getYear());
        }
    }

    public static Book[] addBook(Book[] books, Book book){
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = book;
        return books;
    }
}