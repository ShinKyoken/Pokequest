package com.example.pokemonavecvalentinlebro.Talent;

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
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;
import com.example.pokemonavecvalentinlebro.R;

import java.util.ArrayList;
import java.util.List;

public class GererTalent extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TalentViewModel talentViewModel;
    private ArrayList<Talent> listeTalent;
    private PokemonViewModel pokemonViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_talent);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);

        talentViewModel.getmAllTalents().observe(this, new Observer<List<Talent>>() {
            @Override
            public void onChanged(@Nullable List<Talent> talents) {
                listeTalent = new ArrayList<>(talents);
                TalentAdapter adapter = new TalentAdapter(listeTalent,pokemonViewModel,talentViewModel);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    public void lancerAddTalent(View view) {
        Log.d("LancerIntent", "Lancer formulaire talent");
        Intent intent = new Intent(this, FormulaireTalent.class);

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
