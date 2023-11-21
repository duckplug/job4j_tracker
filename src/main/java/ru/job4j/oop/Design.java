package ru.job4j.oop;

public class Design extends Engineer {
    private String size;
    private String material;

    public Design(String name, String surname, String education, int birthday,
                  int rank, String size, String material) {
        super(name, surname, education, birthday, rank);

        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void drawing() {
    }

    public void info() {
        Design anton = new Design("Anton", "Okolelov", "Engineer", 1995, 3, "20x20x20", "Iron");
        System.out.println(anton.getRank());
        anton.drawing();
    }
}


