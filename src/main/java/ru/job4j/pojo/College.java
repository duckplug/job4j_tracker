package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
            student.setFullName("Okolelov Anton Alexeevich");
            student.setGroup("FF-1");
            student.setAdmission("01.01.2020");

        System.out.println("Студент: " + student.getFullName() + System.lineSeparator()
                + "Группа: " + student.getGroup() + System.lineSeparator()
                + "Дата поступления: " + student.getAdmission() + System.lineSeparator());
    }
}