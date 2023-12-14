package com.example.testline;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStarTraverse {
    private Graph g = new Graph();
    private HashMap<Vertex,PointDP> locations = new HashMap<>();

    /**
     * Returns the distance between two vertices in meters
     * @param v1 The first vertex
     * @param v2 The second vertex
     * @return The distance between the two vertices in meters
     */
    private float getDistance(Vertex v1, Vertex v2){
        PointDP p1 = locations.get(v1);
        PointDP p2 = locations.get(v2);
        float distance = (float)(1.1866*Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX())+(p1.getY() - p2.getY())*(p1.getY() - p2.getY())));
        return distance;
    }
    public AStarTraverse(Graph g, HashMap<Vertex,PointDP> locations){
        this.g = g;
        this.locations = locations;
    }

    /**
     * Finds the path between a source and a destination
     * @param g The graph to be traversed
     * @param src The starting vertex
     * @param dst The ending vertex
     * @return A HashMap containing the traversed vertices paired with their parent vertices.
     */
    public HashMap<Vertex,Vertex> findPath(Graph g, Vertex src, Vertex dst){
        VertexPriorityQueue openSet = new VertexPriorityQueue();
        VertexPriorityQueue closedSet = new VertexPriorityQueue();
        HashMap<Vertex,Float> costs = new HashMap<>();
        HashMap<Vertex,Float> distances = new HashMap<>();
        HashMap<Vertex,Vertex> prevVertices = new HashMap<>();
        openSet.add(src,getDistance(src,dst));
        costs.put(src,getDistance(src,dst));
        distances.put(src,0f);
        Vertex curNode = src;
        while (!openSet.isEmpty()){
            curNode = openSet.poll().vertex;
            if (curNode == dst){
                return prevVertices;
            }
            for (Edge e : g.getNeighbors(curNode)){
                float curDistance = 0f;
                Vertex prevVertex = curNode;
                while (prevVertices.containsKey(prevVertex)){
                    curDistance += distances.get(prevVertex);
                    prevVertex = prevVertices.get(prevVertex);
                }
                curDistance += e.getWeight();
                float cost = curDistance + e.getWeight() + getDistance(e.getDst(),dst);
                if (!openSet.contains( e.getDst()) && !closedSet.contains(e.getDst())){
                    openSet.add(e.getDst(),cost);
                    prevVertices.put(e.getDst(),curNode);
                    costs.put(e.getDst(),cost);
                    distances.put(e.getDst(),curDistance);
                }
                else if (cost < costs.get(e.getDst())){
                    costs.replace(e.getDst(),cost);
                    distances.replace(e.getDst(),curDistance);
                    prevVertices.replace(e.getDst(),curNode);
                    if (!openSet.contains(e.getDst())){
                        openSet.add(e.getDst(),cost);
                    }
                }
            }
            closedSet.add(curNode,getDistance(src,dst));
        }
        return prevVertices;
    }
}
