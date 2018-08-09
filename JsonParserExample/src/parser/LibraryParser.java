package parser;


// An example of a simple JSON parser to parse a json file representing a library of books

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class LibraryParser {

    /**
     * Prints library parsed from JSON data to console
     * @param jsonData  string containing JSON data
     */
	public void parseLibrary(String jsonData) {
        JsonReader reader = Json.createReader(new StringReader(jsonData));
        JsonArray arrivals = reader.readArray();

        for (int index = 0; index < arrivals.size(); index++) {
            JsonObject book = arrivals.getJsonObject(index);
            parseBook(book);
        }
    }

    /**
     * Prints book parsed from JSON object to console
     * @param book  a JSON object representing a book
     */
    private void parseBook(JsonObject book) {
        String title = book.getString("title");
        String author = book.getString("author");

        System.out.println("Parsed a book!");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println();
    }
}
