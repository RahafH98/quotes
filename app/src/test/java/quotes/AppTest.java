package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void testReadDataFromBufferedReader() throws IOException {
        String testData = " Quote data\n Author\n";
        BufferedReader reader = new BufferedReader(new StringReader(testData));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }

        assertEquals(" Quote data\n Author\n", result.toString());
    }

    @Test
    public void testHttpURLConnection() throws IOException {
        URL url = new URL("https://example.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        int responseCode = connection.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, responseCode);
    }

    @Test
    public void testJsonParsing() {
        String json = "[{\"author\":\"Author1\",\"text\":\"Quote1\"}," +
                "{\"author\":\"Author2\",\"text\":\"Quote2\"}]";
        Gson gson = new Gson();

        Quote[] quoteList = gson.fromJson(json, Quote[].class);

        assertEquals(2, quoteList.length);
        assertEquals("Author1", quoteList[0].getAuthor());
        assertEquals("Quote1", quoteList[0].getQuote());
        assertEquals("Author2", quoteList[1].getAuthor());
        assertEquals("Quote2", quoteList[1].getQuote());
    }

    @Test
    public void testWriteDataFromBufferedWriter() throws IOException {
        String data = "Quote data\nAuthor\n";

        // Create a StringWriter to capture the written data
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);

        bufferedWriter.write(data);
        bufferedWriter.flush();
        String result = stringWriter.toString();
        assertEquals("Quote data\nAuthor\n", result);
    }

}