package quotes;

import java.util.List;

public class App {

    public static void main(String[] args) {

        UrlQuote quoteFetcher = new UrlQuote();
        Quote randomQuote = quoteFetcher.getRandomQuote();
        System.out.println("Random Quote: " + randomQuote);

        localFile quoteFile = new localFile();
        List<Quote> savedQuotes = quoteFile.fetchQuotes();
        savedQuotes.add(randomQuote);
        quoteFile.writeQuotesToLocalFile(savedQuotes);

        Quote randomQuote1 = quoteFile.getRandomQuote();
        System.out.println("Random Quote1: " + randomQuote1);
    }
}
