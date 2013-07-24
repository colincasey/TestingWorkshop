package statics;

public class Database {
    public static User find(long id) {
        simulateLatency();
        return new User(id, "username" + id);
    }

    private static void simulateLatency() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            // no-op
        }
    }
}
