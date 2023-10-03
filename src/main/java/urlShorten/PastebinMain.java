package urlShorten;

import urlShorten.manager.URLManager;
import urlShorten.url.URL;
import urlShorten.utils.GlobalCache;

import java.time.LocalDateTime;

public class PastebinMain {
    public static void main(String[] args) {
        GlobalCache globalCache = new GlobalCache();
        URLManager urlManager = new URLManager(globalCache);
        String query = "test1";
        URL generatedURL = urlManager.generateURLWithNoExpiryTime(query);
        System.out.println(generatedURL.getUrl());
        URL generatedURL2 = urlManager.generateURLWithExpiryTime(query, LocalDateTime.now());
        System.out.println(generatedURL2.getUrl());
    }
}
