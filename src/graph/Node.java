package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal Hanebach on 14.06.18, 13:28
 * Contact: michal.hanebach@gmail.com
 */
public class Node {

    private String data;
    private List<Node> neighbors;

    public Node(String data) {

        this.data = data;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor) {

        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public String getData() {
        return data;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public boolean equals(Object o) {

        if (o instanceof Node) {

            Node nodeRef = (Node)o;
            return nodeRef.getData().equals(this.getData());
        }
        return false;
    }

    public String toString() { return data; }
}
