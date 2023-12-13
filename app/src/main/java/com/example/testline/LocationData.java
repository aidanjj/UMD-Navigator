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
    public LocationData(String name, float xPixel, float yPixel){
        this.name = name;
        this.direction = "Continue past ";
        this.vertex = new Vertex(name);
        float xDP = xPixel*392/750;
        float yDP = yPixel*392/750;
        this.dpPoint = new PointDP(xDP,yDP);
    }
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
    public void addNeighbor(Vertex v){
        neighbors.add(v);

    }
}
