package com.mymakecents.artland.artland.models;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prageeth on 10/21/17.
 */

public class Artwork implements Serializable {
    public String getmId() {
        return mId;
    }

    private String mId;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    private int photoId;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    private String artistName;

    public List<HistoryRecord> getmHistoryRecords() {
        return mHistoryRecords;
    }

    public void addHistoryRecords(HistoryRecord historyRecords) {
        this.mHistoryRecords.add(historyRecords);
    }

    private List<HistoryRecord> mHistoryRecords;

    public Artwork(String mId) {
        this.mId = mId;
        this.mHistoryRecords = new ArrayList<>();
    }
}
