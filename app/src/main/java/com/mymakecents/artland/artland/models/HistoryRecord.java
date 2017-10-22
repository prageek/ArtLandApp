package com.mymakecents.artland.artland.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by prageeth on 10/21/17.
 */

public class HistoryRecord implements Serializable {
    // Location
    // Description
    // Material
    // photos[]

    public String getmDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    private String mDescription;

    public HistoryRecord(String id) {
        this.mId = id;
    }

    public Date getmDateTime() {
        return mDateTime;
    }

    public void setmDateTime(Date mDateTime) {
        this.mDateTime = mDateTime;
    }

    private Date mDateTime;

    public Photo[] getmPhotos() {
        return mPhotos;
    }

    public void setmPhotos(Photo[] mPhotos) {
        this.mPhotos = mPhotos;
    }

    public String getLocationCordinates() {
        return locationCordinates;
    }

    public void setLocationCordinates(String locationCordinates) {
        this.locationCordinates = locationCordinates;
    }

    public Materials[] getmMaterials() {
        return mMaterials;
    }

    public void setmMaterials(Materials[] mMaterials) {
        this.mMaterials = mMaterials;
    }

    private Photo[] mPhotos;
    private String locationCordinates;
    private Materials[] mMaterials;

    public String getmId() {
        return mId;
    }

    private String mId;

}
