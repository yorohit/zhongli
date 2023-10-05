package socialGraph.graph;

import socialGraph.person.Person;

import java.util.List;

public class Node {
    final private Person person;
    private List<Node> friends;

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
