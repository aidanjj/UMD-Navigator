package com.example.testline;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;
public class Dijkstra {

    HashMap<Vertex,Float> findDistances(Graph g, Vertex v){
        HashMap<Vertex,Float> distances = new HashMap<>();
        HashMap<Vertex,Vertex> pathList = new HashMap<>();
        VertexPriorityQueue queue = new VertexPriorityQueue();
        distances.put(v,0f);
        queue.add(v,0f);
        while (!queue.isEmpty()){
            Vertex curVertex = queue.poll().vertex;
            for (Edge e : g.getNeighbors(curVertex)){
                Vertex neighbor = e.getDst();
                if (distances.containsKey(neighbor)){
                    if (e.getWeight() + distances.get(curVertex) < distances.get(neighbor)){
                        distances.put(neighbor,e.getWeight() + distances.get(curVertex));
                        pathList.replace(neighbor,curVertex);
                    }
                }
                else {
                    distances.put(neighbor,e.getWeight() + distances.get(curVertex));
                    pathList.put(neighbor,curVertex);
                    queue.add(neighbor,e.getWeight());
                }
            }
        }
        return distances;
    }
    HashMap<Vertex,Vertex> searchPaths(Graph g, Vertex v){
        HashMap<Vertex,Float> distances = new HashMap<>();
        HashMap<Vertex,Vertex> pathList = new HashMap<>();
        VertexPriorityQueue queue = new VertexPriorityQueue();
        distances.put(v,0f);
        queue.add(v,0f);
        while (!queue.isEmpty()){
            Vertex curVertex = queue.poll().vertex;
            for (Edge e : g.getNeighbors(curVertex)){
                Vertex neighbor = e.getDst();
                if (distances.containsKey(neighbor)){
                    if (e.getWeight() + distances.get(curVertex) < distances.get(neighbor)){
                        distances.put(neighbor,e.getWeight() + distances.get(curVertex));
                        pathList.replace(neighbor,curVertex);
                    }
                }
                else {
                    distances.put(neighbor,e.getWeight() + distances.get(curVertex));
                    pathList.put(neighbor,curVertex);
                    queue.add(neighbor,e.getWeight());
                }
            }
        }
        /*for (HashMap.Entry<Vertex,Float> entry : distances.entrySet()){
            System.out.println(entry.getKey().getLabel() + ": " + entry.getValue());
        }*/
        /*for (HashMap.Entry<Vertex,Vertex> entry : pathList.entrySet()){
            System.out.println(entry.getKey().getLabel() + "->" + entry.getValue().getLabel());
        }*/
        return pathList;
    }
}
