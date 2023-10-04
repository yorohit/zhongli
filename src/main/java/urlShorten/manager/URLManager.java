package urlShorten.manager;

import urlShorten.url.GeneratedURL;
import urlShorten.utils.GlobalCache;
import urlShorten.url.URL;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class URLManager {
    Map<String, URL> cache = new HashMap<>();
    Map<String, URL> reverseCache = new HashMap<>();
    final GlobalCache globalCache;

    public URLManager(GlobalCache globalCache) {
        this.globalCache = globalCache;
    }

    public URL generateURLWithNoExpiryTime(String query){
        return generateURL(query);
    }

    public URL generateURLWithExpiryTime(String query, LocalDateTime expirationTime){
        URL url = generateURL(query);
        ((GeneratedURL)url).setExpirationTime(expirationTime);
        return url;
    }

    private URL generateURL(String query){
        if(cache.containsKey(query)){
            return cache.get(query);
        }
        URL url = new GeneratedURL();
        url.setURL(query, globalCache);
        cache.put(query, url);
        reverseCache.put(url.getUrl(), url);
        return url;
    }

    public String redirectURL(String query){
        if(reverseCache.containsKey(query)){
            GeneratedURL url = (GeneratedURL) reverseCache.get(query);
            if(url.getExpirationTime().isBefore(LocalDateTime.now())){
                purge(url);
                return "Expired URL";
            }
            else{
                return url.getOriginalUrl();
            }
        }
        return "URL not found";
    }

    private void purge(GeneratedURL url){
        //add logic to purge cache for expired URLs based on expiration date
        globalCache.removeEntry(url.hashCode());
        reverseCache.remove(url.getUrl());
        cache.remove(url.getOriginalUrl());
    }
}
