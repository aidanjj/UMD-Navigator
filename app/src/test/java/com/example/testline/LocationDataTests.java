package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Vector;

public class LocationDataTests {
    @Test
    public void createNeighbors(){
        LocationData location = new LocationData("UMD",750,750);
        Vertex v1 = new Vertex("v1");
        location.addNeighbor(v1);
        Vertex v2 = new Vertex("v2");
        location.addNeighbor(v2);
        Vector<Vertex> neighbors = location.getNeighbors();
        assertEquals(neighbors.get(0),v1);
        assertEquals(neighbors.get(1),v2);
    }
    @Test
    public void createLocationWithDirection(){
        LocationData location = new LocationData("UMD","Go sideways ",750,750);
        assertEquals(location.getName(),"UMD");
        assertEquals(location.getDirection(),"Go sideways ");
        assertEquals(location.getPoint().getX(),392,.001f);
        assertEquals(location.getPoint().getY(),392,.001f);
        assertEquals(location.getVertex().getLabel(),"UMD");
    }
    @Test
    public void createLocationWithoutDirection(){
        LocationData location = new LocationData("UMD",750,750);
        assertEquals(location.getName(),"UMD");
        assertEquals(location.getDirection(),"Continue past ");
        assertEquals(location.getPoint().getX(),392,.001f);
        assertEquals(location.getPoint().getY(),392,.001f);
        assertEquals(location.getVertex().getLabel(),"UMD");
    }
}
