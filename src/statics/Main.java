package statics;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService(new Database(), new LocalCache());

        System.out.println("Slow Queries:");
        printUserDetails(userService.getUser(1));
        printUserDetails(userService.getUser(2));

        System.out.println("Cached Query:");
        printUserDetails(userService.getUser(1));
    }

    private static void printUserDetails(User user) {
        String template = "User (%d) - %s";
        String userDetails = String.format(template, user.getId(), user.getUsername());
        System.out.println(userDetails);
    }
}
