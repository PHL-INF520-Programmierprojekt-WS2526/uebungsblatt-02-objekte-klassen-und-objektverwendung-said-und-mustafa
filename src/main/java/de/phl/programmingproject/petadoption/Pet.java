package de.phl.programmingproject.petadoption;

import java.util.Date;

public class Pet {
    private String name;
    private int age;
    private String breed;
    private boolean adopted;
    private Adoption adoption;

    public Pet(final String name, final int age, final String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.adopted = false;
        this.adoption = null;
    }

    public String getInfo() {
        return "Name: " + name + ", Alter: " + age + ", Rasse: " + breed;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public Adoption adopt(final Adopter adopter, final Date date) {
        if (!adopted) {
            adopted = true;
            adoption = new Adoption(this, adopter, date);
        }
        return adoption;
    }

    public String getName() {
        return name;
    }
}
