package graph;

import java.util.*;

/**
 * Created by Michal Hanebach on 14.06.18, 13:28
 * Contact: michal.hanebach@gmail.com
 */
public class Graph {

    private List<Node> nodes;
    private Set<String> nodeNames;

    public Graph() {

        nodes = new ArrayList<>();
        nodeNames = new HashSet<>();
    }

    public Node getNodeByName(String name) {

        if (nodeNames.contains(name)) {
            for (Node node : nodes) {

                if (node.getData().equals(name)) {

                    return node;
                }
            }
        }
        throw new NoSuchElementException(String.format("no node of name %s", name));
    }

    public void addNode(Node node) {

        if (nodeNames.contains(node.getData())) {

            throw new IllegalStateException("cannot add node with the same data more than once");
        }
        nodes.add(node);
        nodeNames.add(node.getData());
    }

    public boolean BFS(String name) {

        ArrayDeque<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        visited.add(nodes.get(0));
        q.offerFirst(nodes.get(0));

        while(!q.isEmpty()) {

            Node current = q.pollFirst();
            if (current.getData().equals(name)) {
                return true;
            }

            for (Node node : current.getNeighbors()) {

                if (!visited.contains(node)) {
                    q.offerLast(node);
                    visited.add(node);
                }
            }
        }
        return false;
    }
}
