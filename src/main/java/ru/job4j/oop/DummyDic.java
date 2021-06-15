package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String vol = "Неизвестное слово " + eng;
        return vol;
    }
    public static void main(String[] args) {
        DummyDic word = new DummyDic();
        String mus = word.engToRus("simultaneously");
        System.out.println(mus);
    }
}
