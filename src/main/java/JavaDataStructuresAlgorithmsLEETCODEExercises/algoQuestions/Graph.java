package JavaDataStructuresAlgorithmsLEETCODEExercises.algoQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }

    public void printGraph() {
        System.out.println(adjList);
    }


    public boolean addVertex(String value){
        if (!adjList.containsKey(value)){
            adjList.put(value,new ArrayList<>());
            return true;
        }
        return false;
    }
}
