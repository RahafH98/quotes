# Random Quote Generator 

The application displays random quotes using JSON data.

# Quote class 
gives the structure of quotes and it's author 

# Random Quote class 
The RandomQuote class is responsible for retrieving and organizing a collection of quotes from a JSON data source.
It accomplishes this by initiating a fresh connection to a URL through HttpURLConnection. 
It then retrieves the JSON data using a BufferedReader to read the content. 
Using a randomization function, the class selects a quote at random from the obtained data on each occasion.
Subsequently, the chosen quote is stored within a list for future reference.


![random quote.JPG](random%20quote.JPG)