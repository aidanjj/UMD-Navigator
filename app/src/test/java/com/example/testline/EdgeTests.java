package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EdgeTests {
    @Test
    public void edgeWeightTest(){
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Edge e1 = new Edge(v1,v2);
        assertEquals(1.0f,e1.getWeight(),.001f);
        e1.setWeight(5.5f);
        assertEquals(v1,e1.getSrc());
        assertEquals(v2,e1.getDst());
        assertEquals(5.5f,e1.getWeight(),.001f);

        Edge e2 = new Edge(v1,v2,5.5f);
        assertEquals(v1,e2.getSrc());
        assertEquals(v2,e2.getDst());
        assertEquals(5.5f,e2.getWeight(),.001f);
    }
}
