package socialGraph.graph;

import java.util.*;

public class Graph {
    private final Map<Node, List<Node>> map = new HashMap<>();

    public void addNode(Node node){
        map.put(node, new LinkedList<>());
    }

    public void addEdge(Node source, Node destination, boolean bidirectional){
        if(!map.containsKey(source))
            addNode(source);
        if (!map.containsKey(destination))
            addNode(destination);
        map.get(source).add(destination);
        if(bidirectional) map.get(destination).add(source);
    }

    public int distance(Node source, Node destination){
        int result = 0;
        Node current;
        Set<Node>  visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);
        while (!queue.isEmpty()){
            for(int i = 0; i < queue.size(); i++){
                current = queue.poll();
                if (current == destination) return result;
                for (Node friend : map.get(current)) {
                    if (!visited.contains(friend)) {
                        visited.add(friend);
                        queue.add(friend);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
