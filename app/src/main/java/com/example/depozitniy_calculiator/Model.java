package com.example.depozitniy_calculiator;

public class Model {

    private float vklad;
    private  float percent;

    public Model(float vklad, float percent) {
        this.vklad = vklad;
        this.percent = percent;
    }

    public float getVklad() {
        return vklad;
    }

    public float getPercent() {
        return percent;
    }
}
