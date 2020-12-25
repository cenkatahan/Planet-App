package com.example.planetapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private ArrayList<Planet> planets;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView distance;
        public TextView diameter;
        public TextView gravity;
        public CheckBox checkBox;

        public PlanetViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_planet_name);
            distance = itemView.findViewById(R.id.textView_distance);
            diameter = itemView.findViewById(R.id.textView_diameter);
            gravity = itemView.findViewById(R.id.textView_gravity);
            checkBox = itemView.findViewById(R.id.checkBox_planet);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }
    }


    public PlanetAdapter(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_card_view, parent, false);
        PlanetViewHolder holder =  new PlanetViewHolder(view, listener);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planetAtPosition = planets.get(position);

        holder.name.setText(planetAtPosition.getPlanetName());
        holder.distance.setText(planetAtPosition.getDistanceFromSun());
        holder.diameter.setText(planetAtPosition.getDiameter());
        holder.gravity.setText(planetAtPosition.getGravity());



    }

    @Override
    public int getItemCount() {
        return planets.size();
    }




}
