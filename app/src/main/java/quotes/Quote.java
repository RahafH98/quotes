package quotes;

public class Quote {

    private String text;
    private String author;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getQuote() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
