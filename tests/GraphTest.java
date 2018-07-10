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

        assertEquals(true, graph.BFS("B"));
        assertEquals(true, graph.BFS("C"));
        assertEquals(true, graph.BFS("D"));
        assertEquals(true, graph.BFS("E"));
        assertEquals(true, graph.BFS("F"));
        assertEquals(true, graph.BFS("G"));
        assertEquals(false, graph.BFS("I"));

        assertEquals(nodeA, nodeA);
        assertFalse(nodeA.equals(nodeB));
    }
}