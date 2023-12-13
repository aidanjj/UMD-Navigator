package com.example.testline;

import android.location.Location;

import java.util.HashMap;
import java.util.Vector;

public class UMDLocationManager {
    private Vector<LocationData> locationData = new Vector<>();

    /**
     * Initializes the location data at UMD.
     */
    public UMDLocationManager(){
        LocationData lsh = new LocationData("LSH",190,353);
        LocationData ianni = new LocationData("Ianni",129,475);
        LocationData dc = new LocationData("Dining Center", 295, 399);
        LocationData lshLobby= new LocationData("LSH Lobby",216,370);
        LocationData kirbyStairsUp = new LocationData("Kirby Stairs", "Go up ", 330,419);
        LocationData kirbyStairsDown = new LocationData( "Kirby Stairs", "Go down ", 330,419);
        LocationData kirby = new LocationData("Kirby Student Center",339,425);
        LocationData library = new LocationData("Library",401,225);
        LocationData kirbyCinaIntersection = new LocationData("Cina Intersection",355,396);
        LocationData cina = new LocationData("Cina",378,403);
        LocationData humanities2 = new LocationData("Humanities",414,393);
        LocationData humanities1 = new LocationData("Humanities Floor 1",430,396);
        LocationData humanitiesStairsDown = new LocationData("Humanities Stairs","Go down ",430,396);
        LocationData humanitiesStairsUp = new LocationData("Humanities Stairs","Go up ",430,396);
        LocationData underground = new LocationData("The Underground",340,444);
        LocationData undergroundStairsDown = new LocationData("The Underground Stairs", "Go down ", 340, 444);
        LocationData undergroundStairsUp = new LocationData("The Underground Stairs", "Go up ", 340, 444);
        LocationData montague = new LocationData("Montague Hall", 394,345);
        LocationData montagueIntersection = new LocationData("Montague Intersection",372,335);
        LocationData bohannon = new LocationData("Bohannon Hall",377,401);
        LocationData bohannonIntersection = new LocationData("Bohannon Intersection",355,393);
        LocationData weberMusicHall = new LocationData("Weber Music Hall",480,411);
        LocationData sportsCenter = new LocationData("Sports and Health Center",504,374);
        LocationData sportsCenterCorner = new LocationData("Sports and Health Center",520,345);
        LocationData gym = new LocationData("Gym",571,378);

        gym.addNeighbor(sportsCenterCorner.getVertex());
        sportsCenterCorner.addNeighbor(sportsCenter.getVertex());
        sportsCenter.addNeighbor(weberMusicHall.getVertex());
        weberMusicHall.addNeighbor(humanities1.getVertex());
        bohannon.addNeighbor(bohannonIntersection.getVertex());
        bohannonIntersection.addNeighbor(montagueIntersection.getVertex());
        bohannonIntersection.addNeighbor(kirbyCinaIntersection.getVertex());
        montagueIntersection.addNeighbor(kirby.getVertex());
        montagueIntersection.addNeighbor(kirbyCinaIntersection.getVertex());
        montagueIntersection.addNeighbor(bohannonIntersection.getVertex());
        montagueIntersection.addNeighbor(library.getVertex());
        montague.addNeighbor(montagueIntersection.getVertex());
        underground.addNeighbor(undergroundStairsUp.getVertex());
        undergroundStairsUp.addNeighbor(kirby.getVertex());
        undergroundStairsDown.addNeighbor(underground.getVertex());
        kirby.addNeighbor(undergroundStairsDown.getVertex());
        lsh.addNeighbor(lshLobby.getVertex());
        ianni.addNeighbor(lshLobby.getVertex());
        dc.addNeighbor(lshLobby.getVertex());
        dc.addNeighbor(kirbyStairsDown.getVertex());
        kirbyStairsUp.addNeighbor(dc.getVertex());
        kirbyStairsDown.addNeighbor(kirby.getVertex());
        kirby.addNeighbor(kirbyStairsUp.getVertex());
        library.addNeighbor(kirby.getVertex());
        kirbyCinaIntersection.addNeighbor(kirby.getVertex());
        kirbyCinaIntersection.addNeighbor(library.getVertex());
        kirbyCinaIntersection.addNeighbor(cina.getVertex());
        cina.addNeighbor(humanities2.getVertex());
        humanities2.addNeighbor(humanitiesStairsDown.getVertex());
        humanitiesStairsDown.addNeighbor(humanities1.getVertex());
        humanities1.addNeighbor(humanitiesStairsUp.getVertex());
        humanitiesStairsUp.addNeighbor(humanities2.getVertex());
        locationData.add(lsh);
        locationData.add(ianni);
        locationData.add(dc);
        locationData.add(lshLobby);
        locationData.add(kirbyStairsUp);
        locationData.add(kirbyStairsDown);
        locationData.add(kirby);
        locationData.add(library);
        locationData.add(kirbyCinaIntersection);
        locationData.add(cina);
        locationData.add(humanities2);
        locationData.add(humanities1);
        locationData.add(humanitiesStairsDown);
        locationData.add(humanitiesStairsUp);
        locationData.add(underground);
        locationData.add(undergroundStairsUp);
        locationData.add(undergroundStairsDown);
        locationData.add(montague);
        locationData.add(montagueIntersection);
        locationData.add(bohannon);
        locationData.add(bohannonIntersection);
        locationData.add(weberMusicHall);
        locationData.add(sportsCenter);
        locationData.add(sportsCenterCorner);
        locationData.add(gym);
    }

    /**
     * Returns the array containing the UMD location data
     * @return A Vector<LocationData> containing the UMD location data.
     */
    public Vector<LocationData> getLocationData(){
        return locationData;
    }
}
