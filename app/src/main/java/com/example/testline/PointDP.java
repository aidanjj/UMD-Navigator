package com.example.testline;

public class PointDP {
    private float x;
    private float y;
    public PointDP(){
        this.x = 0;
        this.y = 0;
    }

    /**
     * Initializes the point containing the location on an image in dp.
     * @param x The x location in dp.
     * @param y The y location in dp.
     */
    public PointDP(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
}
