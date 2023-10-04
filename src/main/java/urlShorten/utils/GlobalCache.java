package urlShorten.utils;

import java.util.HashSet;
import java.util.Set;

public class GlobalCache {
    Set<Integer> cache = new HashSet<>();

    public void addEntry(Integer query){
        cache.add(query);
    }

    public boolean checkEntry(Integer query){
        return cache.contains(query);
    }

    public void removeEntry(Integer query){
        cache.remove(query);
    }
}
