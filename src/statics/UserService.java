package statics;

public class UserService {
    private final Database database;
    private final LocalCache localCache;

    public UserService(Database database, LocalCache localCache) {
        this.database = database;
        this.localCache = localCache;
    }

    public User getUser(long id) {
        User cachedUser = localCache.get(id);

        if(cachedUser != null) {
            return cachedUser;
        }

        User user = database.find(id);

        if(user == null) {
            throw new NotFoundException("user with id=" + id + " was not found");
        }

        localCache.put(user);
        return user;
    }
}
