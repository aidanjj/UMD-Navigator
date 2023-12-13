package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VertexTests {
    @Test
    public void setVertexAsVisted(){
        Vertex v = new Vertex();
        assertFalse(v.getVisited());
        v.setVisited(true);
        assertTrue(v.getVisited());
    }
    @Test
    public void vertexLabelTest() {
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex("v2");
        assertEquals("Unassigned", v1.getLabel());
        assertEquals("v2", v2.getLabel());
    }
}
