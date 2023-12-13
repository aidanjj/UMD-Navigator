package com.example.testline;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    public Graph(){
        adjacencyList = new HashMap<>(1024);
    }
    public void addVertex(Vertex v){
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new LinkedList<>());
        }
    }
    public void addDirEdge(Edge newEdge){
        LinkedList<Edge> srcEdgeList = adjacencyList.get(newEdge.getSrc());
        srcEdgeList.add(newEdge);
    }
    public void addUndirEdge(Edge newEdge){
        LinkedList<Edge> srcEdgeList = adjacencyList.get(newEdge.getSrc());
        LinkedList<Edge> dstEdgeList = adjacencyList.get(newEdge.getDst());
        Edge reverseEdge = new Edge(newEdge.getDst(),newEdge.getSrc());
        srcEdgeList.add(newEdge);
        dstEdgeList.add(reverseEdge);
    }
    public void addEdge(Vertex src, Vertex dst){
        LinkedList<Edge> srcEdgeList = adjacencyList.get(src);
        Edge newEdge = new Edge(src,dst);
        srcEdgeList.add(newEdge);
    }

    public void printGraph(){
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : adjacencyList.entrySet()) {
            LinkedList<Edge> edges = hEntry.getValue();
            System.out.print(hEntry.getKey().getLabel() + " : ");
            for (Edge e : edges){
                System.out.print(e.getDst().getLabel() + " -> ");
            }
            System.out.println("nil");
        }
    }
    public boolean containsEdge(Edge e){
        LinkedList<Edge> edges = adjacencyList.get(e.getSrc());
        for (Edge curEdge : edges){
            if (curEdge == e){
                return true;
            }
        }
        return false;
    }
    public boolean containsVertex(Vertex v){
        return adjacencyList.containsKey(v);
    }
    public float getEdgeWeight(Vertex src, Vertex dst){
        LinkedList<Edge> edges = adjacencyList.get(src);
        for (Edge curEdge : edges){
            if (curEdge.getDst() == dst){
                return curEdge.getWeight();
            }
        }
        return -1;
    }
    public int getDegree(Vertex v){
        return getOutDegree(v) + getInDegree(v);
    }
    public int getOutDegree(Vertex v){
        LinkedList<Edge> edges = adjacencyList.get(v);
        return edges.size();
    }
    public int getInDegree(Vertex v){
        int edgeCount = 0;
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : adjacencyList.entrySet()) {
            LinkedList<Edge> edges = hEntry.getValue();
            for (Edge e : edges){
                if (e.getDst() == v){
                    edgeCount++;
                }
            }
        }
        return edgeCount;
    }
    public LinkedList<Edge> getNeighbors(Vertex v){
        if (adjacencyList.containsKey(v)){
            return adjacencyList.get(v);
        }
        return new LinkedList<>();

    }
    private HashMap<Vertex, LinkedList<Edge>> adjacencyList;
}
