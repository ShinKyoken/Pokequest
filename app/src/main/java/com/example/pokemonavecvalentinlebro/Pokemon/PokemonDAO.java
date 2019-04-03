package com.example.pokemonavecvalentinlebro.Pokemon;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.pokemonavecvalentinlebro.Pokemon.Pokemon;

import java.util.List;

@Dao
public interface PokemonDAO {
    @Query("Select * from DBpokemon where id=:pokemonId")
    Pokemon getPokemonById(int pokemonId);

    @Query("Select * from DBpokemon")
    LiveData<List<Pokemon>> getAllPokemon();

    @Query("Select id from DBpokemon ")
    LiveData<List<Integer>> getAllId();

    @Insert
    void insertPokemon(Pokemon... pokemons);

    @Update
    void updatePokemon(Pokemon... pokemons);

    @Delete
    void deletePokemon(Pokemon pokemon);

    //TALENT
    @Query("Delete from DBpokemon where idTalent1=:id and idTalent2=:id /*and idTalentCache=1*/")
    void deleteIdTalent(long id);

    @Query("UPDATE DBpokemon SET idTalent1 = idTalent2, idTalent2=1 WHERE  idTalent1=:id and idTalent2!=:id")
    void updateIdTalent1By2(long id);

    @Query("SELECT count(*) from DBpokemon where (idTalent1=:id and idTalent2=:id) or (idTalent1=:id and idTalent2=1)")
    int nbDeletePokemonTalent(long id);


    @Query("UPDATE DBpokemon SET idTalent1 = idTalentCache,idTalentCache=idTalent1 WHERE idTalent2=:id and idTalentCache!=:id")
    void updateIdTalent1ByCache(long id);

    @Query("UPDATE DBpokemon SET idTalent1 = 1 WHERE idTalent1=:id")
    void updateIdTalent1(long id);

    @Query("UPDATE DBpokemon SET idTalent2 = 1 WHERE idTalent2=:id")
    void updateIdTalent2(long id);

    @Query("UPDATE DBpokemon SET idTalentCache = 1 WHERE idTalentCache=:id")
    void updateIdTalentCache(long id);

    //TYPE
    @Query("Delete from DBpokemon where idType1=:id and idType2=:id")
    void deleteIdType(long id);

    @Query("SELECT count(*) from DBpokemon where (idType1=:id and idType2=:id) or (idType1=:id and idType2=1)")
    int nbDeletePokemonType(long id);

    @Query("UPDATE DBpokemon SET idType1 = 1 WHERE idType1=:id")
    void updateIdType1(long id);

    @Query("UPDATE DBpokemon SET idType2 = 1 WHERE idType2=:id")
    void updateIdType2(long id);

    @Query("UPDATE DBpokemon SET idType1 = idType2, idType2=1 WHERE idType1=:id and idType2!=:id")
    void updateIdType1By2(long id);







    @Query("Delete from DBpokemon")
    void deleteAllPokemon();

    @Query("SELECT count(*) from DBpokemon")
    int nbElements();
}
