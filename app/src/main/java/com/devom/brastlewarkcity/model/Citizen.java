package com.devom.brastlewarkcity.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Citizen implements Parcelable {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("age")
    @Expose
    private int age;
    @SerializedName("weight")
    @Expose
    private float weight;
    @SerializedName("height")
    @Expose
    private float height;
    @SerializedName("hair_color")
    @Expose
    private String hairColor;
    @SerializedName("professions")
    @Expose
    private List<String> professions;
    @SerializedName("friends")
    @Expose
    private List<String> friends;

    public Citizen(int id, String name, String thumbnail, int age, float weight, float height, String hairColor, List<String> professions, List<String> friends) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.hairColor = hairColor;
        this.professions = professions;
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", hairColor='" + hairColor + '\'' +
                ", professions=" + professions +
                ", friends=" + friends +
                '}';
    }

    protected Citizen(Parcel in) {
        id = in.readInt();
        name = in.readString();
        thumbnail = in.readString();
        age = in.readInt();
        weight = in.readFloat();
        height = in.readFloat();
        hairColor = in.readString();
        if (in.readByte() == 0x01) {
            professions = new ArrayList<String>();
            in.readList(professions, String.class.getClassLoader());
        } else {
            professions = null;
        }
        if (in.readByte() == 0x01) {
            friends = new ArrayList<String>();
            in.readList(friends, String.class.getClassLoader());
        } else {
            friends = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(thumbnail);
        dest.writeInt(age);
        dest.writeFloat(weight);
        dest.writeFloat(height);
        dest.writeString(hairColor);
        if (professions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(professions);
        }
        if (friends == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(friends);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Citizen> CREATOR = new Parcelable.Creator<Citizen>() {
        @Override
        public Citizen createFromParcel(Parcel in) {
            return new Citizen(in);
        }

        @Override
        public Citizen[] newArray(int size) {
            return new Citizen[size];
        }
    };
}