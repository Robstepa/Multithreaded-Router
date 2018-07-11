import graph.Graph;
import graph.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michal Hanebach on 14.06.18, 14:19
 * Contact: michal.hanebach@gmail.com
 */
public class GraphTest {

    @Test
    public void BFS() {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeE);
        nodeB.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeC.addNeighbor(nodeF);
        nodeD.addNeighbor(nodeA);
        nodeD.addNeighbor(nodeF);
        nodeF.addNeighbor(nodeC);
        nodeF.addNeighbor(nodeD);
        nodeF.addNeighbor(nodeG);

        assertTrue(graph.BFS("B"));
        assertTrue(graph.BFS("C"));
        assertTrue(graph.BFS("D"));
        assertTrue(graph.BFS("E"));
        assertTrue(graph.BFS("F"));
        assertTrue(graph.BFS("G"));
        assertFalse(graph.BFS("I"));

        assertEquals(nodeA, nodeA);
        assertNotEquals(nodeA, nodeB);
    }
}