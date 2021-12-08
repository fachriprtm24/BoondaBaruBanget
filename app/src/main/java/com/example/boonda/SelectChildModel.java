package com.example.boonda;

class SelectChildModel {
    private String image, childName;

    public SelectChildModel(){

    }

    public SelectChildModel(String image, String name) {
        this.image = image;
        this.childName = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}
