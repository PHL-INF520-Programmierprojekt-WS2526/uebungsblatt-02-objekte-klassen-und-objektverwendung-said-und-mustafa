package de.phl.programmingproject.petadoption;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adoption {
    private Pet pet;
    private Adopter adopter;
    private Date date;

    public Adoption(final Pet pet, final Adopter adopter, final Date date) {
        this.pet = pet;
        this.adopter = adopter;
        this.date = date;
    }

    public String getInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "Pet: " + pet.getName() + ", Adopter: " + adopter.getName() + ", Date: " + sdf.format(date);
    }
}