package com.example.pokemonavecvalentinlebro.Pokemon;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.pokemonavecvalentinlebro.Talent.Talent;
import com.example.pokemonavecvalentinlebro.Type.Type;

import io.reactivex.annotations.NonNull;

@Entity(tableName ="DBpokemon",
        foreignKeys = {
        @ForeignKey(entity = Talent.class,
                parentColumns = "id",
                childColumns = "idTalent1"),
        @ForeignKey(entity = Talent.class,
                parentColumns = "id",
                childColumns = "idTalent2"),
        @ForeignKey(entity = Talent.class,
                parentColumns = "id",
                childColumns = "idTalentCache"),
        @ForeignKey(entity = Type.class,
                parentColumns = "id",
                childColumns = "idType1"),
        @ForeignKey(entity = Type.class,
                parentColumns = "id",
                childColumns = "idType2")
        })

public class Pokemon {

    @PrimaryKey
    @NonNull
    private int id;

    @NonNull
    @ColumnInfo(name="idTalentCache", index=true)
    private long idTalentCache;

    @NonNull
    @ColumnInfo(name="idType1", index=true)
    private long idType1;

    @NonNull
    @ColumnInfo(name="idType2", index=true)
    private long idType2;

    @NonNull
    @ColumnInfo(name="idTalent1", index=true)
    private long idTalent1;

    @NonNull
    @ColumnInfo(name="idTalent2", index=true)
    private long idTalent2;

    @NonNull
    private String name,espece,image,stadeEvo;

    @NonNull
    private int  pv, atk, atkSpe, def, defSpe, vit;

    @NonNull
    private float poids,taille;


    public Pokemon(int id,String image, long idType1, long idType2, long idTalent1, long idTalent2, long idTalentCache, String name, String espece, String stadeEvo, int pv, int atk, int atkSpe, int def, int defSpe, int vit, float poids, float taille) {
        this.id=id;
        this.idType1 = idType1;
        this.idType2 = idType2;
        this.idTalent1 = idTalent1;
        this.idTalent2 = idTalent2;
        this.idTalentCache = idTalentCache;
        this.name = name;
        this.espece = espece;
        this.stadeEvo = stadeEvo;
        this.pv = pv;
        this.atk = atk;
        this.atkSpe = atkSpe;
        this.def = def;
        this.defSpe = defSpe;
        this.vit = vit;
        this.poids = poids;
        this.taille = taille;
        this.image = image;
    }

    @Ignore
    public Pokemon(){

    }


    public long getIdType1() {
        return idType1;
    }

    public void setIdType1(long idType1) {
        this.idType1 = idType1;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getIdType2() {
        return idType2;
    }

    public void setIdType2(long idType2) {
        idType2 = idType2;
    }

    public long getIdTalent1() {
        return idTalent1;
    }

    public void setIdTalent1(long idTalent1) {
        this.idTalent1 = idTalent1;
    }

    public long getIdTalent2() {
        return idTalent2;
    }

    public void setIdTalent2(long idTalent2) {
        this.idTalent2 = idTalent2;
    }

    public long getIdTalentCache() {
        return idTalentCache;
    }

    public void setIdTalentCache(long idTalentCache) {
        this.idTalentCache = idTalentCache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getStadeEvo() {
        return stadeEvo;
    }

    public void setStadeEvo(String stadeEvo) {
        this.stadeEvo = stadeEvo;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getAtkSpe() {
        return atkSpe;
    }

    public void setAtkSpe(int atkSpe) {
        this.atkSpe = atkSpe;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDefSpe() {
        return defSpe;
    }

    public void setDefSpe(int defSpe) {
        this.defSpe = defSpe;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static Pokemon[] populateData() {
        return new Pokemon[] {
                new Pokemon(394,"",2,1,2,1,3,"Prinplouf","Pingouin","Intermediaire",64,66,81,68,76,50,(float)23.0,(float)0.8),
                new Pokemon(180,"",3,1,4,1,5,"Lainergie","Laine","Intermediaire",70,55,80,55,60,45,(float)13.3,(float)0.8),
                new Pokemon(650,"",4,1,6,1,7,"Marisson","Bogue","Base",56,61,48,65,45,38,(float)9.0,(float)0.4),
                new Pokemon(464,"",5,6,8,9,10,"Rhinastoc","Perceur","Final",115,140,55,130,55,40,(float)282.8,(float)2.4),
                new Pokemon(697,"",6,7,11,1,12,"Rexillius","Tyran","Final",82,121,69,119,59,71,(float)270.0,(float)2.5),
        };
    }


}

