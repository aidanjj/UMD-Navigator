package com.example.testline;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Vector;

public class UMDLocationManagerTests {
    @Test
    public void containsCorrectData(){
        UMDLocationManager locationManager = new UMDLocationManager();
        Vector<LocationData> list = locationManager.getLocationData();
        assertEquals(list.get(0).getVertex().getLabel(),"LSH");
        assertEquals(list.get(1).getVertex().getLabel(),"Ianni");
        assertEquals(list.get(2).getVertex().getLabel(),"Dining Center");
        assertEquals(list.get(3).getVertex().getLabel(),"LSH Lobby");
        assertEquals(list.get(4).getVertex().getLabel(),"Kirby Stairs");
    }
}
