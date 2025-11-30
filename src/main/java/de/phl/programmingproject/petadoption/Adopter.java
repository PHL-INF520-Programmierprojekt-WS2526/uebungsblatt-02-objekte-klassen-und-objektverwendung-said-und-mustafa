package de.phl.programmingproject.petadoption;

public class Adopter {
    private String name;
    private String phone;
    private String email;

    public Adopter(final String name, final String phone, final String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getInfo() {
        return "Name: " + name + ", Telefon: " + phone + ", E-Mail: " + email;
    }

    public String getName() {
        return name;
    }
}
