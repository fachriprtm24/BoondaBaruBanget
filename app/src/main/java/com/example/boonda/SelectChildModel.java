package com.example.boonda;

class SelectChildModel {
    private String photoProfile, childName;

    public SelectChildModel(){

    }

    public SelectChildModel(String image, String name) {
        this.photoProfile = image;
        this.childName = name;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
