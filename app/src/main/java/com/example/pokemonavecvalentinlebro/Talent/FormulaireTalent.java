package com.example.pokemonavecvalentinlebro.Talent;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.pokemonavecvalentinlebro.R;

public class FormulaireTalent extends AppCompatActivity {

    private TalentViewModel talentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_talent);
        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
    }

    public void ajouterTalent(View view){
        EditText etTalent = findViewById(R.id.etName);
        Talent t = new Talent(etTalent.getText().toString());
        talentViewModel.insert(t);
        Log.d("LancerIntent", "Sauvegarde et lancement de Gerertype");
        Intent intent = new Intent(this, GererTalent.class);

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
