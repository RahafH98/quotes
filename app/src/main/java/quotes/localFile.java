package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class localFile {

    private List<Quote> quotes;
    private static final String path = "app/src/main/resources/Quote.json";

    public localFile() {
        try {
            quotes = fetchQuotes();
        } catch (Exception e) {
            e.printStackTrace();
            quotes = new ArrayList<>();
        }
    }

    public List<Quote> fetchQuotes() {
        List<Quote> quoteList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        Quote[] quoteArray = gson.fromJson(reader, Quote[].class);

        for (Quote quote : quoteArray) {
            quoteList.add(quote);
        }

        return quoteList;
    }

    public Quote getRandomQuote() {
        if (quotes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }

    public void writeQuotesToLocalFile(List<Quote> x) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(x, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
