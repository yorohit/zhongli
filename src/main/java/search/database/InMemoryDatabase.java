package search.database;

import search.crawler.Crawler;
import search.url.URL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase implements Database{
    private final Map<String, List<URL>> cache = new HashMap<>();
    private final Crawler crawler = new Crawler();
    @Override
    public List<URL> getByWord(String query) {
        if(cache.containsKey(query)) return cache.get(query);
        cache.put(query, crawler.get(query));
        return cache.get(query);
    }
}
