package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashMap;

public class DijkstraTests {

    @Test
    public void test1(){
        Graph g = new Graph();
        HashMap<Vertex,Float> correctDistances = new HashMap<>();
        Dijkstra search = new Dijkstra();
        Vertex v1 = new Vertex("v1"); g.addVertex(v1);
        Vertex v2 = new Vertex("v2"); g.addVertex(v2);
        Vertex v3 = new Vertex("v3"); g.addVertex(v3);
        Vertex v4 = new Vertex("v4"); g.addVertex(v4);
        Edge e1 = new Edge(v1,v2,1f); g.addDirEdge(e1);
        Edge e6 = new Edge(v2,v1,.5f); g.addDirEdge(e6);
        Edge e2 = new Edge(v1,v3,4f); g.addDirEdge(e2);
        Edge e3 = new Edge(v2,v3,2f); g.addDirEdge(e3);
        Edge e4 = new Edge(v2,v4,3f); g.addDirEdge(e4);
        Edge e5 = new Edge(v3,v4,5f); g.addDirEdge(e5);
        correctDistances.put(v1,0f);
        correctDistances.put(v2,1f);
        correctDistances.put(v3,3f);
        correctDistances.put(v4,4f);
        HashMap<Vertex,Float> distances = search.findDistances(g,v1);
        assertEquals(correctDistances,distances);
    }
    @Test
    public void threeCycleWithIsolatedVertex(){
        Graph g = new Graph();
        Dijkstra search = new Dijkstra();
        HashMap<Vertex,Float> correctDistances = new HashMap<>();
        Vertex v1 = new Vertex("v1"); g.addVertex(v1);
        Vertex v2 = new Vertex("v2"); g.addVertex(v2);
        Vertex v3 = new Vertex("v3"); g.addVertex(v3);
        Vertex v4 = new Vertex("v4"); g.addVertex(v4);
        Edge e1 = new Edge(v1,v2,5f); g.addDirEdge(e1);
        Edge e2 = new Edge(v1,v3,2f); g.addDirEdge(e2);
        Edge e3 = new Edge(v2,v3,1f); g.addDirEdge(e3);
        correctDistances.put(v1,0f);
        correctDistances.put(v2,5f);
        correctDistances.put(v3,2f);
        HashMap<Vertex,Float> distances = search.findDistances(g,v1);
        assertEquals(correctDistances,distances);
    }
    @Test
    public void singleVertexWithEdge(){
        Graph g = new Graph();
        HashMap<Vertex,Float> correctDistances = new HashMap<>();
        Dijkstra search = new Dijkstra();
        Vertex v1 = new Vertex("v1"); g.addVertex(v1);
        Edge e1 = new Edge(v1,v1,5f);
        correctDistances.put(v1,0f);
        HashMap<Vertex,Float> distances = search.findDistances(g,v1);
        assertEquals(correctDistances,distances);
    }
}

