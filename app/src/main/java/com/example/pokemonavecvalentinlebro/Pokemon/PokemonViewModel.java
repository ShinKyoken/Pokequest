package com.example.pokemonavecvalentinlebro.Pokemon;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pokemonavecvalentinlebro.Pokemon.Pokemon;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonRepository;

import java.util.List;


public class PokemonViewModel extends AndroidViewModel {
    private PokemonRepository mRepository;

    private LiveData<List<Pokemon>> mAllPokemons;
    private LiveData<List<Integer>> mAllId;
    private Pokemon mPokemon;

    public PokemonViewModel(Application application) {
        super(application);
        mRepository = new PokemonRepository(application);
        mAllPokemons = mRepository.getmAllPokemons();
        mAllId = mRepository.getmAllId();


    }

    public LiveData<List<Pokemon>> getmAllPokemons() {
        return mAllPokemons;
    }
    public LiveData<List<Integer>> getmAllId() { return mAllId; }

    public Pokemon getPokemonById(int i){
        return  mRepository.getPokemonById(i);
    }

    public void insert(Pokemon pokemon) {
        mRepository.insert(pokemon);
    }

    public void delete(Pokemon pokemon) {
        mRepository.delete(pokemon);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }

    public Integer getNbElements() {
        return mRepository.getNbElements();
    }

    public void deleteIdTalent(long id) {
        mRepository.deleteIdTalent(id);
    }

    public void deleteIdType(long id) {
        mRepository.deleteIdType(id);
    }

    public void updateIdTalent2(long id) {
        mRepository.updateIdTalent2(id);
    }

    public void updateIdTalentCache(long id) {
        mRepository.updateIdTalentCache(id);
    }

    public void updateIdTalent1By2(long id) {
        mRepository.updateIdTalent1By2(id);
    }

    public void updateIdTalent1ByCache(long id) {
        mRepository.updateIdTalent1ByCache(id);
    }

    public void updateIdType2(long id){
        mRepository.updateIdType2(id);
    }

    public void updateIdType1By2(long id){
        mRepository.updateIdType1By2(id);
    }

    public void updateIdTalent1(long id){
        mRepository.updateIdTalent1(id);
    }

    public void updateIdType1(long id){
        mRepository.updateIdType1(id);
    }

    public Integer getNbDeletePokemonTalent(long id) {
        return mRepository.getNbDeleteTalent(id);
    }

    public Integer getNbDeletePokemonType(long id) {
        return mRepository.getNbDeleteType(id);
    }
}
