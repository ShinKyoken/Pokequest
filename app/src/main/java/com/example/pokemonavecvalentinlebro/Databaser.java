package com.example.pokemonavecvalentinlebro;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.pokemonavecvalentinlebro.Pokemon.Pokemon;
import com.example.pokemonavecvalentinlebro.Pokemon.PokemonDAO;
import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Talent.TalentDAO;
import com.example.pokemonavecvalentinlebro.Type.Type;
import com.example.pokemonavecvalentinlebro.Type.TypeDAO;

import java.util.concurrent.Executors;

@Database(entities = {Pokemon.class, Talent.class, Type.class}, version = 1, exportSchema = false)
public abstract class Databaser extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile Databaser INSTANCE;


    // --- DAO ---
    public abstract PokemonDAO pokemonDAO();
    public abstract TypeDAO typeDAO();
    public abstract TalentDAO talentDAO();

    // --- INSTANCE ---
    public static Databaser getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (Databaser.class) {
                if (INSTANCE == null) {
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static Databaser buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                Databaser.class,
                "my-database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).talentDAO().insertTalent(Talent.populateData());
                                getInstance(context).typeDAO().insertType(Type.populateData());
                                getInstance(context).pokemonDAO().insertPokemon(Pokemon.populateData());
                            }
                        });
                    }
                })
                .build();
    }

}
