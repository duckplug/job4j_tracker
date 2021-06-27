package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = this.load + another.load;
       this.load = 0;

    }

    public static void main(String[] args) {
        Battery first = new Battery(70);
        Battery second = new Battery(20);
        System.out.println("зарядить батарею #2 " + second.load + " от батареи #1 " + first.load);
        first.exchange(second);
        System.out.println("батарея #2: " + second.load + " батарея#1: " + first.load);

    }
}
