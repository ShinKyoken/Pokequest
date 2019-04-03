package com.example.pokemonavecvalentinlebro.Pokemon;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemonavecvalentinlebro.R;
import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Talent.TalentViewModel;
import com.example.pokemonavecvalentinlebro.Type.Type;
import com.example.pokemonavecvalentinlebro.Type.TypeViewModel;
import com.example.pokemonavecvalentinlebro.Type.SpinAdapterType;
import com.example.pokemonavecvalentinlebro.Talent.SpinAdapterTalent;

import java.util.ArrayList;
import java.util.List;

public class FormulairePokemon extends AppCompatActivity {

    private static final int RESULT_LOAD_IMAGE = 0 ;
    private TalentViewModel talentViewModel;
    private TypeViewModel typeViewModel;
    private PokemonViewModel pokemonViewModel;
    private ArrayList<Talent> listeTalent;
    private ArrayList<Type> listeType;
    private Spinner spinnerTalent1, spinnerTalent2, spinnerTalentCache, spinnerType1, spinnerType2, spinnerEvo;
    private SpinAdapterTalent adapterTalent1, adapterTalent2, adapterTalentCache;
    private SpinAdapterType adapterType1, adapterType2;
    private long idTalent1,idTalent2,idTalent3,idType1,idType2;
    private ArrayList<Integer> listeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_pokemon);

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        pokemonViewModel.getmAllId().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(@Nullable List<Integer> idP) {
                listeId = new ArrayList<>(idP);
            }
        });

        this.spinnerEvo = findViewById(R.id.spinnerStadeEvo);
        ArrayList<String> liste = new ArrayList<>();
        liste.add("Base");
        liste.add("Intermediaire");
        liste.add("Final");
        ArrayAdapter<String> adapt = new ArrayAdapter<>(FormulairePokemon.this,
                android.R.layout.simple_spinner_item,
                liste);
        this.spinnerEvo.setAdapter(adapt);

        Button buttonLoadImage = findViewById(R.id.buttonImage);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);

        talentViewModel = ViewModelProviders.of(this).get(TalentViewModel.class);
        talentViewModel.getmAllTalents().observe(this, new Observer<List<Talent>>() {
            @Override
            public void onChanged(@Nullable List<Talent> talents) {
                listeTalent = new ArrayList<>(talents);

                // ADAPTER TALENT 1
                adapterTalent1 = new SpinAdapterTalent(FormulairePokemon.this,
                        android.R.layout.simple_spinner_item,
                        listeTalent);
                spinnerTalent1 = findViewById(R.id.spinnerTalent1);
                spinnerTalent1.setAdapter(adapterTalent1);

                spinnerTalent1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int position, long id) {
                        // Here you get the current item (a User object) that is selected by its position
                        Talent talent = adapterTalent1.getItem(position);
                        idTalent1 = talent.getId();
                        // Here you can do the action you want to...
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapter) {
                    }
                });

                // ADAPTER TALENT 2
                adapterTalent2 = new SpinAdapterTalent(FormulairePokemon.this,
                        android.R.layout.simple_spinner_item,
                        listeTalent);
                spinnerTalent2 = findViewById(R.id.spinnerTalent2);
                spinnerTalent2.setAdapter(adapterTalent2);

                spinnerTalent2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int position, long id) {
                        // Here you get the current item (a User object) that is selected by its position
                        Talent talent = adapterTalent2.getItem(position);
                        idTalent2 = talent.getId();
                        // Here you can do the action you want to...
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapter) {
                    }
                });

                // ADAPTER TALENT CACHE
                adapterTalentCache = new SpinAdapterTalent(FormulairePokemon.this,
                        android.R.layout.simple_spinner_item,
                        listeTalent);
                spinnerTalentCache = findViewById(R.id.spinnerTalentCache);
                spinnerTalentCache.setAdapter(adapterTalentCache);

                spinnerTalentCache.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int position, long id) {
                        // Here you get the current item (a User object) that is selected by its position
                        Talent talent = adapterTalentCache.getItem(position);
                        idTalent3 = talent.getId();
                        // Here you can do the action you want to...
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapter) {
                    }
                });


            }
        });

        typeViewModel = ViewModelProviders.of(this).get(TypeViewModel.class);
        typeViewModel.getmAllTypes().observe(this, new Observer<List<Type>>() {
            @Override
            public void onChanged(@Nullable List<Type> types) {
                listeType = new ArrayList<>(types);

                // ADAPTER TYPE 1
                adapterType1 = new SpinAdapterType(FormulairePokemon.this,
                        android.R.layout.simple_spinner_item,
                        listeType);
                spinnerType1 = findViewById(R.id.spinnerType1);
                spinnerType1.setAdapter(adapterType1);

                spinnerType1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int position, long id) {
                        // Here you get the current item (a User object) that is selected by its position
                        Type type = adapterType1.getItem(position);
                        idType1 = type.getId();
                        // Here you can do the action you want to...
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapter) {
                    }



        /*adapterTalent = new SpinAdapterTalent(FormulairePokemon.this,
                android.R.layout.simple_spinner_item,
                listeTalent);
        mySpinner = findViewById(R.id.spinnerTalent1);
        mySpinner.setAdapter(adapterTalent);*/


                });

                adapterType2 = new SpinAdapterType(FormulairePokemon.this,
                        android.R.layout.simple_spinner_item,
                        listeType);
                spinnerType2 = findViewById(R.id.spinnerType2);
                spinnerType2.setAdapter(adapterType2);

                spinnerType2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view,
                                               int position, long id) {
                        // Here you get the current item (a User object) that is selected by its position
                        Type type = adapterType1.getItem(position);
                        idType2 = type.getId();
                        // Here you can do the action you want to...
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapter) {
                    }


                });


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            EditText et =  findViewById(R.id.etImage);
            et.setText(picturePath);
        }
    }

    public void ajouterPokemon(View view) {
        Log.d("LancerIntent", "talent 1 :" + String.valueOf(idTalent1));
        Log.d("LancerIntent", "talent 2 : " + String.valueOf(idTalent2));
        Log.d("LancerIntent", "talent 3 : " + String.valueOf(idTalent3));

        EditText etImage = findViewById(R.id.etImage);
        String image = etImage.getText().toString();

        EditText etDex = findViewById(R.id.etDex);
        String dex = etDex.getText().toString();

        EditText etNom = findViewById(R.id.etName);
        String nom = etNom.getText().toString();

        String evo = (String) this.spinnerEvo.getSelectedItem();

        EditText etPoids = findViewById(R.id.etPoids);
        String strPoids = etPoids.getText().toString();

        EditText etTaille = findViewById(R.id.etTaille);
        String strTaille = etTaille.getText().toString();

        EditText etEspece = findViewById(R.id.etEspece);
        String espece = etEspece.getText().toString();

        long type1 = idType1;
        long type2 = idType2;
        long talent1 = idTalent1;
        long talent2 = idTalent2;
        long talentCache = idTalent3;

        EditText etPv = findViewById(R.id.etPV);
        String strPv = etPv.getText().toString();

        EditText etAtk = findViewById(R.id.etATK);
        String strAtk = etAtk.getText().toString();

        EditText etAtkSpe = findViewById(R.id.etATKSPE);
        String strAtkSpe = etAtkSpe.getText().toString();

        EditText etDef = findViewById(R.id.etDEF);
        String strDef = etDef.getText().toString();

        EditText etDefSpe = findViewById(R.id.etDEFSPE);
        String strDefSpe = etDefSpe.getText().toString();

        EditText etVit = findViewById(R.id.etVIT);
        String strVit = etVit.getText().toString();

        if(!(image.equals("") || nom.equals("") || strPv.equals("") || strAtk.equals("") || strAtkSpe.equals("") || strDef.equals("") || strDefSpe.equals("") || strVit.equals("") || strPoids.equals("") || strTaille.equals("") || espece.equals("") || dex.equals(""))){
            int id = Integer.parseInt(dex);
            int pv = Integer.parseInt(strPv);
            int atk = Integer.parseInt(strAtk);
            int atkSpe = Integer.parseInt(strAtkSpe);
            int def = Integer.parseInt(strDef);
            int defSpe = Integer.parseInt(strDefSpe);
            int vit = Integer.parseInt(strVit);
            float poids = Float.parseFloat(strPoids);
            float taille = Float.parseFloat(strTaille);

            if(!this.listeId.contains(id)) {
                if (type1 != 1 && talent1 != 1) {
                    Pokemon pokemon = new Pokemon(id, image, type1, type2, talent1, talent2, talentCache, nom, espece, evo, pv, atk, atkSpe, def, defSpe, vit, poids, taille);
                    Log.d("LancerIntent", "Sauvegarde et lancement de GererPokemon");

                    pokemonViewModel.insert(pokemon);

                    Log.d("LancerIntent", "Sauvegarde et lancement de GererPokemon");
                    Intent intent = new Intent(this, GererPokemon.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(FormulairePokemon.this, "Vous ne pouvez pas selectionner 'Aucun' pour le talent1 et le type1",
                            Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(FormulairePokemon.this, "Ce numéro de DEX est déjà utilisé pour un autre pokemon !",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(FormulairePokemon.this, "Vous devez remplir tout les champs !",
                    Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void finish(){
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK,intent);
        super.finish();
    }
}





