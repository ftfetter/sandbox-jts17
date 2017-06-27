package com.github.ftfetter.java.guice.petshop;

import com.github.ftfetter.java.guice.petshop.maps.MapPetInterface;
import com.github.ftfetter.java.guice.petshop.maps.MapPetServicesInterface;
import com.github.ftfetter.java.guice.petshop.maps.MapTopPetsInterface;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;

@Singleton
public class PetStoreService implements Services{


    private MapPetInterface mapPets;
    private MapPetServicesInterface petServices;
    private MapTopPetsInterface topPets;

    @Inject
    public PetStoreService(MapPetInterface mapPets, MapPetServicesInterface petServices, MapTopPetsInterface topPets) {
        this.mapPets = mapPets;
        this.petServices = petServices;
        this.topPets = topPets;
    }

    @Override
    public boolean addPet(int id, String name, String race, int age){

        if (id <= 0)
            return false;
        Pet pet = new Pet(id, name, race, age);
        if (petExists(pet.getId()))
            return false;
        else {
            mapPets.getMapPet().put(id, pet);
            petServices.getMapPetServices().put(name,new ArrayList<>());
            return true;
        }
    }

    @Override
    public boolean deletePet(int id){
        if(petExists(id)) {
            petServices.getMapPetServices().remove(mapPets.getMapPet().get(id).getName());
            mapPets.getMapPet().remove(id);
            return true;
        } else
            return false;
    }

    @Override
    public List<Pet> searchByAge(int age){
        List<Pet> petList = new ArrayList<>();

        for (Integer key : mapPets.getMapPet().keySet()) {
            if(mapPets.getMapPet().get(key).getAge() == age)
                petList.add(mapPets.getMapPet().get(key));
        }
        return petList;
    }

    @Override
    public String doBath(int id, int bathType) {
        String bath;
        String petName = mapPets.getMapPet().get(id).getName();

        switch (bathType){
            case 0:
                bath = "A dry and perfumed bath";
                break;
            case 1:
                bath = "A dry bath without perfume";
                break;
            case 2:
                bath = "A normal and perfumed bath";
                break;
            case 3:
                bath = "A normal bath without perfume";
                break;
            default:
                bath = "Invalid bath type.";
        }
        if (bathType>=0 && bathType<4)
            petServices.getMapPetServices().get(petName).add(bath);
        return bath;
    }

    @Override
    public String doHairCut(int id, int hairCutStyle) {

        String hairCut;
        String petName = mapPets.getMapPet().get(id).getName();

        switch (hairCutStyle){
            case 0:
                hairCut = "A short hair cut";
                break;
            case 1:
                hairCut = "A long hair cut";
                break;
            default:
                hairCut = "Invalid hair cut style.";
        }
        if (hairCutStyle>=0 && hairCutStyle<2)
            petServices.getMapPetServices().get(petName).add(hairCut);
        return hairCut;
    }

    @Override
    public void printServiceHistory(){
        for(String aux: petServices.getMapPetServices().keySet())
            System.out.println(aux +" done "+ petServices.getMapPetServices().get(aux));
    }

    @Override
    public void printTopPets(){

        setTopPets();

        for (Integer key : topPets.getMapTopPets().keySet()) {
            for (int i=0; i<topPets.getMapTopPets().get(key).size(); i++)
                System.out.println(topPets.getMapTopPets().get(key).get(i));
        }
    }

    private boolean petExists(int id){
        return mapPets.getMapPet().containsKey(id);
    }

    private void setTopPets(){
        int nServices;

        topPets.getMapTopPets().clear();

        for (String key : petServices.getMapPetServices().keySet()) {
            nServices = petServices.getMapPetServices().get(key).size();
            if (!topPets.getMapTopPets().containsKey(nServices))
                topPets.getMapTopPets().put(nServices, new ArrayList<>());
            topPets.getMapTopPets().get(nServices).add(key);
        }
    }
}
