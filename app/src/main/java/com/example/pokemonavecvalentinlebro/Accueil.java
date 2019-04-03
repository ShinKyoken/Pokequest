package com.example.pokemonavecvalentinlebro;


import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;


public class Accueil extends AppCompatActivity {
    private PokemonViewModel pokemonViewModel;
    private ArrayList<Integer> listeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        pokemonViewModel.getmAllId().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(@Nullable List<Integer> id) {
                listeId = new ArrayList<>(id);
            }
        });
    }

    public void playGame(View view){
        if (this.listeId.size()!= 0){
        Intent myIntent = new Intent(this, Level.class);
            myIntent.putExtra("list", this.listeId);
            Log.d("test", "onCreate: "+listeId);

        startActivity(myIntent);
       }
        else{
            Toast.makeText(this, "Vous ne pouvez pas jouer sans pokemon",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void goPokedex(View view){
        Intent myIntent = new Intent(this, MainActivity.class);

        startActivity(myIntent);

    }


}
