package ru.job4j.oop;

public class Doctor extends Profession {
    private String disease;

    public Doctor(String name, String surname, String education, int birthday, String diseases) {
        super(name, surname, education, birthday);
        this.disease = diseases;
    }

    public String getDisease() {
        return disease;
    }

    public void diagnostics() {
    }

}
