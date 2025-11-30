package de.phl.programmingproject.petadoption;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Haustier erstellen
        Pet pet = new Pet("Buddy", 3, "Labrador Retriever");

        // Adoptierende erstellen
        Adopter adopter = new Adopter("Jane Smith", "555-555-5555", "janesmith@email.com");

        // Infos ausgeben
        System.out.println("Haustier-Infos: " + pet.getInfo());
        System.out.println("Adoptierende-Infos: " + adopter.getInfo());

        // Adoptionsstatus prüfen
        System.out.println("Ist Buddy adoptiert? " + pet.isAdopted());

        // Adoption durchführen
        Date today = new Date();
        Adoption adoption = pet.adopt(adopter, today);

        // Adoptionsinfo ausgeben
        System.out.println("Adoptions-Infos: " + adoption.getInfo());

        // Adoptionsstatus erneut prüfen
        System.out.println("Ist Buddy jetzt adoptiert? " + pet.isAdopted());
    }
}
