package com.example.testline;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

public class Path_MVP_Interface {
    interface View {
        void updatePaths(LinkedHashMap<Vertex,PointDP> path);
        void updateDirections(String directions);
        void updateDistance(Float distance);
    }
    interface Presenter{
        void findPath(String srcLabel, String dstLabel);
    }
}
