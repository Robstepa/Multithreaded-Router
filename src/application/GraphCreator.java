import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphCreator{

    Node node;
    Graph graph;

    public void createNode(String path){
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            if (br.readLine() == null){
                return;
            }
            while ((line != null)){
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}