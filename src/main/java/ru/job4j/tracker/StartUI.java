package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item time = new Item();
        LocalDateTime timer = time.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String timerFor = timer.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + timerFor);

    }
}


