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

    /**
     * Returns the vertex corresponding to a label.
     * @param label The label of the vertex.
     * @return The vertex that has the inputted label.
     */
    private Vertex getVertexFromString(String label){
        for (HashMap.Entry<Vertex,PointDP> entry : locationList.entrySet()){
            System.out.println(entry.getKey().getLabel());
            if (entry.getKey().getLabel().equalsIgnoreCase(label)){
                return entry.getKey();
            }
        }
        return new Vertex();
    }

    /**
     * Returns the total distance traversed on the fastest route.
     * @param path The LinkedHashMap containing the fastest route.
     * @return The total distance traversed.
     */
    private float getTotalDistance(LinkedHashMap<Vertex,PointDP> path){
        float distance = 0f;
        Vertex prevLocation = new Vertex();
        Boolean isFirstEntry = true;
        for (Map.Entry<Vertex,PointDP> entry : path.entrySet()){
            if (isFirstEntry){
                isFirstEntry = false;
            }
            else {
                distance += getDistance(prevLocation,entry.getKey());
            }
            prevLocation = entry.getKey();
        }
        return distance;
    }

    /**
     * Converts the HashMap returned by Dijkstra's algorithm into
     * a LinkedHashMap containing the fastest route to the destination.
     * @param traversalPaths The HashMap returns by Dijkstra.
     * @param dst The vertex of the destination location.
     * @return A LinkedHashMap containing the vertices and locations of each location visited on
     * the fastest route.
     */
    private LinkedHashMap<Vertex,PointDP> getPathAsList(HashMap<Vertex,Vertex> traversalPaths, Vertex dst){
        LinkedHashMap<Vertex,PointDP> path = new LinkedHashMap<>();
        path.put(dst,locationList.get(dst));
        Vertex curVertex = dst;
        while (traversalPaths.containsKey(curVertex)){
            Vertex prevVertex = traversalPaths.get(curVertex);
            path.put(prevVertex,locationList.get(prevVertex));
            curVertex = traversalPaths.get(curVertex);
        }
        return path;
    }

    /**
     * Returns the distance between two locations in meters.
     * @param v1 Vertex of the first location.
     * @param v2 Vertex of the second location.
     * @return The distance between the two location in meters.
     */
    private float getDistance(Vertex v1, Vertex v2){
        PointDP p1 = locationList.get(v1);
        PointDP p2 = locationList.get(v2);
        float distance = (float)(2.2704*Math.sqrt((p1.getX() - p2.getX())*(p1.getX() - p2.getX())+(p1.getY() - p2.getY())*(p1.getY() - p2.getY())));
        return distance;
    }

    /**
     * Initializes the graph using location data.
     */
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

    /**
     * Formats the directions as a string to update the View.
     * @param pathList The LinkedHashMap containing the vertices and locations of each location visited.
     * @return The directions formatted as a string.
     */
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
    public PathPresenter(Path_MVP_Interface.View view){
        initializeGraph();
        this.view = view;
    }
    @Override
    public void getLocationList(){
        String list = "";
        for (HashMap.Entry<Vertex,PointDP> entry : locationList.entrySet()){
            list = list.concat(entry.getKey().getLabel() + "\n");
        }
        view.showLocations(list);
    }
    /**
     * Obtains the shortest path between a source and a destination, then updates
     * the View.
     * @param srcLabel The label, or name, of the starting location.
     * @param dstLabel The label, or name, of the destination.
     */
    @Override
    public void findPath(String srcLabel, String dstLabel){
        Vertex src = getVertexFromString(srcLabel);
        Vertex dst = getVertexFromString(dstLabel);
        if (src.getLabel().equals("Unassigned")){
            view.updateDirections("Starting point not found.");
        }
        else if (dst.getLabel().equals("Unassigned")){
            view.updateDirections("Destination not found.");
        }
        else {
            AStarTraverse aStar = new AStarTraverse(g, locationList);
            HashMap<Vertex,Vertex> pathList = aStar.findPath(g,src,dst);

            //HashMap<Vertex, Vertex> pathList = dijkstra.searchPaths(g, src);
            LinkedHashMap<Vertex, PointDP> path = getPathAsList(pathList, dst);
            view.updatePaths(path);
            view.updateDirections(getDirectionString(path));
            view.updateDistance(getTotalDistance(path));
        }
    }
}
