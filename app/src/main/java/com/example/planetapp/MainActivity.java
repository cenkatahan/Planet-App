package com.example.planetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Planet> planets;
    private RecyclerView recyclerView;
    private PlanetAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private ArrayList<Planet> planetOnEnables;
    private int atPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        planetOnEnables = new ArrayList<>();

        planets = new ArrayList<>();
        setPlanetsOnScreen();

        recyclerView = findViewById(R.id.recyclerView_planets);
        layoutManager = new LinearLayoutManager(this);
        adapter = new PlanetAdapter(planets);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PlanetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                planetOnEnables.add(planets.get(position));
                atPosition = position;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), planetNames(), Toast.LENGTH_SHORT).show();
                //printSelectedPlanets();
            }
        });

    }

    public String planetNames(){
        String names = "";
        for(int i = 0; i < planetOnEnables.size(); i++){
            names += planetOnEnables.get(i).getPlanetName();
      }
        return names;
    }

    public void setPlanetsOnScreen(){
        planets.add(new Planet("MERCURY ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("VENUS ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("EARTH ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("MARS ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("JUPITER ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("SATURN ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("URANUS ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("NEPTUN ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
        planets.add(new Planet("PLUTO ", "Distance from Sun: 150 Million KM", "Diameter: 12750 KM", "Surface Gravity: 10 N/kg"));
    }
}