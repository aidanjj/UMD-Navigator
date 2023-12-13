package com.example.testline;

import android.location.Location;

import java.util.HashMap;
import java.util.Vector;

public class UMDLocationManager {
    private Vector<LocationData> locationData = new Vector<>();
    public UMDLocationManager(){
        LocationData lsh = new LocationData("LSH",190,353);
        LocationData ianni = new LocationData("Ianni",129,475);
        LocationData dc = new LocationData("Dining Center", 295, 399);
        LocationData lshLobby= new LocationData("LSH Lobby",216,370);
        LocationData kirbyStairsUp = new LocationData("Kirby Stairs", "Go up ", 330,419);
        LocationData kirbyStairsDown = new LocationData( "Kirby Stairs", "Go down ", 330,419);
        LocationData kirby = new LocationData("Kirby Student Center",339,425);
        LocationData library = new LocationData("Library",401,225);
        lsh.addNeighbor(lshLobby.getVertex());
        ianni.addNeighbor(lshLobby.getVertex());
        dc.addNeighbor(lshLobby.getVertex());
        dc.addNeighbor(kirbyStairsDown.getVertex());
        kirbyStairsUp.addNeighbor(dc.getVertex());
        kirbyStairsDown.addNeighbor(kirby.getVertex());
        kirby.addNeighbor(kirbyStairsUp.getVertex());
        library.addNeighbor(kirby.getVertex());
        locationData.add(lsh);
        locationData.add(ianni);
        locationData.add(dc);
        locationData.add(lshLobby);
        locationData.add(kirbyStairsUp);
        locationData.add(kirbyStairsDown);
        locationData.add(kirby);
        locationData.add(library);
    }
    public Vector<LocationData> getLocationData(){
        return locationData;
    }
}
