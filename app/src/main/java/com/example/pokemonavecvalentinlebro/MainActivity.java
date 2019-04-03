package com.example.pokemonavecvalentinlebro;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.pokemonavecvalentinlebro.Pokemon.GererPokemon;
import com.example.pokemonavecvalentinlebro.Talent.TalentViewModel;
import com.example.pokemonavecvalentinlebro.Type.GererType;
import com.example.pokemonavecvalentinlebro.Talent.GererTalent;
import com.example.pokemonavecvalentinlebro.Type.TypeViewModel;

public class MainActivity extends AppCompatActivity {
    private TalentViewModel talentViewModel;
    private TypeViewModel typeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
        typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);
    }

    public void lancerGererPokemon(View view) {

        if (talentViewModel.getNbElements() != 1 && typeViewModel.getNbElements() != 1) {
            Log.d("LancerIntent", "Lancer gerer pokemon");
            Intent intent = new Intent(this, GererPokemon.class);

            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Vous ne pouvez pas créer de pokemon sans talent ni type",
                    Toast.LENGTH_LONG).show();
        }
    }
    public void lancerGererTalent(View view) {
        Log.d("LancerIntent", "Lancer gerer talent");
        Intent intent = new Intent(this, GererTalent.class);

        startActivity(intent);
        finish();
    }

    public void lancerGererType(View view) {
        Log.d("LancerIntent", "Lancer gerer type");
        Intent intent = new Intent(this, GererType.class);

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
