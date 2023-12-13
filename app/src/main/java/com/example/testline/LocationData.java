package com.example.testline;

import java.util.Vector;

public class LocationData {
    private Vertex vertex;
    private PointDP dpPoint;
    private String direction;
    private String name;
    private Vector<Vertex> neighbors = new Vector<>();
    public LocationData(){
        this.name = "";
        this.dpPoint = new PointDP();
        this.direction = "Continue past ";
        this.name = "";
    }

    /**
     * Initializes the data associated with the location
     * @param name Name of location
     * @param xPixel X pixel location on the original 750x750 image
     * @param yPixel Y pixel location on the original 750x750 image
     */
    public LocationData(String name, float xPixel, float yPixel){
        this.name = name;
        this.direction = "Continue past ";
        this.vertex = new Vertex(name);
        float xDP = xPixel*392/750;
        float yDP = yPixel*392/750;
        this.dpPoint = new PointDP(xDP,yDP);
    }

    /**
     * Initializes the data associated with the location
     * @param name Name of location
     * @param direction Directions given for a location, e.g. "Go down " or "Continue past ".
     * @param xPixel X pixel location on the original 750x750 image
     * @param yPixel Y pixel location on the original 750x750 image
     */
    public LocationData(String name, String direction, float xPixel, float yPixel){
        this.name = name;
        this.direction = direction;
        this.vertex = new Vertex(name);
        float xDP = xPixel*392/750;
        float yDP = yPixel*392/750;
        this.dpPoint = new PointDP(xDP,yDP);
    }
    public Vertex getVertex(){
        return vertex;
    }
    public PointDP getPoint(){
        return dpPoint;
    }
    public String getDirection(){
        return direction;
    }
    public String getName(){
        return name;
    }
    public Vector<Vertex> getNeighbors(){
        return neighbors;
    }

    /**
     * Adds locations that are accessible from (adjacent to) this location, e.g. Kirby Plaza connects to Kirby Stairs
     * @param v The vertex of the location adjacent to this location
     */
    public void addNeighbor(Vertex v){
        neighbors.add(v);
    }
}
