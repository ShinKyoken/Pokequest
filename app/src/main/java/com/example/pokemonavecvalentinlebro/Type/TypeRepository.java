package com.example.pokemonavecvalentinlebro.Type;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.pokemonavecvalentinlebro.Databaser;
import com.example.pokemonavecvalentinlebro.Type.Type;
import com.example.pokemonavecvalentinlebro.Type.TypeDAO;

import java.util.List;



public class TypeRepository {
    private TypeDAO mTypeDao;
    private LiveData<List<Type>> mAllTypes;

    TypeRepository(Application application){
        Databaser db = Databaser.getInstance(application);
        mTypeDao=db.typeDAO();
        mAllTypes=mTypeDao.getAllType();
    }

    LiveData<List<Type>> getmAllTypes(){
        return mAllTypes;
    }

    public void insert(Type type){
        new insertAsyncTask(mTypeDao).execute(type);
    }

    private static class insertAsyncTask extends AsyncTask<Type,Void,Void>{
        private TypeDAO mAsyncTaskDao;

        insertAsyncTask(TypeDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Type... params){
            mAsyncTaskDao.insertType(params[0]);
            return null;
        }
    }

    public void delete(Type type){
        new deleteAsyncTask(mTypeDao).execute(type);
    }

    private static class deleteAsyncTask extends AsyncTask<Type,Void,Void>{
        private TypeDAO mAsyncTaskDao;

        deleteAsyncTask(TypeDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected Void doInBackground(final Type... params){
            mAsyncTaskDao.deleteType(params[0]);
            return null;
        }
    }

    public void deleteAll(){
        new deleteAllAsyncTask(mTypeDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<Void,Void,Void>{
        private TypeDAO mAsyncTaskDao;

        deleteAllAsyncTask(TypeDAO typeDao){
            mAsyncTaskDao = typeDao;
        }

        @Override
        protected Void doInBackground(Void... params){
            mAsyncTaskDao.deleteAllType();
            return null;
        }
    }

    public Integer getNbElements(){
        try{
            return new getNbElementsAsync(mTypeDao).execute().get();
        }catch (Exception e){
            Log.d("mesTests","Problème getNbElements");
        }
        return null;
    }

    private static class getNbElementsAsync extends AsyncTask<Void,Void,Integer>{
        private TypeDAO mTypeDao;

        getNbElementsAsync(TypeDAO typeDao){
            mTypeDao=typeDao;
        }

        @Override
        protected Integer doInBackground(Void... params){
            return mTypeDao.nbElements();
        }
    }

    public String selectName(Long id){
        try {
            return new selectNameAsyncTask(mTypeDao).execute(id).get();
        }catch (Exception e){
            Log.d("mesTests","Problème selectName");
        }
        return null;
    }

    private static class selectNameAsyncTask extends AsyncTask<Long,Void,String>{
        private TypeDAO mAsyncTaskDao;

        selectNameAsyncTask(TypeDAO dao){
            mAsyncTaskDao=dao;
        }

        @Override
        protected String doInBackground(final Long... params){
            return mAsyncTaskDao.selectName(params[0]);
        }
    }



}
