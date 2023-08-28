package quotes;

import com.google.gson.Gson;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomQuote {

    private static final String JSON_URL = "https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json";

    private List<Quote> quotes;

    public RandomQuote() {
        quotes = fetchQuotes();
    }

    private List<Quote> fetchQuotes() {
        List<Quote> quoteList = new ArrayList<>();

        try {
            String jsonData = fetchDataFromURL(JSON_URL);
            Gson gson = new Gson();
            Quote[] quoteArray = gson.fromJson(jsonData, Quote[].class); //

            for (Quote quote : quoteArray) {
                quoteList.add(quote);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quoteList;
    }

    public Quote getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }

    private String fetchDataFromURL(String urlString) throws IOException {
        StringBuilder content = new StringBuilder();

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } finally {
            connection.disconnect();
        }

        return content.toString();
    }


}