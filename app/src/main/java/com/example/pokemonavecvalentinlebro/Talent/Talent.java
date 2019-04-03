package com.example.pokemonavecvalentinlebro.Talent;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "DBtalent")
public class Talent {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long id;

    @NonNull
    private String name;


    public Talent(String nom) {
        this.name = nom;
    }

    public Talent(){

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

    public static Talent[] populateData() {
        return new Talent[] {
                new Talent("Aucun"),
                new Talent("Torrent"),
                new Talent("Acharne"),
                new Talent("Statik"),
                new Talent("Plus"),
                new Talent("Engrais"),
                new Talent("Pare-Balles"),
                new Talent("Paratonnerre"),
                new Talent("Solide Roc"),
                new Talent("Temeraire"),
                new Talent("Prognathe"),
                new Talent("Tete de roc"),
        };
    }
}
