package org.iesch.a02_registro_de_superheroes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperHero implements Parcelable {

    protected SuperHero(Parcel in) {
        name = in.readString();
        alterEgo = in.readString();
        bio = in.readString();
        power = in.readFloat();
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    private String name;
    private String alterEgo;
    private String bio;
    private float power;

    public SuperHero(String name, String alterEgo, String bio, float power) {
        this.name = name;
        this.alterEgo = alterEgo;
        this.bio = bio;
        this.power = power;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(alterEgo);
        parcel.writeString(bio);
        parcel.writeFloat(power);
    }
}
