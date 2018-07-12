package application;

import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GraphCreator{
    private ArrayList<Node> nodeList = new ArrayList<>();
    private boolean isFileFound = false;

    public Graph createGraphFromFile(String path) throws IOException {
        while (!isFileFound){
            createNode(path);
            createNeighbor(path);
        }
        Graph graph = buildGraph();
        return graph;
    }

    private void createNode(String path) throws IOException {
        String[] words;

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while (((line=br.readLine()) != null)){
            words = line.split(" ");
            String nodeData = words[0];
            Node node = new Node(nodeData);
            nodeList.add(node);
        }
        isFileFound = true;
        br.close();
    }

    private void createNeighbor(String path)throws IOException {
        String[] words;
        int nodeIndex = 0;

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;

        while (((line=br.readLine()) != null)){
            words = line.split(" ");
            for (int i = 1; i < words.length; i++){
                for(Node node : nodeList){
                    if(node.getData().equals(words[i])){
                        nodeList.get(nodeIndex).addNeighbor(node);
                        System.out.println(node.getData()+" is Neighbor " + nodeList.get(nodeIndex).getData());
                    }
                }
            }
            nodeIndex++;
        }
    }

    private Graph buildGraph(){
        Graph graph = new Graph();
        for (Node node: nodeList){
            graph.addNode(node);
        }
        return graph;
    }

    private void printNodeData(Graph graph){
        for (Node aNodeList : nodeList) {
            Node node = graph.getNodeByName(aNodeList.getData());
            List<Node> list = node.getNeighbors();
            StringBuilder nodes = new StringBuilder();
            for (Node l : list) {
                nodes.append(l.getData() + " ");
            }
            System.out.println(String.format("%s --> size: %d, contains: %s", node.getData(),
                    aNodeList.getNeighbors().size(), nodes));
        }
    }
}