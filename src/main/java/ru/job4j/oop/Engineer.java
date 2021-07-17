package ru.job4j.oop;

public class Engineer extends Profession {
    private int rank;

    public Engineer(String name, String surname, String education, int birthday, int rank) {
        super(name, surname, education, birthday);
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

}
