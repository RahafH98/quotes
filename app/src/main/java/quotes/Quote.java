package quotes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Quote {

    private String text;
    private String author;

    public Quote(String quote, String author) {
        this.text = quote;
        this.author = author;
    }

    public String getQuote(){

        return text;
    }

    public String getAuthor(){

        return author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quote='" + text + '\n' +
                ", author='" + author + '\'' +
                '}';
    }
}
