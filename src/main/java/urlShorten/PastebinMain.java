package urlShorten;

import urlShorten.manager.URLManager;
import urlShorten.url.URL;
import urlShorten.utils.GlobalCache;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class PastebinMain {
    public static void main(String[] args) {
        GlobalCache globalCache = new GlobalCache();
        URLManager urlManager = new URLManager(globalCache);
        String query = "test1";
        URL generatedURL = urlManager.generateURLWithNoExpiryTime(query);
        System.out.println(generatedURL.getUrl());
        URL generatedURL2 = urlManager.generateURLWithExpiryTime(query, LocalDateTime.now());
        System.out.println(generatedURL2.getUrl());
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(urlManager.redirectURL(generatedURL2.getUrl()));
    }
}
