package ru.job4j.ooa;

final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        int engine = "A380".equals(name) ? COUNT_ENGINE : 2;
        System.out.println("Количество двигателей равно: " + engine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
