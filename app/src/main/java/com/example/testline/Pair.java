package com.example.testline;
public class Pair {
    public Pair(){
        vertex = new Vertex();
        distance = 0f;
    }
    public Pair(Vertex v, Float d){
        vertex = v;
        distance = d;
    }
    public Vertex vertex;
    public Float distance = 0f;
}
