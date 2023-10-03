package urlShorten.url;

import urlShorten.utils.GlobalCache;

import java.time.LocalDateTime;
import java.util.Random;

public class GeneratedURL implements URL{
    LocalDateTime expirationTime;
    String url = null;
    String originalUrl;
    int urlHash;
    Random rand = new Random();
    @Override
    public String getUrl(){
        return url;

    }

    public String getOriginalUrl(){
        return originalUrl;
    }
    public void setExpirationTime(LocalDateTime expirationTime){
        this.expirationTime = expirationTime;
    }

    public LocalDateTime getExpirationTime(){
        return this.expirationTime;
    }

    @Override
    public void setURL(String query, GlobalCache globalCache){
        this.url = hashURL(query, globalCache);
        this.originalUrl = query;
    }

    private String hashURL(String query, GlobalCache globalCache){
        urlHash = query.hashCode();
        while(globalCache.checkEntry(urlHash)){
            urlHash+=rand.nextInt(1, 100000);
        }
        globalCache.addEntry(urlHash);
        return "https://" + urlHash + ".com";
    }
}
