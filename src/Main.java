public class Main {
    public static void main(String[] args) {
        Author georgeMartin = new Author("George R.R.", "Martin");
        Author stephenKing = new Author("Stephen", "King");
        Book gameOfThrones = new Book("Game of Thrones", georgeMartin, 1996);
        Book aKnightOfTheSevenKingdoms = new Book("A Knight of the Seven Kingdoms", georgeMartin, 1997);
        Book theStand = new Book("The Stand", stephenKing, 1978);
        Book it = new Book("It", stephenKing, 1985);
        Book it2 = new Book("It", stephenKing, 1985);

        System.out.println(gameOfThrones.equals(it));
        System.out.println(it.equals(it2));
        System.out.println(gameOfThrones);

        Library library = new Library(5);
        library.addBook(gameOfThrones);
        library.addBook(theStand);
        library.addBook(aKnightOfTheSevenKingdoms);
        library.addBook(it);
        System.out.println(library);

        library.bookData("It");
        library.setYear("It", 1986);
        library.bookData("It");
    }
}