package com.github.ftfetter.java.guice.petshop;

import com.google.inject.Inject;

public class Pet {

    private int id;
    private String name;
    private String race;
    private int age;

    public Pet(int id, String name, String race, int age){
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }
}
