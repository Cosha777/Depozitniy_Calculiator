package com.example.depozitniy_calculiator;

public class UseCase {

    public double rashet(Model data){
        double summa = Math.ceil(data.getVklad() / 100 * (data.getPercent() - 1.95) / 12.16);
        return summa;
    }
}
