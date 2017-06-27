package com.github.ftfetter.java.guice.petshop;

import java.util.List;

public interface Services {

    boolean addPet(int id, String name, String race, int age);

    boolean deletePet(int id);

    List<Pet> searchByAge(int age);

    String doBath(int id, int bathType);

    String doHairCut(int id, int hairCutStyle);

    void printServiceHistory();

    void printTopPets();
}
