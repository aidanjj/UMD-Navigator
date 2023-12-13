package com.example.testline;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class PathPresenter implements Path_MVP_Interface.Presenter{
    private Path_MVP_Interface.View view;
    private Graph g = new Graph();
    private Dijkstra dijkstra = new Dijkstra();
    private UMDLocationManager  locationManager = new UMDLocationManager();
    private HashMap<Vertex,PointDP> locationList = new HashMap<>();
    private Vertex getVertexFromString(String label){
        System.out.println("!" + label);
        for (HashMap.Entry<Vertex,PointDP> entry : locationList.entrySet()){
            System.out.println(entry.getKey().getLabel());
            if (entry.getKey().getLabel().equalsIgnoreCase(label)){
                return entry.getKey();
            }
        }
        return new Vertex();
    }
    private LinkedHashMap<Vertex,PointDP> getPathAsList(HashMap<Vertex,Vertex> dijkstraPaths, Vertex dst){
        LinkedHashMap<Vertex,PointDP> path = new LinkedHashMap<>();
        path.put(dst,locationList.get(dst));
        Vertex curVertex = dst;
        while (dijkstraPaths.containsKey(curVertex)){
            Vertex prevVertex = dijkstraPaths.get(curVertex);
            path.put(prevVertex,locationList.get(prevVertex));
            curVertex = dijkstraPaths.get(curVertex);
        }
        return path;
    }
    private float getDistance(Vertex v1, Vertex v2){
        PointDP p1 = locationList.get(v1);
        PointDP p2 = locationList.get(v2);
        float distance = (float)(1.1866*Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX())+(p1.getY() - p2.getY())*(p1.getY() - p2.getY())));
        return distance;
    }
    private void initializeGraph(){
        Vector<LocationData> locationData = locationManager.getLocationData();
        for (LocationData src : locationData){
            g.addVertex(src.getVertex());
            System.out.println(src.getVertex().getLabel());
            locationList.put(src.getVertex(),src.getPoint());
        }
        for (LocationData src : locationData){
            for (Vertex dst : src.getNeighbors()){
                LocationData dstData = new LocationData();
                for (LocationData data : locationData){
                    if (data.getVertex().getLabel().equals(dst.getLabel())){
                        dstData = data;
                    }
                }
                Edge newEdge = new Edge(src.getVertex(),dst);
                float distance = getDistance(src.getVertex(),dst);
                if (src.getDirection().equals("Continue past ") && dstData.getDirection().equals("Continue past ")){
                    g.addUndirEdge(newEdge);
                }
                else {
                    g.addDirEdge(newEdge);
                }
            }
        }
    }
    public PathPresenter(Path_MVP_Interface.View view){
        initializeGraph();
        this.view = view;
    }
    private String getDirectionString(LinkedHashMap<Vertex,PointDP> pathList){
        String directions = "";
        Vector<LocationData> locationData = locationManager.getLocationData();
        int count = 0;
        for (Map.Entry<Vertex,PointDP> entry : pathList.entrySet()){
            if (count == 0){
                directions = "Arrive at " + entry.getKey().getLabel() + "\n";
            }
            else if (count == pathList.size() - 1){
                directions = ("Depart from " + entry.getKey().getLabel() + "\n").concat(directions);
            }
            else {
                for (LocationData v : locationData) {
                    if (v.getVertex() == entry.getKey()) {
                        directions = (v.getDirection() + v.getVertex().getLabel() + "\n").concat(directions);
                    }
                }
            }
            ++count;
        }
        return directions;
    }
    @Override
    public void findPath(String srcLabel, String dstLabel){
        Vertex src = getVertexFromString(srcLabel);
        Vertex dst = getVertexFromString(dstLabel);
        System.out.println(srcLabel + "," + dstLabel + "," + src.getLabel() + "," + dst.getLabel() + "\n");
        HashMap<Vertex,Vertex> pathList = dijkstra.searchPaths(g,src);
        LinkedHashMap<Vertex,PointDP> path = getPathAsList(pathList,dst);
        view.updatePaths(path);
        view.updateDirections(getDirectionString(path));
    }
}
