package search.database;

import search.url.URL;

import java.util.List;

public interface Database {
    List<URL> getByWord(String query);
}
