package com.example.pokemonavecvalentinlebro;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pokemonavecvalentinlebro.Pokemon.Pokemon;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;
import com.example.pokemonavecvalentinlebro.Talent.TalentViewModel;
import com.example.pokemonavecvalentinlebro.Type.TypeViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level extends AppCompatActivity {
    private PokemonViewModel pokemonViewModel;
    private ArrayList<Integer> listeId;
    private TypeViewModel typeViewModel;
    private TalentViewModel talentViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        Intent intent = getIntent();
        if (intent != null) {

            pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
            typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);
            talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
            listeId = intent.getIntegerArrayListExtra("list");
        }
    }
    public void playNormal(View view){
        getPoke();
        SharedPreferences sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("life", 5);
        editor.apply();

        Intent myIntent = new Intent(this, Partie.class);

        startActivity(myIntent);
        finish();
    }
    public void playHard(View view){
        getPoke();
        SharedPreferences sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("life", 3);
        editor.apply();

        Intent myIntent = new Intent(this, Partie.class);

        startActivity(myIntent);
        finish();
    }
    public void playExtrem(View view){
        getPoke();
        SharedPreferences sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("life", 1);
        editor.apply();

        Intent myIntent = new Intent(this, Partie.class);

        startActivity(myIntent);
        finish();
    }

    public void getPoke(){
        int min = 0;
        int max = this.listeId.size();

        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min ) + min;

        Pokemon poke = pokemonViewModel.getPokemonById(this.listeId.get(nombreAleatoire));
        SharedPreferences sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("talent1", talentViewModel.selectName(poke.getIdTalent1() ));
        editor.putString("talent2",  talentViewModel.selectName(poke.getIdTalent2()));
        editor.putString("talentDW",  talentViewModel.selectName(poke.getIdTalentCache()));
        editor.putString("name", poke.getName());
        editor.putString("species", poke.getEspece());
        editor.putString("type1", typeViewModel.selectName(poke.getIdType1()));
        editor.putString("type2", typeViewModel.selectName(poke.getIdType2()));
        editor.putString("stadeEvo", poke.getStadeEvo());
        editor.putString("image", poke.getImage());
        editor.putString("pv", String.valueOf(poke.getPv()));
        editor.putString("atk", String.valueOf(poke.getAtk()));
        editor.putString("atksp", String.valueOf(poke.getAtkSpe()));
        editor.putString("def", String.valueOf(poke.getDef()));
        editor.putString("defsp", String.valueOf(poke.getDefSpe()));
        editor.putString("vit", String.valueOf(poke.getVit()));
        editor.putString("poids", String.valueOf(poke.getPoids()));
        editor.putString("taille", String.valueOf(poke.getTaille()));
        editor.putString("dex", String.valueOf(poke.getId()));




        editor.apply();
    }
    @Override
    public void finish(){
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK,intent);
        super.finish();
    }
}
