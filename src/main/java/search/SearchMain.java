package search;

import search.database.InMemoryDatabase;

public class SearchMain {
    public static void main(String[] args) {
        SearchAPI api = new SearchAPI(new InMemoryDatabase());
        System.out.println(api.search("whatup").get(0).getUrl());
    }
}
