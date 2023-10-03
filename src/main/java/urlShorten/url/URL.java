package urlShorten.url;

import urlShorten.utils.GlobalCache;

public interface URL {
    String getUrl();
    void setURL(String query, GlobalCache globalCache);

}
