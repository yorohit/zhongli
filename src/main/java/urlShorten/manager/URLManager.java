package urlShorten.manager;

import urlShorten.url.GeneratedURL;
import urlShorten.utils.GlobalCache;
import urlShorten.url.URL;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class URLManager {
    Map<String, URL> cache = new HashMap<>();
    Map<String, String> reverseCache = new HashMap<>();
    final GlobalCache globalCache;

    public URLManager(GlobalCache globalCache) {
        this.globalCache = globalCache;
    }

    public URL generateURLWithNoExpiryTime(String query){
        return generateURL(query);
    }

    public URL generateURLWithExpiryTime(String query, LocalDateTime expirationTime){
        URL url = generateURL(query);
        ((GeneratedURL)url).setExpirationDate(expirationTime);
        return url;
    }

    private URL generateURL(String query){
        if(cache.containsKey(query)){
            return cache.get(query);
        }
        URL url = new GeneratedURL();
        url.setURL(query, globalCache);
        cache.put(query, url);
        reverseCache.put(url.getUrl(), query);
        return url;
    }

    public Optional<String> redirectURL(String query){
        return Optional.ofNullable(reverseCache.get(query));
    }

    private void purge(GeneratedURL url){
        //add logic to purge cache for expired URLs based on expiration date
        globalCache.removeEntry(url.hashCode());
        reverseCache.remove(url.getUrl());
        cache.remove(url.getOriginalUrl());
    }
}
