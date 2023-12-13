package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PriorityQueueTests {
    @Test
    public void test1(){
        VertexPriorityQueue queue = new VertexPriorityQueue();
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        queue.add(v1,0f);
        queue.add(v3,3f);
        queue.add(v2,1.5f);
        queue.add(v4,1.6f);
        while (!queue.isEmpty()){
            System.out.println(queue.poll().vertex.getLabel());
        }

    }
}
