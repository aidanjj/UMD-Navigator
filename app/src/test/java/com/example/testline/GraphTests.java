package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTests {
    @Test
    public void getVertexDegrees(){
        Graph g = new Graph();
        Vertex v1 = new Vertex(); g.addVertex(v1);
        Vertex v2 = new Vertex(); g.addVertex(v2);
        Vertex v3 = new Vertex(); g.addVertex(v3);
        Vertex v4 = new Vertex(); g.addVertex(v4);
        Edge e1 = new Edge(v1,v2); g.addDirEdge(e1);
        Edge e2 = new Edge(v1,v3); g.addDirEdge(e2);
        Edge e3 = new Edge(v2,v4); g.addDirEdge(e3);
        Edge e4 = new Edge(v3,v4); g.addDirEdge(e4);
        Edge e5 = new Edge(v4,v1); g.addDirEdge(e5);
        Edge e6 = new Edge(v4,v4); g.addDirEdge(e6);
        assertEquals(3,g.getDegree(v1));
        assertEquals(2,g.getDegree(v2));
        assertEquals(2,g.getDegree(v3));
        assertEquals(5,g.getDegree(v4));
    }
    @Test
    public void printGraph(){
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        g.addVertex(v0);
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        g.addEdge(v0,v1); g.addEdge(v0,v2);
        g.addEdge(v1,v2); g.addEdge(v1,v1);
        g.addEdge(v2,v3); g.addEdge(v2,v4); g.addEdge(v2,v1); g.addEdge(v2,v5); g.addEdge(v2,v0);
        g.addEdge(v4,v0);
        g.addEdge(v5,v1);g.addEdge(v5,v3);
        g.addEdge(v3,v5);

        g.printGraph();
    }
    @Test
    public void addEdges(){
        Graph g = new Graph();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        Edge e1 = new Edge(v1,v2); g.addDirEdge(e1);
        Edge e2 = new Edge(v1,v3); g.addDirEdge(e2);
        Edge e3 = new Edge(v3,v1); g.addDirEdge(e3);
        Edge e4 = new Edge(v2,v3);

        assertTrue(g.containsEdge(e1));
        assertTrue(g.containsEdge(e2));
        assertTrue(g.containsEdge(e3));
        assertFalse(g.containsEdge(e4));
    }
    @Test
    public void addVertices(){
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex("v2");
        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v1);
        assertTrue(g.containsVertex(v1));
        assertTrue(g.containsVertex(v2));
    }
    @Test
    public void containsEdge(){
        Graph g = new Graph();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        g.addVertex(v1);
        g.addVertex(v1);
        g.addVertex(v2);
        Edge e = new Edge(v1,v2);
        assertFalse(g.containsEdge(e));
        g.addDirEdge(e);
        assertTrue(g.containsEdge(e));
    }
    @Test
    public void containsVertex(){
        Graph g = new Graph();
        Vertex v = new Vertex();
        assertFalse(g.containsVertex(v));
        g.addVertex(v);
        assertTrue(g.containsVertex(v));
    }
}
