package com.example.testline;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Vector;
public class Dijkstra {
    /**
     * Given a graph and a starting vertex, this returns a HashMap containing each vertex
     * paired with its distance from the starting vertex.
     * @param g The graph to be traversed.
     * @param v The starting vertex.
     * @return A HashMap containing each vertex paired with its distance from the starting vertex.
     */
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

    /**
     * Giving a graph and a starting vertex, this returns a HashMap containing each
     * vertex paired with its previously traversed vertex.
     * This is useful for keeping track of the vertices traversed on the shortest paths.
     * @param g The graph to be traversed
     * @param v The starting vertex
     * @return A HashMap containing each vertex paired with its previously traversed vertex.
     */
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
        return pathList;
    }
}
