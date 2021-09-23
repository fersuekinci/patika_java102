public class Book implements Comparable<Book>{
    String bookName;
    int pageNumber;
    String authorName;
    int releaseDate;

    @Override
    public int compareTo(Book o) {
        return (this.bookName.compareTo(o.bookName));
    }

    public Book(String bookName, int pageNumber, String authorName, int releaseDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.releaseDate = releaseDate;
    }
}
