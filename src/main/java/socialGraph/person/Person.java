package socialGraph.person;

public class Person {
    private final int userId;
    private final String name;

    public Person(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
