package com.example.pokemonavecvalentinlebro.Type;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pokemonavecvalentinlebro.Type.Type;
import com.example.pokemonavecvalentinlebro.Type.TypeRepository;

import java.util.List;


public class TypeViewModel extends AndroidViewModel {
    private TypeRepository mRepository;

    private LiveData<List<Type>> mAllTypes;

    public TypeViewModel(Application application){
        super(application);
        mRepository=new TypeRepository(application);
        mAllTypes=mRepository.getmAllTypes();
    }

    public LiveData<List<Type>> getmAllTypes(){
        return mAllTypes;
    }

    public void insert(Type type){
        mRepository.insert(type);
    }

    public void delete(Type type){
        mRepository.delete(type);
    }

    public void deleteAll(){
        mRepository.deleteAll();
    }

    public Integer getNbElements(){
        return mRepository.getNbElements();
    }

    public String selectName(long id){
        return mRepository.selectName(id);
    }
}
