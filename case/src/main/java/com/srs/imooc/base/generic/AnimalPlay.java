package com.srs.imooc.base.generic;

import java.util.ArrayList;
import java.util.List;

public class AnimalPlay {


    public void playTest(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.paly();
        }
    }

    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("巴迪"));
        dogList.add(new Dog("豆豆"));

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("花花"));
        catList.add(new Cat("凡凡"));

        AnimalPlay play = new AnimalPlay();
        play.playTest(dogList);
        play.playTest(catList);
    }

}
