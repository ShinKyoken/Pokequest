package com.example.pokemonavecvalentinlebro.Type;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;


import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pokemonavecvalentinlebro.ItemLongClickListener;
import com.example.pokemonavecvalentinlebro.Pokemon.FormulairePokemon;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;
import com.example.pokemonavecvalentinlebro.R;

import java.util.ArrayList;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {
    ArrayList<Type> types;
    TypeDAO dao;
    PokemonViewModel pokemonViewModel;
    TypeViewModel typeViewModel;

    public TypeAdapter(ArrayList<Type> types, PokemonViewModel pokemonViewModel, TypeViewModel typeViewModel){

        this.types = types;
        this.pokemonViewModel=pokemonViewModel;
        this.typeViewModel=typeViewModel;
    }

    @Override
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TypeAdapter.ViewHolder holder, int position){
        holder.nomType.setText(types.get(position).getName());
        final Type type = types.get(position);
        holder.display(type);
        holder.setItemLongClickListener(new ItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int pos) {
                if(type.getId()!=1) {
                    new AlertDialog.Builder(view.getContext())
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Supprimer un type")
                            .setMessage("Etes vous sur de vouloir supprimer ce type?\n Si vous le faites "+pokemonViewModel.getNbDeletePokemonType(type.getId())+" pokemons seront supprimé !")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pokemonViewModel.updateIdType1(type.getId());
                                    pokemonViewModel.updateIdType2(type.getId());
                                    pokemonViewModel.updateIdType1By2(1);
                                    pokemonViewModel.deleteIdType(1);
                                    typeViewModel.delete(type);
                                    types.remove(pos);
                                    notifyDataSetChanged();
                                }

                            })
                            .setNegativeButton("No", null)
                            .show();

                }
                else{
                    Toast.makeText(view.getContext(), "Vous ne pouvez pas supprimer le type 'Aucun' !",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return this.types.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        public TextView nomType;
        ItemLongClickListener itemLongClickListener;
        private Type current;

        public ViewHolder(final View typeView){
            super(typeView);
            nomType = typeView.findViewById(R.id.nomType);

            typeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("recyclerlog","click");
                    new AlertDialog.Builder(typeView.getContext()).setTitle("Infos").setMessage(current.getName()+" "+current.getId()).show();
                }
            });
            typeView.setOnLongClickListener(this);
        }
        public void display(Type t){
            current=t;
            nomType.setText(t.getName());
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