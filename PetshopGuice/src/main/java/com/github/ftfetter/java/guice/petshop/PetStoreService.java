package com.github.ftfetter.java.guice.petshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetStoreService implements Service {

    private Map<Integer,Pet> petMap = new HashMap<>();
    private List<String> serviceHistory = new ArrayList<>();

    public boolean addPet(int id, String name, String race, int age){
        if (id <= 0)
            return false;
        Pet pet = new Pet(id, name, race, age);
        if (petMap.containsKey(pet.getId()))
            return false;
        else {
            petMap.put(id, pet);
            return true;
        }
    }

    public boolean deletePet(int id){
        if (id <= 0)
            return false;
        if(petMap.containsKey(id)) {
            petMap.remove(id);
            return true;
        } else
            return false;
    }
    
    public List<Pet> searchByAge(int age){
        List<Pet> petList = new ArrayList<>();
        for (int i=1; i<=petMap.size(); i++) {
            if(petMap.get(i).getAge() == age)
                petList.add(petMap.get(i));
        }
        return petList;
    }

    @Override
    public boolean doBath(int id) {

        serviceHistory.add("Bath on pet where id = "+ id);
        return true;
    }

    @Override
    public boolean doHairCut(int id) {

        serviceHistory.add("Hair cut on pet where id = "+ id);
        return true;
    }

    public void printServiceHistory(){
        for(int i=0; i<serviceHistory.size(); i++)
            System.out.println(serviceHistory.get(i));
    }
}
