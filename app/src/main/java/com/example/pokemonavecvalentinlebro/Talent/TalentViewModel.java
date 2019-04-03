package com.example.pokemonavecvalentinlebro.Talent;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Talent.TalentRepository;

import java.util.List;


public class TalentViewModel extends AndroidViewModel {
    private TalentRepository mRepository;

    private LiveData<List<Talent>> mAllTalents;

    public TalentViewModel(Application application){
        super(application);
        mRepository=new TalentRepository(application);
        mAllTalents=mRepository.getmAllTalents();
    }

    public LiveData<List<Talent>> getmAllTalents(){
        return mAllTalents;
    }

    public void insert(Talent talent){
        mRepository.insert(talent);
    }

    public void delete(Talent talent){
        mRepository.delete(talent);
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
