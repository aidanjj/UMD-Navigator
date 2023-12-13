package com.example.testline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements Path_MVP_Interface.View {
    private View pathView;
    private View interfaceView;
    private ViewGroup mainLayout;
    private FrameLayout pathLayout;
    private LinearLayout interfaceLayout;
    private TextView directionsBox;
    private TextView distanceBox;
    private PathPresenter presenter = new PathPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mainLayout = findViewById(R.id.frame_layout);
        LayoutInflater inflater = LayoutInflater.from(this);
        this.interfaceView = inflater.inflate(R.layout.interface_layout,mainLayout,false);
        this.pathView = inflater.inflate(R.layout.path_layout, mainLayout, false);
        this.mainLayout.addView(pathView);
        this.mainLayout.addView(interfaceView);
        this.pathLayout = pathView.findViewById(R.id.graph_layout);
        this.directionsBox = interfaceView.findViewById(R.id.directions_box);
        this.directionsBox.setMovementMethod(new ScrollingMovementMethod());
        this.distanceBox = interfaceView.findViewById(R.id.distance_box);

        //presenter.findPath("Ianni","Superior Dining");




    }

    /**
     *
     * @param v
     */
    public void handleClick(View v){
        pathLayout.removeAllViews();
        EditText srcText = findViewById(R.id.starting_point_edit);
        EditText dstText = findViewById(R.id.destination_edit);
        String src = srcText.getText().toString();
        String dst = dstText.getText().toString();
        presenter.findPath(src,dst);
    }

    /**
     * Draws the path from the starting location to the destination given the data about the path
     * @param path The LinkedHashMap containing the vertices and screen positions associated with
     *             the shortest path.
     */
    @Override
    public void updatePaths(LinkedHashMap<Vertex,PointDP> path){
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        Boolean isFirstEntry = true;
        PointDP prevPoint = new PointDP(0,0);
        for (Map.Entry<Vertex,PointDP> entry : path.entrySet()) {

            if (isFirstEntry){
                prevPoint = entry.getValue();
                isFirstEntry = false;
            }
            else {
                View line = new LineView(this, entry.getValue().getX(), entry.getValue().getY(), prevPoint.getX(), prevPoint.getY());
                pathLayout.addView(line, layoutParams);
                prevPoint = entry.getValue();
            }
        }
    }

    /**
     * Updates the direction box with the given String containing the directions.
     * @param directions The String containing the directions.
     */
    @Override
    public void updateDirections(String directions){
        directionsBox.setText(directions);
    }

    /**
     * Updates the distance box given the distance between the starting location and the destination.
     * @param distance The distance between the starting location and the destination.
     */
    @Override
    public void updateDistance(Float distance){
        String newText = "Distance: " + String.format("%.2f",distance) + "m";
        distanceBox.setText(newText);
    }

}