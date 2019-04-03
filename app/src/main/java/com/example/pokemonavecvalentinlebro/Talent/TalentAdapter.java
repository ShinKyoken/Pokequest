package com.example.pokemonavecvalentinlebro.Talent;

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
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonViewModel;
import com.example.pokemonavecvalentinlebro.R;

import java.util.ArrayList;

public class TalentAdapter extends RecyclerView.Adapter<TalentAdapter.ViewHolder> {
    ArrayList<Talent> talents;
    PokemonViewModel pokemonViewModel;
    TalentViewModel talentViewModel;
    public TalentAdapter(ArrayList<Talent> talents, PokemonViewModel pokemonViewModel, TalentViewModel talentViewModel){
        this.talents = talents;
        this.pokemonViewModel=pokemonViewModel;
        this.talentViewModel=talentViewModel;
    }

    @Override
    public TalentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewTalent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.talent_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TalentAdapter.ViewHolder holder, int position){
        holder.nomTalent.setText(talents.get(position).getName());
        final Talent talent = talents.get(position);
        holder.display(talent);
        holder.setItemLongClickListener(new ItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final int pos) {
                if(talent.getId()!=1) {
                    new AlertDialog.Builder(view.getContext())
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Supprimer un type")
                            .setMessage("Etes vous sur de vouloir supprimer ce talent?\n Si vous le faites "+pokemonViewModel.getNbDeletePokemonTalent(talent.getId())+" pokemons seront supprimé !")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    pokemonViewModel.updateIdTalent1(talent.getId());
                                    pokemonViewModel.updateIdTalent2(talent.getId());
                                    //pokemonViewModel.updateIdTalentCache(talent.getId());
                                    pokemonViewModel.updateIdTalent1By2(1);
                                    pokemonViewModel.deleteIdTalent(1);
                                    talentViewModel.delete(talent);
                                    talents.remove(pos);
                                    notifyDataSetChanged();
                                }

                            })
                            .setNegativeButton("No", null)
                            .show();
                }
                else{
                    Toast.makeText(view.getContext(), "Vous ne pouvez pas supprimer le talent 'Aucun' !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return this.talents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener{
        public TextView nomTalent;
        ItemLongClickListener itemLongClickListener;
        private Talent current;

        public ViewHolder(final View typeView){
            super(typeView);
            nomTalent = typeView.findViewById(R.id.nomTalent);

            typeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("recyclerlog","click");
                    new AlertDialog.Builder(typeView.getContext()).setTitle("Infos").setMessage(current.getName()+" "+current.getId()).show();
                }
            });
            typeView.setOnLongClickListener(this);
        }
        public void display(Talent t){
            current=t;
            nomTalent.setText(t.getName());
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
