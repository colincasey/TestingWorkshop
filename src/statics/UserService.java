package statics;

public class UserService {
    public User getUser(long id) {
        User cachedUser = LocalCache.get(id);

        if(cachedUser != null) {
            return cachedUser;
        }

        User user = Database.find(id);
        LocalCache.put(user);
        return user;
    }
}
