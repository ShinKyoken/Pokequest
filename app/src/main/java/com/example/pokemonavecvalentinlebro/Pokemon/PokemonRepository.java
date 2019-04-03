package com.example.pokemonavecvalentinlebro.Pokemon;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pokemonavecvalentinlebro.Databaser;
import com.example.pokemonavecvalentinlebro.Pokemon.Pokemon;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonDAO;

import java.util.List;



public class PokemonRepository {
    private PokemonDAO mPokemonDao;
    private LiveData<List<Pokemon>> mAllPokemons;
    private LiveData<List<Integer>> mAllId;


    PokemonRepository(Application application){
        Databaser db = Databaser.getInstance(application);
        mPokemonDao=db.pokemonDAO();
        mAllPokemons=mPokemonDao.getAllPokemon();
        mAllId=mPokemonDao.getAllId();

    }

    public LiveData<List<Pokemon>> getmAllPokemons(){
        return mAllPokemons;
    }
    public LiveData<List<Integer>> getmAllId(){ return mAllId;}

    public Pokemon getPokemonById(int i ){
        try{
            return new getPokemonByIdAsyncTask(mPokemonDao).execute(i).get();
        }catch (Exception e){
            Log.d("mesTests","Problème getPokemonById");
        }
        return null;
    }
    private static class getPokemonByIdAsyncTask extends AsyncTask<Integer,Void,Pokemon>{
        private PokemonDAO mAsyncTaskDao;

        getPokemonByIdAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Pokemon doInBackground(final Integer... params){
            return mAsyncTaskDao.getPokemonById(params[0]);
        }
    }


    public void insert(Pokemon pokemon){
        new insertAsyncTask(mPokemonDao).execute(pokemon);
    }

    private static class insertAsyncTask extends AsyncTask<Pokemon,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        insertAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Pokemon... params){
            mAsyncTaskDao.insertPokemon(params[0]);
            return null;
        }
    }

    public void delete(Pokemon pokemon){
        new deleteAsyncTask(mPokemonDao).execute(pokemon);
    }

    private static class deleteAsyncTask extends AsyncTask<Pokemon,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        deleteAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Pokemon... params){
            mAsyncTaskDao.deletePokemon(params[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsyncTask(mPokemonDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        deleteAllAsyncTask(PokemonDAO pokemonDAO){
            mAsyncTaskDao = pokemonDAO;
        }

        @Override
        protected Void doInBackground(Void... params){
            mAsyncTaskDao.deleteAllPokemon();
            return null;
        }
    }

    public Integer getNbElements(){
        try{
            return new getNbElementsAsync(mPokemonDao).execute().get();
        }catch (Exception e){
            Log.d("mesTests","Problème getNbElements");
        }
        return null;
    }

    private static class getNbElementsAsync extends AsyncTask<Void,Void,Integer>{
        private PokemonDAO mPokemonDao;

        getNbElementsAsync(PokemonDAO pokemonDAO){
            mPokemonDao=pokemonDAO;
        }

        @Override
        protected Integer doInBackground(Void... params){
            return mPokemonDao.nbElements();
        }
    }

    public void deleteIdTalent(long id){
        new deleteIdTalentAsyncTask(mPokemonDao).execute(id);
    }

    private static class deleteIdTalentAsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        deleteIdTalentAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.deleteIdTalent(params[0]);
            return null;
        }
    }

    public void deleteIdType(long id){
        new deleteIdTypeAsyncTask(mPokemonDao).execute(id);
    }

    private static class deleteIdTypeAsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        deleteIdTypeAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.deleteIdType(params[0]);
            return null;
        }
    }

    public void updateIdTalent2(long id){
        new updateIdTalent2AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdTalent2AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdTalent2AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdTalent2(params[0]);
            return null;
        }
    }

    public void updateIdTalentCache(long id){
        new updateIdTalentCacheAsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdTalentCacheAsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdTalentCacheAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdTalentCache(params[0]);
            return null;
        }
    }

    public void updateIdTalent1By2(long id){
        new updateIdTalent1By2AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdTalent1By2AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdTalent1By2AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdTalent1By2(params[0]);
            return null;
        }
    }

    public void updateIdTalent1ByCache(long id){
        new updateIdTalent1ByCacheAsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdTalent1ByCacheAsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdTalent1ByCacheAsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdTalent1ByCache(params[0]);
            return null;
        }
    }

    public void updateIdType2(long id){
        new updateIdType2AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdType2AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdType2AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdType2(params[0]);
            return null;
        }
    }

    public void updateIdType1By2(long id){
        new updateIdType1By2AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdType1By2AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdType1By2AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdType1By2(params[0]);
            return null;
        }
    }

    public void updateIdTalent1(long id){
        new updateIdTalent1AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdTalent1AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdTalent1AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdTalent1(params[0]);
            return null;
        }
    }

    public void updateIdType1(long id){
        new updateIdType1AsyncTask(mPokemonDao).execute(id);
    }

    private static class updateIdType1AsyncTask extends AsyncTask<Long,Void,Void>{
        private PokemonDAO mAsyncTaskDao;

        updateIdType1AsyncTask(PokemonDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Long... params){
            mAsyncTaskDao.updateIdType1(params[0]);
            return null;
        }
    }

    public Integer getNbDeleteTalent(long id){
        try{
            return new getNbDeleteTalentAsync(mPokemonDao).execute(id).get();
        }catch (Exception e){
            Log.d("mesTests","Problème getNbDelete");
        }
        return null;
    }

    private static class getNbDeleteTalentAsync extends AsyncTask<Long,Void,Integer>{
        private PokemonDAO mPokemonDao;

        getNbDeleteTalentAsync(PokemonDAO pokemonDAO){
            mPokemonDao=pokemonDAO;
        }

        @Override
        protected Integer doInBackground(Long... params){
            return mPokemonDao.nbDeletePokemonTalent(params[0]);
        }
    }


    public Integer getNbDeleteType(long id){
        try{
            return new getNbDeleteTypeAsync(mPokemonDao).execute(id).get();
        }catch (Exception e){
            Log.d("mesTests","Problème getNbDelete");
        }
        return null;
    }

    private static class getNbDeleteTypeAsync extends AsyncTask<Long,Void,Integer>{
        private PokemonDAO mPokemonDao;

        getNbDeleteTypeAsync(PokemonDAO pokemonDAO){
            mPokemonDao=pokemonDAO;
        }

        @Override
        protected Integer doInBackground(Long... params){
            return mPokemonDao.nbDeletePokemonType(params[0]);
        }
    }







}
