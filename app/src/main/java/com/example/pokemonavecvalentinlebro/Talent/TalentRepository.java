package com.example.pokemonavecvalentinlebro.Talent;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pokemonavecvalentinlebro.Databaser;
import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Talent.TalentDAO;
import com.example.pokemonavecvalentinlebro.Type.TypeDAO;
import com.example.pokemonavecvalentinlebro.Type.TypeRepository;

import java.util.List;



public class TalentRepository {
    private TalentDAO mTalentDao;
    private LiveData<List<Talent>> mAllTalents;

    TalentRepository(Application application){
        Databaser db = Databaser.getInstance(application);
        mTalentDao=db.talentDAO();
        mAllTalents=mTalentDao.getAllTalent();
    }

    LiveData<List<Talent>> getmAllTalents(){
        return mAllTalents;
    }

    public void insert(Talent talent){
        new insertAsyncTask(mTalentDao).execute(talent);
    }

    private static class insertAsyncTask extends AsyncTask<Talent,Void,Void>{
        private TalentDAO mAsyncTaskDao;

        insertAsyncTask(TalentDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Talent... params){
            mAsyncTaskDao.insertTalent(params[0]);
            return null;
        }
    }

    public void delete(Talent talent){
        new deleteAsyncTask(mTalentDao).execute(talent);
    }

    private static class deleteAsyncTask extends AsyncTask<Talent,Void,Void>{
        private TalentDAO mAsyncTaskDao;

        deleteAsyncTask(TalentDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Talent... params){
            mAsyncTaskDao.deleteTalent(params[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsyncTask(mTalentDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private TalentDAO mAsyncTaskDao;

        deleteAllAsyncTask(TalentDAO talentDAO){
            mAsyncTaskDao = talentDAO;
        }

        @Override
        protected Void doInBackground(Void... params){
            mAsyncTaskDao.deleteAllTalent();
            return null;
        }
    }

    public Integer getNbElements(){
        try{
            return new getNbElementsAsync(mTalentDao).execute().get();
        }catch (Exception e){
            Log.d("mesTests","Problème getNbElements");
        }
        return null;
    }

    private static class getNbElementsAsync extends AsyncTask<Void,Void,Integer>{
        private TalentDAO mTalentDao;

        getNbElementsAsync(TalentDAO talentDAO){
            mTalentDao=talentDAO;
        }

        @Override
        protected Integer doInBackground(Void... params){
            return mTalentDao.nbElements();
        }
    }


    public String selectName(Long id){
        try {
            return new TalentRepository.selectNameAsyncTask(mTalentDao).execute(id).get();
        }catch (Exception e){
            Log.d("mesTests","Problème selectName");
        }
        return null;
    }
    private static class selectNameAsyncTask extends AsyncTask<Long,Void,String>{
        private TalentDAO mAsyncTaskDao;

        selectNameAsyncTask(TalentDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected String doInBackground(final Long... params){
            return mAsyncTaskDao.selectName(params[0]);
        }
    }



}
