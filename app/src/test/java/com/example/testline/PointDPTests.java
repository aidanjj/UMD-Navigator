package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PointDPTests {
    @Test
    public void pointTests(){
        PointDP p1 = new PointDP();
        PointDP p2 = new PointDP(5f,10f);
        assertEquals(p1.getX(),0f,.001f);
        assertEquals(p1.getY(),0f,.001f);
        assertEquals(p2.getX(),5f,.001f);
        assertEquals(p2.getY(),10f,.001f);
    }
}
