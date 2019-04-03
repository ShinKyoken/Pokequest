package com.example.pokemonavecvalentinlebro.Type;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.example.pokemonavecvalentinlebro.MainActivity;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;
import com.example.pokemonavecvalentinlebro.R;

import java.util.ArrayList;
import java.util.List;

public class GererType extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TypeViewModel typeViewModel;
    private ArrayList<Type> listeType;
    private PokemonViewModel pokemonViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_type);

        Log.d("LancerIntent", "Lancement de gérer type");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);
        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);

        typeViewModel.getmAllTypes().observe(this, new Observer<List<Type>>() {
            @Override
            public void onChanged(@Nullable List<Type> types) {
                listeType = new ArrayList<>(types);
                TypeAdapter adapter = new TypeAdapter(listeType, pokemonViewModel, typeViewModel);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public Activity getActivity(){
        return this;
    }

    public void lancerAddType(View view) {
        Log.d("LancerIntent", "Lancer formulaire type");
        Intent intent = new Intent(this, FormulaireType.class);
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
