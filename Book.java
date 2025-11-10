public class Book extends Media {

    private String author;

    // constructor to set title n author
    public Book(String title, String author) {
        super(title); // set title in parent media class
        this.author = author;
    }

    // get authors name
    public String getAuthor() {
        return author;
    }

    // return book details as a string
    public String getDetails() {
        return "Book: " + getTitle() + " by " + author;
    }
}