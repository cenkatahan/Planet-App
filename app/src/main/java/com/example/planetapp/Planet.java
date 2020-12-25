package com.example.planetapp;

import android.view.View;
import android.widget.CheckBox;

public class Planet {
    private String planetName;
    private String distanceFromSun;
    private String diameter;
    private String gravity;

    public Planet(String planetName, String distanceFromSun, String diameter, String gravity) {
        this.planetName = planetName;
        this.distanceFromSun = distanceFromSun;
        this.diameter = diameter;
        this.gravity = gravity;
    }


    public String getPlanetName() {
        return planetName;
    }

    public String getDistanceFromSun() {
        return distanceFromSun;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }
}
