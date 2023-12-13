package com.example.testline;
public class Edge {
    public Edge(){
        src = null;
        dst = null;
        weight = 0.0f;
    }
    public Edge(Vertex inSrc, Vertex inDst){
        src = inSrc;
        dst = inDst;
        weight = 1.0f;
    }
    public Edge(Vertex inSrc, Vertex inDst, float inWeight){
        src = inSrc;
        dst = inDst;
        weight = inWeight;
    }
    public void setWeight(float inWeight){
        weight = inWeight;
    }
    public float getWeight(){
        return weight;
    }
    public Vertex getSrc(){
        return src;
    }
    public Vertex getDst(){
        return dst;
    }
    private float weight;
    private Vertex src;
    private Vertex dst;
}
