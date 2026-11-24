package lms.model;

/**
 * Represents a book item in the library system.
 */
public class Book extends LibraryItem {

    private String author;

    /**
     * Creates a new Book instance.
     *
     * @param itemId unique identifier for the book
     * @param title  title of the book
     * @param author author name of the book
     */
    public Book(String itemId, String title, String author) {
        super(itemId, title);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public final void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or blank.");
        }
        this.author = author.trim();
    }

    @Override
    public String toString() {
        return String.format(
                "Book{id='%s', title='%s', author='%s', borrowed=%s}",
                getItemId(),
                getTitle(),
                author,
                isBorrowed()
        );
    }
}
