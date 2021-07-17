package ru.job4j.oop;

public class Pediatrician extends Doctor {
   private String prescription;

public Pediatrician(String name, String surname, String education, int birthday, String diseases, String prescription) {
    super(name, surname, education, birthday, diseases);
    this.prescription = prescription;
    }

}
