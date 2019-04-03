package com.example.pokemonavecvalentinlebro.Type;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pokemonavecvalentinlebro.Type.Type;

import java.util.List;

@Dao
public interface TypeDAO {
    @Query("Select * from DBtype where id=:typeId")
    Type getTypeById(int typeId);

    @Query("Select * from DBtype")
    LiveData<List<Type>> getAllType();

    @Query("Select name from DBtype where id=:id")
    String selectName(long id);

    @Insert
    void insertType(Type... types);

    @Update
    void updateType(Type... types);

    @Delete
    void deleteType(Type type);

    @Query("Delete from DBtype")
    void deleteAllType();

    @Query("SELECT count(*) from DBtype")
    int nbElements();
}
