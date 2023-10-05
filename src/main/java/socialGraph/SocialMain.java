package socialGraph;

import socialGraph.graph.Graph;
import socialGraph.graph.Node;
import socialGraph.person.Person;

public class SocialMain {
    public static void main(String[] args) {
        Person person1 = new Person(1,"1");
        Person person2 = new Person(2,"2");
        Person person3 = new Person(3,"3");
        Person person4 = new Person(4,"4");
        Node node1 = new Node(person1);
        Node node2 = new Node(person2);
        Node node3 = new Node(person3);
        Node node4 = new Node(person4);
        Graph graph = new Graph();
        graph.addEdge(node1, node3, true);
        graph.addEdge(node2, node3, true);
        graph.addEdge(node2, node4, true);
        System.out.println(graph.distance(node1, node4));
    }
}
