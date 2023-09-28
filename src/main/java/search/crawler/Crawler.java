package search.crawler;

import search.url.URL;
import java.util.List;

public class Crawler {

    public List<URL> get(String query){
        return List.of(new URL("https:www." + query +".com"));
    }
}
