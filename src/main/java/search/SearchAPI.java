package search;

import search.database.Database;
import search.url.URL;

import java.util.List;

public class SearchAPI {
    //Think about multithreading later

    private final Database database;
    public SearchAPI(Database database){
        this.database = database;
    }
    public List<URL> search(String query){
        return database.getByWord(query);
    }
}
