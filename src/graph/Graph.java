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

    public Set<String> getNodeNames() {
        return nodeNames;
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


    public List<Node> shortestPathUnweighted(Node startNode, Node endNode) {

        final String startName = startNode.getData();
        final String endName = endNode.getData();

        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();

        for (Node node : nodes) {
            visited.put(node.getData(), false);
            dist.put(node.getData(), -1);
            predecessors.put(node.getData(), null);
        }

        ArrayDeque<Node> q = new ArrayDeque<>();

        visited.put(startName, true);
        dist.put(startName, 0);
        q.offerFirst(startNode);

        boolean endFound = false;
        while(!endFound && !q.isEmpty()) {

            Node former = q.pollFirst();
            for (Node neighbor : former.getNeighbors()) {

                if (!visited.get(neighbor.getData())) {
                    // mark as visited
                    visited.put(neighbor.getData(), true);
                    // update distance - the graph is unweighted hence the 1
                    dist.put(neighbor.getData(), dist.get(former.getData()) + 1);
                    // save predecessor
                    predecessors.put(neighbor.getData(), former.getData());
                    // add neighbor for further traversal
                    q.offerLast(neighbor);
                    if (neighbor.getData().equals(endName)) {
                        endFound = true;
                    }
                }
                if (endFound) break;
            }
        }

        List<Node> result = new ArrayList<>();
        if (endFound) {
            // compose the route by reverse lookup from endName to startName
            String reverseIter = endName;
            result.add(startNode);
            while (predecessors.get(reverseIter) != null) {
                result.add(1, getNodeByName(reverseIter));
                reverseIter = predecessors.get(reverseIter);
            }
        }
        return result;
    }
}
