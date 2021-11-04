package com.example.boonda;

public class WeightModel {
    private String ages, date, weight;

    public WeightModel(){}

    public WeightModel(String ages, String date, String weight){
        this.ages = ages;
        this.date = date;
        this.weight = weight;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
