package com.github.ftfetter.java.guice.petshop;

import com.github.ftfetter.java.guice.petshop.maps.MapPet;
import com.github.ftfetter.java.guice.petshop.maps.MapPetServices;
import com.github.ftfetter.java.guice.petshop.maps.MapTopPets;
import org.junit.Assert;
import org.junit.Test;
public class PetServiceTest {

    PetStoreService petStoreService = new PetStoreService(new MapPet(), new MapPetServices(), new MapTopPets());

    @Test
    public void testAddPet(){
        Assert.assertTrue(petStoreService.addPet(1,"Dogge","Shiba",3));
    }

    @Test
    public void testDeletePet(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        Assert.assertTrue(petStoreService.deletePet(1));
    }

    @Test
    public void testSearchByAge(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        petStoreService.addPet(2,"Catiorro","Akita",3);
        petStoreService.addPet(3,"Garibaldo","Yellow bird",10);
        Assert.assertEquals(2,petStoreService.searchByAge(3).size());
    }

    @Test
    public void testDoBath(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        Assert.assertEquals("A normal bath without perfume", petStoreService.doBath(1,3));
    }

    @Test
    public void testDoBathError(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        Assert.assertEquals("Invalid bath type.", petStoreService.doBath(1,4));
    }

    @Test
    public void testDoHairCut(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        Assert.assertEquals("A short hair cut", petStoreService.doHairCut(1,0));
    }

    @Test
    public void testDoHairCutError(){
        petStoreService.addPet(1,"Dogge","Shiba",3);
        Assert.assertEquals("Invalid hair cut style.", petStoreService.doHairCut(1,2));
    }
}
