package com.example.pokemonavecvalentinlebro.Pokemon;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.pokemonavecvalentinlebro.MainActivity;
import com.example.pokemonavecvalentinlebro.R;
import com.example.pokemonavecvalentinlebro.Talent.TalentViewModel;
import com.example.pokemonavecvalentinlebro.Type.TypeViewModel;

import java.util.ArrayList;
import java.util.List;

public class GererPokemon extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonViewModel pokemonViewModel;
    private TypeViewModel typeViewModel;
    private TalentViewModel talentViewModel;
    private ArrayList<Pokemon> listePokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_pokemon);

        Log.d("LancerIntent", "Lancement de gérer pokemon");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);
        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);

        pokemonViewModel.getmAllPokemons().observe(this, new Observer<List<Pokemon>>() {
            @Override
            public void onChanged(@Nullable List<Pokemon> pokemons) {
                listePokemon = new ArrayList<>(pokemons);
                PokemonAdapter adapter = new PokemonAdapter(listePokemon,pokemonViewModel,talentViewModel,typeViewModel);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public void lancerAddPokemon(View view) {
        Log.d("LancerIntent", "Lancer formulaire pokemon");
        Intent intent = new Intent(this, FormulairePokemon.class);

        startActivity(intent);
        finish();
    }

    public void retour(View view) {
        Log.d("LancerIntent", "Lancer retour");
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
    }
    @Override
    public void finish(){
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK,intent);
        super.finish();
    }
}
