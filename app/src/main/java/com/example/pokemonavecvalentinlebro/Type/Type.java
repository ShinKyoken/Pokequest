package com.example.pokemonavecvalentinlebro.Type;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "DBtype")
public class Type {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @NonNull
    private String name;

    public Type(@NonNull String nom) {
        this.name = nom;
    }


    public Type(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public static Type[] populateData() {
        return new Type[] {
                new Type("Aucun"),
                new Type("Eau"),
                new Type("Electrique"),
                new Type("Plante"),
                new Type("Sol"),
                new Type("Roche"),
                new Type("Dragon"),
                new Type("Acier"),
                new Type("Combat"),
                new Type("Fee"),
                new Type("Feu"),
                new Type("Glace"),
                new Type("Insecte"),
                new Type("Normal"),
                new Type("Poison"),
                new Type("Psy"),
                new Type("Spectre"),
                new Type("Tenebre"),
                new Type("Vol"),
        };
    }
}
