package application;

import graph.Graph;
import graph.Node;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    GraphCreator graphCreator;
    Scanner scanner;

    public Application() {
        graphCreator = new GraphCreator();
        scanner = new Scanner(System.in);
    }
    
    public void start() {
        Graph graph = createGraph();
        Node startNode = createNode(graph);
        Node destinationNode = createNode(graph);
        int numberOfThreads = getNumberOfThreads();
        List<Node> result = graph.shortestPathUnweighted(startNode, destinationNode);
        System.out.println(result);
    }

    private int getNumberOfThreads() {
        System.out.print("Enter a number of threads: ");
        while(!scanner.hasNextInt()) {
            System.out.println("That's not a number!\nEnter a number of threads: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        return num;
    }

    private Node createNode(Graph graph) {
        String nodeName = getInputFromUser("Enter node name: ");
        while(!graph.getNodeNames().contains(nodeName)) {
            nodeName = getInputFromUser("No node of that name. Try again. \nEnter node name: ");
        }
        return graph.getNodeByName(nodeName);
    }

    private String getInputFromUser(String message) {
        System.out.print(message);
        String path = scanner.nextLine();
        return path;
    }

    private Graph createGraph() {
        boolean fileExist = false;
        Graph graph = null;
        while(!fileExist) {
            try {
                String path = getInputFromUser("Enter file name: ");
                graph = graphCreator.createGraphFromFile(path);
                fileExist = true;
            } catch (IOException e) {
                System.out.println("File not exist");
                System.exit(1);
            }
        }
        return graph;
    }
}
