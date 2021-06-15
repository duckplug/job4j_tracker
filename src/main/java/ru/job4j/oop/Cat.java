package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.print(this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {

        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.show();
        System.out.println(" eat Kotleta");

        Cat black = new Cat();
        black.giveNick("Black");
        black.show();
        System.out.println(" eat fish");
    }
}
