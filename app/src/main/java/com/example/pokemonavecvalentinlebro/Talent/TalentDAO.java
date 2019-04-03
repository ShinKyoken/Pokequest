package com.example.pokemonavecvalentinlebro.Talent;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pokemonavecvalentinlebro.Talent.Talent;

import java.util.List;

@Dao
public interface TalentDAO {
    @Query("Select * from DBtalent where id=:talentId")
    Talent getTalentById(int talentId);

    @Query("Select * from DBtalent")
    LiveData<List<Talent>> getAllTalent();

    @Query("Select name from DBtalent where id=:id")
    String selectName(long id);

    @Insert
    void insertTalent(Talent... talents);

    @Update
    void updateTalent(Talent... talents);

    @Delete
    void deleteTalent(Talent talent);

    @Query("Delete from DBtalent")
    void deleteAllTalent();

    @Query("SELECT count(*) from DBtalent")
    int nbElements();
}
