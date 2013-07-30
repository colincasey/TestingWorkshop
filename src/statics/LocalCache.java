package statics;

import java.util.HashMap;

public class LocalCache {
    private static HashMap<Long, User> cache = new HashMap<Long, User>();

    public User get(long id) {
        return cache.get(id);
    }

    public void put(User user) {
        cache.put(user.getId(), user);
    }
}
