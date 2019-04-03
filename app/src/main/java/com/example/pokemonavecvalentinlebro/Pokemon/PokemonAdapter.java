package com.example.pokemonavecvalentinlebro.Pokemon;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;


import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemonavecvalentinlebro.ItemLongClickListener;
import com.example.pokemonavecvalentinlebro.R;
import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Talent.TalentAdapter;
import com.example.pokemonavecvalentinlebro.Talent.TalentViewModel;
import com.example.pokemonavecvalentinlebro.Type.TypeViewModel;

import java.io.File;
import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {
     ArrayList<Pokemon> pokemons;
    public PokemonViewModel pokemonViewModel;
    public TalentViewModel talentViewModel;
    public TypeViewModel typeViewModel;

    public PokemonAdapter(ArrayList<Pokemon> pokemons, PokemonViewModel pokemonViewModel, TalentViewModel talentViewModel, TypeViewModel typeViewModel){
        this.pokemons = pokemons;
        this.pokemonViewModel = pokemonViewModel;
        this.typeViewModel = typeViewModel;
        this.talentViewModel = talentViewModel;
    }

    @Override
    public PokemonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewTalent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row, parent, false);
        return new ViewHolder(view, this.typeViewModel, this.talentViewModel);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.ViewHolder holder, final int position){
        holder.nomPokemon.setText(pokemons.get(position).getName());
        final Pokemon pokemon = pokemons.get(position);
        holder.display(pokemon);
        holder.setItemLongClickListener(new ItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int pos) {
                new AlertDialog.Builder(view.getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Supprimer un pokemon")
                        .setMessage("Etes vous sur de vouloir supprimer ce pokemon ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                pokemonViewModel.delete(pokemon);
                                pokemons.remove(position);
                                notifyDataSetChanged();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();

            }
        });
    }

    @Override
    public int getItemCount(){
        return this.pokemons.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        public TextView nomPokemon;
        public ImageView imagePokemon;
        ItemLongClickListener itemLongClickListener;
        private Pokemon current;
        private TypeViewModel typeViewModel;
        private TalentViewModel talentViewModel;

        public ViewHolder(final View typeView, final TypeViewModel typeViewModel, final TalentViewModel talentViewModel){
            super(typeView);
            this.typeViewModel=typeViewModel;
            this.talentViewModel=talentViewModel;
            nomPokemon = typeView.findViewById(R.id.nomPokemon);
            imagePokemon = typeView.findViewById(R.id.imageViewPokemon);
            typeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO
                    Log.d("recyclerlog","click");
                    new AlertDialog.Builder(typeView.getContext())
                            .setTitle("Pokemon").setMessage("N°Dex : "+ current.getId() + "\n" +
                                                            "Nom : "+ current.getName() + "\n" +
                                                            "Stade évolution : " + current.getStadeEvo() + "\n" +
                                                            "Poids : " + current.getPoids() + " Kg \n" +
                                                            "Taille : " + current.getTaille() + " m \n" +
                                                            "Espèce : " + current.getEspece() + "\n" +
                                                            "Type 1 : " + typeViewModel.selectName(current.getIdType1()) + "\n" +
                                                            "Type 2 : " + typeViewModel.selectName(current.getIdType2()) + "\n" +
                                                            "Talent 1 : " + talentViewModel.selectName(current.getIdTalent1()) + "\n" +
                                                            "Talent 2 : " + talentViewModel.selectName(current.getIdTalent2()) + "\n" +
                                                            "Talent caché : " + talentViewModel.selectName(current.getIdTalentCache()) + "\n" +
                                                            "Point de vie : " + current.getPv() + "\n" +
                                                            "Attaque : " + current.getAtk() + "\n" +
                                                            "Attaque spéciale : " + current.getAtkSpe() + "\n" +
                                                            "Défense : " + current.getDef() + "\n" +
                                                            "Défense spéciale : " + current.getDefSpe() + "\n" +
                                                            "Vitesse : " + current.getVit() + "\n" +
                                                            "test" + current.getImage()).show();


                }
            });
            typeView.setOnLongClickListener(this);
        }
        public void display(Pokemon t){
            current=t;
            nomPokemon.setText(t.getName());
            File imgFile = new  File(t.getImage());
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imagePokemon.setImageBitmap(myBitmap);
        }

        public void setItemLongClickListener(ItemLongClickListener i){
            this.itemLongClickListener=i;
        }

        @Override
        public boolean onLongClick(View v){
            this.itemLongClickListener.onItemLongClick(v,getLayoutPosition());
            return false;
        }



    }
}
