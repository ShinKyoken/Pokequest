package com.example.pokemonavecvalentinlebro.Type;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.pokemonavecvalentinlebro.R;

public class FormulaireType extends AppCompatActivity {
    private TypeViewModel typeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_type);
        typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);

    }

    public void ajouterType(View view){
        EditText etType = findViewById(R.id.etName);
        Type t = new Type(etType.getText().toString());
        typeViewModel.insert(t);
        Log.d("LancerIntent", "Sauvegarde et lancement de Gerertype");
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
