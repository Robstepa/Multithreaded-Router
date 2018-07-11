import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GraphCreator{
    private ArrayList<Node> nodeList = new ArrayList<>();

    Graph runGraphCreator(){
        String path = "graph.txt";
        createNode(path);
        createNeighbor(path);
        Graph graph = buildGraph();
        printNodeData(graph);
        return graph;
    }


    private void createNode(String path){

        String[] words;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while (((line=br.readLine()) != null)){
                words = line.split(" ");
                String nodeData = words[0];
                Node node = new Node(nodeData);
                nodeList.add(node);
                }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createNeighbor(String path){
        String[] words;
        int nodeIndex = 0;
        try{
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
                nodeIndex ++;
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        for(int i = 0; i < nodeList.size(); i++){
            Node node = graph.getNodeByName(nodeList.get(i).getData());
            System.out.print(node.getData() + " --> siez: ");
            System.out.println(nodeList.get(i).getNeighbors().size() + " contains: ");
            List<Node> list = node.getNeighbors();
            for(Node l : list){
                System.out.print(l.getData());
            }
            System.out.println();

        }
    }
}