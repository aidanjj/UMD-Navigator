package com.example.testline;
public class Vertex {
    public Vertex() {
        vLabel = "Unassigned";
    }

    public Vertex(String label) {
        vLabel = label;
    }
    public String getLabel() {
        return vLabel;
    }
    public void setVisited(boolean b){
        isVisited = b;
    }
    public boolean getVisited(){
        return isVisited;
    }
    private boolean isVisited = false;

    private String vLabel;
}