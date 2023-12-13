package com.example.testline;
import java.util.HashMap;
import java.util.Vector;

public class VertexPriorityQueue {
    private Vector<Pair> queue = new Vector<>();
    public void add(Vertex v, Float newDistance){
        int l = 0;
        int r = queue.size() - 1;
        while (l <= r){
            int guess = (l + r)/2;
            if (queue.get(guess).distance <= newDistance){
                l = guess + 1;
            }
            else {
                r = guess - 1;
            }
        }
        Pair newPair = new Pair(v, newDistance);
        queue.insertElementAt(newPair,l);
    }
    public Pair poll(){
        Pair result = queue.get(0);
        queue.remove(0);
        return result;
    }
    public Pair peek(){
        return queue.get(0);
    }
    public Boolean isEmpty(){
        return queue.isEmpty();
    }

    public Integer size(){
        return queue.size();
    }
    public void dequeue(){
        queue.remove(0);
    }
}
