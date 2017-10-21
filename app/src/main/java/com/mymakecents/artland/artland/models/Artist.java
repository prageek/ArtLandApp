package com.mymakecents.artland.artland.models;

/**
 * Created by prageeth on 10/21/17.
 */

public class Artist implements IUser {

    private String mName;
    private int mRating;

    public Artist(String name, int mRating) {
        this.mName = name;
        this.mRating = mRating;
    }


    @Override
    public String getToken() {
        return null;
    }

    @Override
    public String getName() {
        return mName;
    }

    public int getmRating() {
        return mRating;
    }
}
