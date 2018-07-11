import graph.Graph;
import graph.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Michal Hanebach on 14.06.18, 14:19
 * Contact: michal.hanebach@gmail.com
 */
public class GraphTest {

    @Test
    public void testShortestPathUnweighted() {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        Graph graph = new Graph();
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        graph.addNode(nodeH);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeD);

        nodeB.addNeighbor(nodeA);
        nodeB.addNeighbor(nodeC);

        nodeC.addNeighbor(nodeB);

        nodeD.addNeighbor(nodeA);
        nodeD.addNeighbor(nodeE);
        nodeD.addNeighbor(nodeH);

        nodeE.addNeighbor(nodeD);
        nodeE.addNeighbor(nodeF);
//        nodeE.addNeighbor(nodeG);
        nodeE.addNeighbor(nodeH);

        nodeF.addNeighbor(nodeE);
        nodeF.addNeighbor(nodeG);

//        nodeG.addNeighbor(nodeE);
        nodeG.addNeighbor(nodeF);
        nodeG.addNeighbor(nodeH);

        nodeH.addNeighbor(nodeD);
        nodeH.addNeighbor(nodeE);
        nodeH.addNeighbor(nodeG);

        List<Node> actual = graph.shortestPathUnweighted(nodeC, nodeH);
        assertEquals(Arrays.asList(nodeC, nodeB, nodeA, nodeD, nodeH), actual);

        actual = graph.shortestPathUnweighted(nodeF, nodeD);
        assertEquals(Arrays.asList(nodeF, nodeE, nodeD), actual);

        actual = graph.shortestPathUnweighted(nodeC, nodeG);
        assertEquals(Arrays.asList(nodeC, nodeB, nodeA, nodeD, nodeH, nodeG), actual);

        Node dummyNode = new Node("node which is not in the graph");
        actual = graph.shortestPathUnweighted(nodeC, dummyNode);
        assertEquals(0, actual.size());

        actual = graph.shortestPathUnweighted(dummyNode, nodeC);
        assertEquals(0, actual.size());
    }

    @Test
    public void testBFS() {

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