package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "{" + System.lineSeparator() + "\t " + "\"" + "name" + "\"" + " : " + name + "," + System.lineSeparator() + "\t " + "\"" + "body" + "\"" + " : " + body + System.lineSeparator() + "}";
    }

    public static void main(String[] args) {
       JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}