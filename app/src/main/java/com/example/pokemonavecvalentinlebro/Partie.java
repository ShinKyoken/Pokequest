package com.example.pokemonavecvalentinlebro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class Partie extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    EditText rep;
    int max=0;
    ProgressBar progressBar;
    int life;
    String evo;

    TextView dex;
    TextView type1;
    TextView type2;
    TextView talent1;
    TextView talent2;
    TextView talentDW;
    CheckBox checkBox;
    CheckBox checkBox2;
    CheckBox checkBox3;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        TextView espece = findViewById(R.id.mtvEspece);
        type1 = findViewById(R.id.mtvType1);
        type2 = findViewById(R.id.mtvType2);
        talent1 = findViewById(R.id.mtvTalent1);
        talent2 = findViewById(R.id.mtvTalent2);
        talentDW = findViewById(R.id.mtvTalentDW);
        TextView poids = findViewById(R.id.mtvPoids);
        TextView taille = findViewById(R.id.mtvTaille);
        TextView atk = findViewById(R.id.mtvATK);
        TextView def = findViewById(R.id.mtvDEF);
        TextView atks = findViewById(R.id.mtvATKSPE);
        TextView defs = findViewById(R.id.mtvDEFSPE);
        TextView vit = findViewById(R.id.mtvVIT);
        TextView pv = findViewById(R.id.mtvPV);
        dex = findViewById(R.id.mtvDex);
        checkBox= findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);

        rep=findViewById(R.id.Rep);

        sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);


        life = sharedPreferences.getInt("life", 0);
        progressBar.setMax(life);
        progressBar.setProgress(life-max);
        if (life==1) {
            espece.setText("XXXXXXXX");
        }
        else {
            espece.setText(sharedPreferences.getString("species", ""));
        }

        poids.setText(sharedPreferences.getString("poids", ""));
        taille.setText(sharedPreferences.getString("taille", ""));
        atk.setText(sharedPreferences.getString("atk", ""));
        def.setText(sharedPreferences.getString("def", ""));
        atks.setText(sharedPreferences.getString("atksp",""));
        defs.setText(sharedPreferences.getString("defsp", ""));
        vit.setText(sharedPreferences.getString("vit", ""));
        pv.setText(sharedPreferences.getString("pv", ""));

        evo = sharedPreferences.getString("stadeEvo","");

    }
    public void confirmRep(View view){
        sharedPreferences = getSharedPreferences("game", MODE_PRIVATE);
        final Intent myIntent = new Intent(this, Accueil.class);
        String Rep = sharedPreferences.getString("name", "");
        String ConfirmRep = rep.getText().toString();
        File imgFile = new  File(sharedPreferences.getString("image", ""));
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        if (Rep.toLowerCase().equals(ConfirmRep.toLowerCase())){
            imageView.setImageBitmap(myBitmap);
            new AlertDialog.Builder(view.getContext())
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Gagner")
                    .setMessage("Vous avez gagner, le pokemon etait bien "+ Rep)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(myIntent);
                            finish();
                        }

                    })
                    .show();

        }
        else{
            if (max<life) {
                max += 1;
                progressBar.setProgress(life - max);

                if (life == 5) {
                    if (max == 1) {
                        dex.setText(sharedPreferences.getString("dex", ""));
                    }
                    else if (max == 2) {
                        if (evo.equals("Base")) {
                            checkBox.setChecked(true);
                            checkBox2.setChecked(false);
                            checkBox3.setChecked(false);
                        } else if (evo.equals("Intermediaire")) {
                            checkBox.setChecked(false);
                            checkBox2.setChecked(true);
                            checkBox3.setChecked(false);
                        } else if (evo.equals(("Final"))) {
                            checkBox.setChecked(false);
                            checkBox2.setChecked(false);
                            checkBox3.setChecked(true);
                        }
                    }
                    else if (max == 3) {
                        talent1.setText(sharedPreferences.getString("talent1", ""));
                        talent2.setText(sharedPreferences.getString("talent2", ""));
                        talentDW.setText(sharedPreferences.getString("talentDW", ""));
                    }
                    else if (max == 4) {
                        type1.setText(sharedPreferences.getString("type1", ""));
                        type2.setText(sharedPreferences.getString("type2", ""));
                    }
                }
                else if (life == 3) {
                    if (max == 1) {
                        dex.setText(sharedPreferences.getString("dex", ""));
                    }
                    else if (max == 2) {
                        talent1.setText(sharedPreferences.getString("talent1", ""));
                        talent2.setText(sharedPreferences.getString("talent2", ""));
                        talentDW.setText(sharedPreferences.getString("talentDW", ""));

                    }

                }
            }
            if (max == life) {

                imageView.setImageBitmap(myBitmap);
                new AlertDialog.Builder(view.getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Perdu")
                        .setMessage("Vous avez perdu, le pokemon etait "+ Rep)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                startActivity(myIntent);
                                finish();
                            }

                        })
                        .show();

            }




        }
    }
    @Override
    public void finish(){
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK,intent);
        super.finish();
    }
}
