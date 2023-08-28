
package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void testRandomQuoteFetch() {
        RandomQuote quoteFetcher = new RandomQuote();
        Quote randomQuote = quoteFetcher.getRandomQuote();

        assertNotNull(randomQuote);
        assertNotNull(randomQuote.getQuote());
        assertNotNull(randomQuote.getAuthor());

        System.out.println("Random Quote: " + randomQuote);
    }
}
